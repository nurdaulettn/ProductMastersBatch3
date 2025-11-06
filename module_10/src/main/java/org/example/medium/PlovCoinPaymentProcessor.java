package org.example.medium;

import java.math.BigDecimal;

public class PlovCoinPaymentProcessor implements PaymentProcessor {
    public void processPayment(BigDecimal amount) {
        System.out.println("Оплачиваю через PlovCoin: " + amount);
    }
}
