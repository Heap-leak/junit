package com.training.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BankAccountConditionalTest {
    
    @Test
    @EnabledOnOs({OS.MAC})
    void testMac () {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    void testWindows () {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_17})
    void testJRE () {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_16})
    void testNoJRE16 () {

    }
}
