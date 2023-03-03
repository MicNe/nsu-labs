package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

public class Pop extends OperatorWithoutOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws StackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) {
            throw new StackSizeException(1, stack);
        }

        Double valueToDelete = stack.pop();
        LOGGER.debug("The value " + valueToDelete + " removed from the stack");
    }
}
