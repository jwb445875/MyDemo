package com.iwen.listen;



import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import springfox.documentation.schema.configuration.ObjectMapperConfigured;


@Service
public class TestListener implements ApplicationListener {
    
    private static int i=1;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ObjectMapperConfigured){
            System.err.println("ObjectMapperConfigured:"+i++);
        }
        if (event instanceof ApplicationStartedEvent){
            System.err.println("================>ApplicationStartedEvent:"+i++);
        }
        if (event instanceof ContextRefreshedEvent){
            System.err.println("================>ContextRefreshedEvent:"+i++);
        }
        if (event instanceof ServletWebServerInitializedEvent){
            System.err.println("================>ServletWebServerInitializedEvent:"+i++);
        }
        if (event instanceof ContextClosedEvent){
            System.err.println("================>ContextClosedEvent:"+i++);
        }
        if (event instanceof ApplicationReadyEvent){
            System.err.println("================>ApplicationReadyEvent:"+i++);
        }
        if (event instanceof ContextClosedEvent){
            ContextClosedEvent a=(ContextClosedEvent)event;
            if(a.getApplicationContext().getParent()==null){
                System.err.println("================>ContextClosedEvent:"+i++);
            }
        }
    }
}
