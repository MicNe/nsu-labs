package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class AddTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Add operator = new Add();
        Double firstOperand = 1.1;
        Double secondOperand = 2.2;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(firstOperand);
        executionContext.getStack().push(secondOperand);
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(firstOperand + secondOperand, stack.peek())
        );
    }
}