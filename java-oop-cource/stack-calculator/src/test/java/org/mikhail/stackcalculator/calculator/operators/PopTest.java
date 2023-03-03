package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class PopTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Pop operator = new Pop();
        Double operand = 1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(operand);
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Stack<Double> stack = executionContext.getStack();
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("Incorrect execution")
    public void executeIncorrectly() {
        Pop operator = new Pop();

        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(StackSizeException.class, () -> operator.execute(executionContext));
    }
}