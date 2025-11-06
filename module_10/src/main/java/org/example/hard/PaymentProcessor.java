package org.example.hard;

import java.math.BigDecimal;

public interface PaymentProcessor {
    void processPayment(BigDecimal amount);
}
