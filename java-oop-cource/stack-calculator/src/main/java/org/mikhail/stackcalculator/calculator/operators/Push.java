package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;
import org.mikhail.stackcalculator.exceptions.OperandsCountException;
import org.mikhail.stackcalculator.exceptions.OperandsException;
import org.mikhail.stackcalculator.exceptions.VariablesException;

public class Push extends OperatorWithOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws OperandsException, VariablesException {
        if (operands.size() != 1) {
            throw new OperandsCountException(1, operands);
        }

        CalculatorToken calculatorToken = operands.get(0);
        Double newValue;

        if (calculatorToken.isIdentifier()) {
            String identifier = calculatorToken.toString();
            LOGGER.debug("Receiving the value of " + identifier + "...");

            newValue = executionContext.getVariables().get(identifier);
            if (newValue == null) {
                throw new VariablesException("There is no variable \"" + identifier + "\"");
            }
        } else {
            LOGGER.debug("Converting the token to the double value...");
            newValue = calculatorToken.toDouble();
        }

        executionContext.getStack().push(newValue);
        LOGGER.debug("The value " + newValue + " pushed to the stack");
    }
}
