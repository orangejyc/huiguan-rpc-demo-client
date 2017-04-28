package com.huiguan.rpc.client;

import com.huiguan.rpc.api.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by ansoya on 2017/4/27.
 */
@SpringBootApplication
@ImportResource({ "spring/spring-config.xml" })
public class Bootstrap {



    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = null;
        try {
            long start = System.currentTimeMillis();
            ctx = SpringApplication.run(Bootstrap.class, args);
            long period = System.currentTimeMillis() - start;
            LOGGER.info("rpc-client start successfully in "+period+" ms.");
            ServiceCall serviceCall=(ServiceCall)ctx.getBean("serviceCall");
            User user=new User();
            user.setName("name");
            serviceCall.getUser(user);
            LOGGER.info(user.getName());
            //Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            LOGGER.error("rpc-client start error :", e);
            System.exit(-1);
        } finally{
            if(ctx !=null){
                ctx.close();
            }
        }
    }
}
