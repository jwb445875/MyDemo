package com.iwen.plan.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/26.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/plan/test")
public class TesttController {


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            DayOfWeek now=LocalDateTime.now().plusDays(i).getDayOfWeek();
            System.out.println(now.getValue());
        }

    }

    private static void testDate2() {
        LocalDateTime now=LocalDateTime.now().plusDays(45);
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
        DateTimeFormatter format1=DateTimeFormatter.ofPattern("yyyyMM");
        DateTimeFormatter format2=DateTimeFormatter.ofPattern("yyyy年M月");
        System.out.println(now.format(format1));
        System.out.println(now.format(format2));

        LocalDateTime lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.err.println(lastDay.format(format));
        System.err.println(lastDay.getDayOfMonth());
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
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
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
