package org.mikhail.stackcalculator.calculator.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;
import org.mikhail.stackcalculator.exceptions.VariablesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DefineTest {
    @Test
    @DisplayName("Correct execution")
    public void executeCorrectly() {
        Define operator = new Define();
        String identifier = "identifier";
        Double value = 1.1;

        List<CalculatorToken> operands = new ArrayList<>();
        operands.add(new CalculatorToken(identifier));
        operands.add(new CalculatorToken(value));
        operator.saveOperands(operands);

        ExecutionContext executionContext = new ExecutionContext();
        assertDoesNotThrow(() -> operator.execute(executionContext));

        Map<String, Double> variables = executionContext.getVariables();
        assertEquals(value, variables.get(identifier));
    }

    @Test
    @DisplayName("Incorrect execution")
    public void executeIncorrectly() {
        Define operator = new Define();
        String identifier = "1";
        Double value = 1.0;

        List<CalculatorToken> operands = new ArrayList<>();
        operands.add(new CalculatorToken(identifier));
        operands.add(new CalculatorToken(value));
        operator.saveOperands(operands);

        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(VariablesException.class, () -> operator.execute(executionContext));
    }
}