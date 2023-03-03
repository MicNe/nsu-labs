package org.mikhail.stackcalculator.exceptions;

import org.mikhail.stackcalculator.calculator.common.CalculatorToken;

public class OperandsInterpretationException extends OperandsException {
    public OperandsInterpretationException(CalculatorToken calculatorToken) {
        super("Impossible to interpret token \"" + calculatorToken.toString() + "\" as a number");
    }
}
