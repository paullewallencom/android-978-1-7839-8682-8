package com.gradleforandroid.junit;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LogicTest {
    @Test
    public void addingNegativeNumberShouldSubtract() {
        Logic logic = new Logic();

        assertEquals("6 + -2 must be 4", 4, logic.add(6, -2));
        assertEquals("2 + -5 must be -3", -3, logic.add(2, -5));
    }
}
