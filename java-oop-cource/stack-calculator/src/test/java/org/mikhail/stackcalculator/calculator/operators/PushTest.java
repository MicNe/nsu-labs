package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;
import org.mikhail.stackcalculator.exceptions.VariablesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class PushTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Push operator = new Push();
        Double operand = 1.0;

        List<CalculatorToken> operands = new ArrayList<>();
        operands.add(new CalculatorToken(operand));
        operator.saveOperands(operands);

        ExecutionContext executionContext = new ExecutionContext();
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(operand, stack.peek())
        );
    }

    @Test
    @DisplayName("Incorrect execution")
    public void executeIncorrectly() {
        Push operator = new Push();
        String operand = "operand";

        List<CalculatorToken> operands = new ArrayList<>();
        operands.add(new CalculatorToken(operand));
        operator.saveOperands(operands);

        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(VariablesException.class, () -> operator.execute(executionContext));
    }
}