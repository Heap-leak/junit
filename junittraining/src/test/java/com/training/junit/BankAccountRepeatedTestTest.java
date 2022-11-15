package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import com.training.junit.runtest.BankAccount;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTestTest {
    
    @RepeatedTest(5)
    @DisplayName("Deposit 500 successfuly")
    void testDeposit(BankAccount bankAccount) throws InterruptedException {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    @RepeatedTest(5)
    @DisplayName("Deposit 500 successfuly")
    void testDepositRepetitionInfo (BankAccount bankAccount, RepetitionInfo repetitionInfo) throws InterruptedException {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
        System.out.println("Nr: " + repetitionInfo.getCurrentRepetition());
    }
}
