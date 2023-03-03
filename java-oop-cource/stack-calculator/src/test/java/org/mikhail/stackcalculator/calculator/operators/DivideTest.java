package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.CalculationException;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Divide operator = new Divide();
        Double firstOperand = 1.0;
        Double secondOperand = 2.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(firstOperand);
        executionContext.getStack().push(secondOperand);
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(secondOperand / firstOperand, stack.peek())
        );
    }

    @Test
    @DisplayName("Incorrect execution")
    public void executeIncorrectly() {
        Divide operator = new Divide();
        Double firstOperand = 0.0;
        Double secondOperand = 1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(firstOperand);
        executionContext.getStack().push(secondOperand);
        assertThrows(CalculationException.class, () -> operator.execute(executionContext));
    }
}