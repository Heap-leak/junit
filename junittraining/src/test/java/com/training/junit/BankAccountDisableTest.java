package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.training.junit.runtest.BankAccount;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountDisableTest {
    
    @Test
    @Disabled("Temporarily disabled due to maintenance")
    @DisplayName("Deposit 500 successfuly")
    void testDeposit(BankAccount bankAccount) throws InterruptedException {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

}
