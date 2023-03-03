package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.CalculationException;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Sqrt operator = new Sqrt();
        Double operand = 1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(operand);
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(Math.sqrt(operand), stack.peek())
        );
    }

    @Test
    @DisplayName("Incorrect execution")
    public void executeIncorrectly() {
        Sqrt operator = new Sqrt();
        Double operand = -1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(operand);
        assertThrows(CalculationException.class, () -> operator.execute(executionContext));
    }
}