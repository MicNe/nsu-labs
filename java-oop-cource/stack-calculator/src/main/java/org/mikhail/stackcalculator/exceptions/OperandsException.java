package org.mikhail.stackcalculator.exceptions;

import org.mikhail.stackcalculator.calculator.common.CalculatorToken;

public class OperandsException extends OperationException {
    public OperandsException(String message) {
        super(message);
    }

    public OperandsException(String message, Iterable<CalculatorToken> operands) {
        super(message + " (operands received: " + operands.toString() + ")");
    }
}
