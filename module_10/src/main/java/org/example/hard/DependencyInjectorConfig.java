package org.example.hard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectorConfig {

    @Bean("plovCoin")
    public PaymentProcessor plovcoinPaymentProcessor() {
        return new PlovCoinPaymentProcessor();
    }

    @Bean("bitcoin")
    public PaymentProcessor bitcoinPaymentProcessor() {
        return new BitcoinPaymentProcessor();
    }

    @Bean("visa")
    public PaymentProcessor visaPaymentProcessor() {
        return new VisaCardPaymentProcessor();
    }

    @Bean("masterCard")
    public PaymentProcessor mastercardPaymentProcessor() {
        return new MasterCardPaymentProcessor();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }
}
