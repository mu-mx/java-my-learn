package com.xwcom.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(CrudApplication.class, args);


        Dev bean = applicationContext.getBean(Dev.class);

        bean.test();

    }


}
