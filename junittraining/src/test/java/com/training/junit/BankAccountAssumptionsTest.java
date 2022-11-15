package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.junit.runtest.BankAccount;


@DisplayName("Test BankAccount assumptions")
public class BankAccountAssumptionsTest {
    
    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assumeTrue(bankAccount != null); ////<---- better for this case
        assertTrue(bankAccount.isActive());
        //assumeFalse(bankAccount == null);
        //assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
    }
}
