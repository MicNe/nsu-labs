package org.mikhail.stackcalculator.calculator.operators;

import org.mikhail.stackcalculator.calculator.common.CalculatorToken;

import java.util.List;

public abstract class OperatorWithOperands extends BasicOperator {
    protected List<CalculatorToken> operands;

    @Override
    public void saveOperands(List<CalculatorToken> operands) {
        this.operands = operands;
    }
}
