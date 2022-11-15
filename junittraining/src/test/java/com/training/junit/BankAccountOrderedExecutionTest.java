package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.junit.runtest.BankAccount;

//@DisplayName("Ordered test class")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BankAccountOrderedExecutionTest {

    static BankAccount bankAccount = new BankAccount(0, 0);

    @Test
    @Order(2)
    @DisplayName("Withdraw 500 successfuly")
    void testWithdraw() {
        //BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @Order(1)
    @DisplayName("Deposit 500 successfuly")
    void testDeposit() throws InterruptedException {
        //BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
