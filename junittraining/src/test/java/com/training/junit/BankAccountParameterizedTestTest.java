package com.training.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.training.junit.runtest.BankAccount;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
    
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("Depositing successfuly")
    void testDeposit(int amount, BankAccount bankAccount) throws InterruptedException {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    public void testDayOfWeek (DayOfWeek dayOfWeek) {
        assertTrue(dayOfWeek.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100, Mary", "200, Joe", "150, Ted"})
    public void depositAndNameTest(double amount, String name, BankAccount bankAccount) throws InterruptedException {
        bankAccount.deposit(amount);
        bankAccount.setBankAccountHolder(name);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(name, bankAccount.getBankAccountHolder());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "details.csv", delimiter = ';')
    public void depositAndNameFromFileTest(double amount, String name, BankAccount bankAccount) throws InterruptedException {
        bankAccount.deposit(amount);
        bankAccount.setBankAccountHolder(name);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(name, bankAccount.getBankAccountHolder());
    }
}
