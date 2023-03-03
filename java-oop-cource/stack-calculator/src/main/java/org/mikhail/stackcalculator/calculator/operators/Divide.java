package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.CalculationException;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

public class Divide extends OperatorWithoutOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws StackSizeException, CalculationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new StackSizeException(2, stack);
        }

        Double divisible = stack.pop();
        LOGGER.debug("The divisible value removed from the stack: " + divisible);
        Double divisor = stack.pop();
        LOGGER.debug("The divisor removed from the stack: " + divisor);

        Double result = divisible / divisor;
        LOGGER.debug("The result received: " + result);
        if (result.isInfinite() || result.isNaN()) {
            throw new CalculationException("Impossible to divide", divisible, divisor);
        }

        stack.push(result);
        LOGGER.debug("The result added to the stack");
    }
}
