package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class PrintTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Print operator = new Print();
        Double operand = 1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(operand);
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(operand.toString(), operator.getOutput())
        );
    }

    @Test
    @DisplayName("Incorrect execution")
    public void executeIncorrectly() {
        Print operator = new Print();

        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(StackSizeException.class, () -> operator.execute(executionContext));
    }
}