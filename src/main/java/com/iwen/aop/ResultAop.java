package com.iwen.aop;

import com.iwen.common.AppException;
import com.iwen.common.Constant;
import com.iwen.common.ErrorCode;
import com.iwen.common.HResult;
import com.iwen.util.JsonUtils;
import com.iwen.util.SignUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 返回值AOP封装
 */
@Component
@Aspect
@Order(2)
public class ResultAop {
    private final static Logger logger = LoggerFactory.getLogger(ResultAop.class);

    private boolean isEnableSign=false;
    private String signKey="Abc123";

    // 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(public * com.iwen.*.web..*.*(..))")
    public void pointCut() {}

    // 配置环绕通知,使用在方法aspect()上注册的切入点
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        logger.info("请求方法:{},请求开始时间(毫秒):{}", method, startTime);
        Object[] objs = joinPoint.getArgs();
        if(objs.length > 0 && !checkSign(objs[0])){
            return HResult.fail(ErrorCode.SIGN_ERROR.getMessage());
        }
        try{
            Object result = joinPoint.proceed();
            return parseResult(result);
        }catch(AppException e){
            return HResult.fail(ErrorCode.getErrorMessage(e.getCode()));
        }finally{
            long endTime = System.currentTimeMillis();
            logger.info("请求结束时间:{}, 总共花费时间:{}毫秒", endTime, endTime - startTime);
        }
    }


    // 处理返回值
    private Object parseResult(Object result){
        if(result instanceof HResult){
            return result;
        }
        if(result instanceof Integer){
            return HResult.fail(ErrorCode.getErrorMessage((Integer)result));
        }
        return HResult.success(result);
    }

    private boolean checkSign(Object args){
        if (args instanceof MultipartFile ||args instanceof ServletRequest ||args instanceof ServletResponse) {
            return true;
        }
        if(isEnableSign){
            Map<String, Object> params =(Map<String, Object>) JsonUtils.parseJSONStringToObject(args.toString(), Map.class)  ;
            // 签名验证通过
            if(SignUtil.checkSign(params, Constant.sign_key, signKey)){
                return true;
            }
            return false;
        }
        return true;
    }

}
