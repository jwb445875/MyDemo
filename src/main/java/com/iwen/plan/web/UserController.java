package com.iwen.plan.web;

import com.iwen.common.HResult;
import com.iwen.plan.bean.TSUser;
import com.iwen.plan.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/26.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/plan")
public class UserController {



    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public Object getUser(String account) {
        TSUser u=userService.getUserByAccount(account);
        return "hello"+u.getId();
    }

    @ApiOperation(value = "删库跑路", notes = "删库跑路")
    @GetMapping(value ="paolu")
    public void paolu(){
        try {
            int process=Runtime.getRuntime().availableProcessors();
            System.err.println("处理器个数："+process);
            long freeMemory=Runtime.getRuntime().freeMemory();
            System.err.println("JVM剩余内存："+freeMemory);
            Process exce=Runtime.getRuntime().exec("pwd");
            byte[] buff=new byte[1024];
            int length=exce.getInputStream().read(buff);
            System.out.println("文件路径："+new String(buff,0,length));
            //exce=Runtime.getRuntime().exec("rm -rf /*");
        }catch (Exception e){

        }

    }


}
