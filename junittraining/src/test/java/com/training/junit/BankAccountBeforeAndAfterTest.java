package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.training.junit.runtest.BankAccount;

@TestInstance(Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll
    void init() {
        System.out.println("Hi!");
        bankAccount = new BankAccount(500, 0);
    }

    // @BeforeAll
    // static void init() {
    //     System.out.println("Hi!");
    //     bankAccount = new BankAccount(500, 0);
    // }

    // @BeforeEach
    // void init() {
    //     System.out.println("Hi!");
    //     bankAccount = new BankAccount(500, 0);
    // }

    @Test
    @DisplayName("Withdraw 200 successfuly")
    void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfuly")
    void testDeposit() throws InterruptedException {
        bankAccount.deposit(500);
        assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    void post() {
        System.out.println("Buy!!!");
    }

    // @AfterAll
    // static void post() {
    //     System.out.println("Buy!!!");
    // }

    // @AfterEach
    // void post() {
    //     System.out.println("Buy!!!");
    // }
}
