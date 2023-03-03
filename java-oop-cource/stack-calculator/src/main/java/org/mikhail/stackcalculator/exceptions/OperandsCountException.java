package org.mikhail.stackcalculator.exceptions;

import org.mikhail.stackcalculator.calculator.common.CalculatorToken;

import java.util.List;

public class OperandsCountException extends OperandsException {
    public OperandsCountException(int expectedOperandsCount, List<CalculatorToken> operands) {
        super("Expected operands count: " + expectedOperandsCount + ", actual operands count: " + operands.size(), operands);
    }
}
