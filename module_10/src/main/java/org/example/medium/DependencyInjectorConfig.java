package org.example.medium;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DependencyInjectorConfig {

    @Bean
    public PaymentProcessor paymentProcessor() {
        return new PlovCoinPaymentProcessor();
    }

    @Bean
    public BitcoinPaymentProcessor bitcoinPaymentProcessor() {
        return new BitcoinPaymentProcessor();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }
}
