package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

public class Print extends OperatorWithoutOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    private String output;

    @Override
    public void execute(ExecutionContext executionContext) throws StackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) {
            throw new StackSizeException(1, stack);
        }

        output = stack.peek().toString();
        LOGGER.debug("The output received: " + output);
    }

    @Override
    public String getOutput() {
        return output;
    }
}
