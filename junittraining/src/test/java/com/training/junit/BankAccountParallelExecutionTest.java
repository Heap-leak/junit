package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import com.training.junit.runtest.BankAccount;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
class BankAccountParallelExecutionTest {
    
    @Test
    @DisplayName("Deposit 200 successfuly")
    void testDeposit1 (BankAccount bankAccount) throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(200);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 300 successfuly")
    void testDeposit2 (BankAccount bankAccount) throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfuly")
    void testDeposi3 (BankAccount bankAccount) throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(400);
        assertEquals(400, bankAccount.getBalance());
    }
}
