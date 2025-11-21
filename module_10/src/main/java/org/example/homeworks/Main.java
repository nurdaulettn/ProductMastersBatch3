package org.example.homeworks;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjection.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        greetingService.sayHello();
    }
}
