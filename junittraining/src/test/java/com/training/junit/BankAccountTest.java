package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.junit.runtest.BankAccount;

@DisplayName("Test BAnkAccount")
public class BankAccountTest {

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

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("BankAccount is active") 
    public void testIsActive() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertTrue(bankAccount.isActive());
        bankAccount.setActive(false);
        assertFalse(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set bank account holder")
    public void testSetHolderName() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.setBankAccountHolder("Joe");
        assertNotNull(bankAccount.getBankAccountHolder());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositeWithoutExceptions() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.withdraw(450), () -> bankAccount.deposit(200) );
    }

    @Test
    @DisplayName("Test speed deposite")
    public void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
    }
}
