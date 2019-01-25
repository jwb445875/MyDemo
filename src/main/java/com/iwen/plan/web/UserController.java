package com.iwen.plan.web;

import com.iwen.common.HResult;
import com.iwen.plan.bean.TSUser;
import com.iwen.plan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

    @RequestMapping("getUser")
    public Object getUser(String account) {
        TSUser u=userService.getUserByAccount(account);
        return "hello"+u.getId();
    }



}
