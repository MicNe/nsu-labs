package org.mikhail.stackcalculator.calculator.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.exceptions.OperandsInterpretationException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTokenTest {
    @Test
    @DisplayName("String and string-based token comparison")
    public void compareStringAndStringBasedToken() {
        CalculatorToken calculatorToken = new CalculatorToken("token");

        assertEquals("token", calculatorToken.toString());
    }

    @Test
    @DisplayName("Double and double-based token comparison")
    public void compareDoubleAndDoubleBasedToken() {
        CalculatorToken calculatorToken = new CalculatorToken(1.1);

        assertDoesNotThrow(() -> assertEquals(1.1, calculatorToken.toDouble()));
    }

    @Test
    @DisplayName("Checking correct identifier for correctness")
    public void checkCorrectIdentifierForCorrectness() {
        CalculatorToken calculatorToken = new CalculatorToken("correct_identifier1");

        assertTrue(calculatorToken.isIdentifier());
    }

    @Test
    @DisplayName("Checking incorrect identifier for incorrectness")
    public void checkIncorrectIdentifierForIncorrectness() {
        assertAll(
                () -> assertFalse(new CalculatorToken(1.1).isIdentifier()),
                () -> assertFalse(new CalculatorToken("1").isIdentifier()),
                () -> assertFalse(new CalculatorToken("1incorrect_identifier").isIdentifier()),
                () -> assertFalse(new CalculatorToken("&").isIdentifier())
        );
    }

    @Test
    @DisplayName("Conversion string-based token to double")
    public void convertStringBasedTokenToDouble() {
        CalculatorToken calculatorToken = new CalculatorToken("token");

        assertThrows(OperandsInterpretationException.class, calculatorToken::toDouble);
    }
}