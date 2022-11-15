package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import com.training.junit.runtest.BankAccount;

// for all methods in class
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testDepositeTimeoutAssertation(BankAccount bankAccount) {
        try {
            Thread.sleep(200);
            bankAccount.deposit(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    void testDepositTimeoutAnnotation(BankAccount bankAccount) {
        try {
            Thread.sleep(200);  
            bankAccount.deposit(300);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        assertTimeout(Duration.ofMillis(400), () -> {
            Thread.sleep(10);
         });
    }
    
}
