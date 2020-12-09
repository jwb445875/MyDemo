package com.iwen.plan.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2018/11/26.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/plan/test")
public class TesttController {


    public static void main(String[] args) {
        testDate();
    }

    private static void testDate(){
        LocalDate today=LocalDate.now();
        System.out.println(today.toString());
        LocalDate tomorrow=today.plusDays(1);
        System.out.println(tomorrow.toString());
        LocalDate yestody=today.plusDays(-1);
        System.out.println(yestody.toString());
        LocalDate birthday=LocalDate.of(1991, 11, 19);
        System.out.println(birthday);

        LocalDateTime now=LocalDateTime.now().plusDays(3);
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.format(format));
    }

    private static void testChar(){
        String 新="21152";
        String 年="29677";
        String 快="24555";
        String 乐="20048";

        System.err.print((char) Integer.parseInt(新));
        System.err.print((char) Integer.parseInt(年));
        System.err.print((char) Integer.parseInt(快));
        System.err.print((char) Integer.parseInt(乐));

        String str="金文斌";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            System.out.println((int) c);
        }
    }


}
