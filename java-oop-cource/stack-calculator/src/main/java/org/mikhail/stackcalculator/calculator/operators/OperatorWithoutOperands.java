package org.mikhail.stackcalculator.calculator.operators;

import org.mikhail.stackcalculator.calculator.common.CalculatorToken;

import java.util.List;

public abstract class OperatorWithoutOperands extends BasicOperator {
    @Override
    public void saveOperands(List<CalculatorToken> operands) {
    }
}
