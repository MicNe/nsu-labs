package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

public class Multiply extends OperatorWithoutOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws StackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new StackSizeException(2, stack);
        }

        Double firstMultiplier = stack.pop();
        LOGGER.debug("The first multiplier removed from the stack: " + firstMultiplier);
        Double secondMultiplier = stack.pop();
        LOGGER.debug("The second multiplier removed from the stack: " + secondMultiplier);

        Double result = firstMultiplier * secondMultiplier;
        LOGGER.debug("The result received: " + result);

        stack.push(result);
        LOGGER.debug("The result added to the stack");
    }
}
