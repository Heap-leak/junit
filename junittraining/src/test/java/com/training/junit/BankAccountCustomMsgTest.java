package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.junit.runtest.BankAccount;

public class BankAccountCustomMsgTest {
    @Test
    @DisplayName("Deposit 500 successfuly")
    void testDeposit() throws InterruptedException {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw 500 successfuly")
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }
}
