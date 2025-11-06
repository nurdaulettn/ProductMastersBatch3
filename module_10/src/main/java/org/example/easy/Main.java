package org.example.easy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjection.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        greetingService.sayHello();
    }
}
