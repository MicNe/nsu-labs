package org.mikhail.stackcalculator.exceptions;

public class CalculationException extends CalculatorException {
    public CalculationException(String message, Double operand) {
        super(message + " (operand: " + operand + ")");
    }

    public CalculationException(String message, Double firstOperand, Double secondOperand) {
        super(message + " (operands: " + firstOperand + ", " + secondOperand + ")");
    }
}
