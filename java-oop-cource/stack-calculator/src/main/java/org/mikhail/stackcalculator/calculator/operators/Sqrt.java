package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.CalculationException;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

public class Sqrt extends OperatorWithoutOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws StackSizeException, CalculationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) {
            throw new StackSizeException(1, stack);
        }

        Double value = stack.pop();
        LOGGER.debug("The value removed from the stack: " + value);

        Double result = Math.sqrt(value);
        LOGGER.debug("The result received: " + result);
        if (result.isInfinite() || result.isNaN()) {
            throw new CalculationException("Impossible to extract the square root", value);
        }

        stack.push(result);
        LOGGER.debug("The result added to the stack");
    }
}
