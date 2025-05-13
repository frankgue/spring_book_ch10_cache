package com.wiley.beginningspring.ch10;

import com.wiley.beginningspring.ch10.config.ApplicationConfig;
import com.wiley.beginningspring.ch10.model.User;
import com.wiley.beginningspring.ch10.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);

        User userFetch2 = userService.getUser(2);
        System.out.println(userFetch2);

    }
}
