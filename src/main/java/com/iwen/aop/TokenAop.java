package com.iwen.aop;


import com.iwen.common.Constant;
import com.iwen.common.ErrorCode;
import com.iwen.common.HResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 验证token
 */
@Component
@Aspect
@Order(1)
public class TokenAop {
    private final static Logger logger = LoggerFactory.getLogger(TokenAop.class);
    private String appExcludeUrls="/login,/logout,/sso";
    private String appPrefixUrl="/iwen";

    // 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(public * com.iwen.*.web..*.*(..))")
    public void pointCut() {}

    // 配置环绕通知,使用在方法aspect()上注册的切入点
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestPath = request.getRequestURI();
        // 跳过不拦截地址
        if(checkUrl(requestPath)){
            return joinPoint.proceed();
        }
        String token = request.getHeader(Constant.access_token);
        // 验证token是否存在
        if(StringUtils.isEmpty(token)){
            return HResult.fail(ErrorCode.NO_TOKEN.getMessage());
        }
        logger.info("tokeAop token:{}", token);
//        String key = AppJedisKey.app_user_key + Constant.point + token;
//        String userInfoStr = JedisUtils.get(key);
//        if(StringUtils.isEmpty(userInfoStr)){
//            return HResult.fail(ErrorCode.OFF_LINE.getMessage());
//        }
       // 重新设置过期时间
       // JedisUtils.setExpire(key, Constant.expire_time);
        return joinPoint.proceed();
    }

    private boolean checkUrl(String requestPath){
        logger.info("requestpath :" + requestPath);
        List<String> excludeUrls = Arrays.asList(appExcludeUrls.split(Constant.comma));
        if(CollectionUtils.isEmpty(excludeUrls)){
            return false;
        }
        for(String excludeUrl : excludeUrls){
            String url = appPrefixUrl + excludeUrl;
            if(requestPath.contains(url)){
                return true;
            }
        }
        return false;
    }
}
