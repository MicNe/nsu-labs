package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.exceptions.StackSizeException;

import java.util.Stack;

public class Add extends OperatorWithoutOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws StackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new StackSizeException(2, stack);
        }

        Double firstSummand = stack.pop();
        LOGGER.debug("The first summand removed from the stack: " + firstSummand);
        Double secondSummand = stack.pop();
        LOGGER.debug("The second summand removed from the stack: " + secondSummand);

        Double result = firstSummand + secondSummand;
        LOGGER.debug("The result received: " + result);

        stack.push(result);
        LOGGER.debug("The result added to the stack");
    }
}
