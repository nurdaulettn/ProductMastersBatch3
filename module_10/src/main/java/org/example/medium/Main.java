package org.example.medium;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(DependencyInjectorConfig.class);

        OrderService orderServiceSecond = context.getBean(OrderService.class);
        orderServiceSecond.makeOrder(BigDecimal.valueOf(15));
        BitcoinPaymentProcessor bitcoinPaymentProcessor = context.getBean(BitcoinPaymentProcessor.class);
        bitcoinPaymentProcessor.processPayment(BigDecimal.valueOf(15));
    }
}