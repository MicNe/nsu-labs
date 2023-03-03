package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class SubtractTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Subtract operator = new Subtract();
        Double firstOperand = 1.1;
        Double secondOperand = 2.2;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(firstOperand);
        executionContext.getStack().push(secondOperand);
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(secondOperand - firstOperand, stack.peek())
        );
    }
}