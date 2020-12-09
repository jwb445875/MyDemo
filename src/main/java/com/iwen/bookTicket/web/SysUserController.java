package com.iwen.bookTicket.web;

import com.iwen.bookTicket.bean.SysUser;
import com.iwen.bookTicket.service.SycnIdmService;
import com.iwen.bookTicket.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/26.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/batms")
public class SysUserController {

    @Autowired
    private SycnIdmService sycnIdmService;

    @Autowired
    private SysUserService userService;


    @GetMapping("getUser")
    public Object getUser(String account) {
        SysUser u=userService.getUserByAccount(account);
        return "hello"+u.getId();
    }

    @GetMapping("getPhone")
    public Object getPhone(String account) {
        String phone;
        try {
             phone=sycnIdmService.getIdmPhone(account);
        }catch (Exception e){
            e.printStackTrace();
            phone=e.getLocalizedMessage();
        }
        return "phone:"+phone;
    }

    @GetMapping("upPhone")
    public Object upPhone() {
        int count=100;
        int i=1;
        while (count!=0){
            count=userService.upPhone(i);
            i++;
        }
        return "finish";
    }

    @GetMapping("upAll")
    public Object upAll() {
        userService.upAll();
        return "finish";
    }

}
