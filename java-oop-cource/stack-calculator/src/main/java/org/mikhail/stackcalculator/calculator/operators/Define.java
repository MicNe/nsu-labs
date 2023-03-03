package org.mikhail.stackcalculator.calculator.operators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;
import org.mikhail.stackcalculator.exceptions.OperandsCountException;
import org.mikhail.stackcalculator.exceptions.OperandsException;
import org.mikhail.stackcalculator.exceptions.VariablesException;

public class Define extends OperatorWithOperands {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(ExecutionContext executionContext) throws OperandsException, VariablesException {
        if (operands.size() != 2) {
            throw new OperandsCountException(2, operands);
        }

        CalculatorToken identifier = operands.get(0);
        if (!identifier.isIdentifier()) {
            throw new VariablesException("A correct variable name was expected, but received " + identifier);
        }

        Double value = operands.get(1).toDouble();
        LOGGER.debug("The value " + value + " for " + identifier + " received");

        executionContext.getVariables().put(identifier.toString(), value);
        LOGGER.debug("The identifier " + identifier + " and its value " + value + " put to the variables map");
    }
}
