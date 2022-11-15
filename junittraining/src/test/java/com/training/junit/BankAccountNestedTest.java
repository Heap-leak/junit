package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.training.junit.runtest.BankAccount;

@DisplayName("Nested test")
public class BankAccountNestedTest {

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
    
    @Nested
    class WhenBalanceEqualsZero {

        @Test
        @DisplayName("Withdrawing below minimum balance: exception")
        public void testWithdrawMinimumBalanceIs0 () {
            BankAccount bankAccount = new BankAccount(500, 0);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));

        }

        @Test
        @DisplayName("Withdrawing and getting a negative balance: exception")
        public void testWithdrawMinimumBalanceNegative1000 () {
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }
    }
}
