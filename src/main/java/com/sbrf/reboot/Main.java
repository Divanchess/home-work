package com.sbrf.reboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sbrf.reboot.spring.beans.annotations.*;
import com.sbrf.reboot.spring.beans.xml.*;

public class Main {
    public static void main(String[] args) {
        getClassPathXMLContext();
        getAnnotationConfigContext();
    }

    public static void getClassPathXMLContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        AccountXml account =  context.getBean("accountXmlConfig", AccountXml.class);
        ClientXml client =  context.getBean("clientXmlConfig", ClientXml.class);

        System.out.println(account);
        System.out.println(client);
    }

    public static void getAnnotationConfigContext(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAnnotation.class);
        AccountAnnotation account =  context.getBean("accountAnnotationConfig", AccountAnnotation.class);
        ClientAnnotation client =  context.getBean("clientAnnotationConfig", ClientAnnotation.class);

        System.out.println(account);
        System.out.println(client);
    }
}