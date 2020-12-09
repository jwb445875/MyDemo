package com.iwen.listen;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.err.println(">>>>>>>>>>>>>>>TestListener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.err.println(">>>>>>>>>>>>>>>TestListener destroyed");
    }
}
