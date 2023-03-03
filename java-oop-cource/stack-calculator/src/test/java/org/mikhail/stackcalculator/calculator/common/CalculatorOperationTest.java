package org.mikhail.stackcalculator.calculator.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.exceptions.OperationTokensException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorOperationTest {
    private final CalculatorToken operatorName = new CalculatorToken("PUSH");
    private final CalculatorToken operand = new CalculatorToken(1.0);
    private final List<CalculatorToken> calculatorTokens = new ArrayList<>();
    private CalculatorOperation calculatorOperation;

    @BeforeEach
    @Test
    @DisplayName("Creation correct operation")
    public void createCorrectOperation() {
        calculatorTokens.add(operatorName);
        calculatorTokens.add(operand);

        assertDoesNotThrow(() -> calculatorOperation = new CalculatorOperation(calculatorTokens));
    }

    @Test
    @DisplayName("Getting operator")
    public void getOperator() {
        assertEquals(operatorName.toString(), calculatorOperation.getOperatorName());
    }

    @Test
    @DisplayName("Getting operands")
    public void getOperands() {
        Object[] expectedOperands = calculatorTokens.subList(1, calculatorTokens.size()).toArray();
        Object[] actualOperands = calculatorOperation.getOperands().toArray();

        assertArrayEquals(expectedOperands, actualOperands);
    }

    @Test
    @DisplayName("Creating null operation")
    public void createNullOperation() {
        assertThrows(OperationTokensException.class, () -> new CalculatorOperation(null));
    }

    @Test
    @DisplayName("Creating operation with null list")
    public void createOperationWithNullList() {
        assertThrows(OperationTokensException.class, () -> new CalculatorOperation(new ArrayList<>()));
    }
}