package com.iwen;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@RequestMapping("/iwen")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("hello")
    public String hello() {
        logger.info("hello:tester");
        return "hello Iwen";
    }


}
