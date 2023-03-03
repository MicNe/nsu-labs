package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

public class Subtract extends OperatorWithoutOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws StackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new StackSizeException(2, stack);
        }

        Double reduced = stack.pop();
        LOGGER.debug("The reduced value removed from the stack: " + reduced);
        Double subtracted = stack.pop();
        LOGGER.debug("The subtracted value removed from the stack: " + subtracted);

        Double result = reduced - subtracted;
        LOGGER.debug("The result received: " + result);

        stack.push(result);
        LOGGER.debug("The result added to the stack");
    }
}
