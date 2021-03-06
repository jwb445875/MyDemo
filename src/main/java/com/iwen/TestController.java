package com.iwen;


import com.iwen.bookTicket.bean.Idm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@RequestMapping("/iwen")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("hello")
    public String hello() {
        logger.info("hello:tester");
        return "hello Iwen";
    }

    public static void main(String[] args) {
        Idm m=new Idm();
        m.setValue("cn","adasdas");
        System.out.print(m.getCn());
    }


}
