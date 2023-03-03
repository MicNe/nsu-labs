package org.mikhail.stackcalculator.calculator.common;

import org.mikhail.stackcalculator.exceptions.OperationTokensException;

import java.util.List;

public class CalculatorOperation {
    private final String operatorName;
    private final List<CalculatorToken> operands;

    public CalculatorOperation(List<CalculatorToken> lineTokens) throws OperationTokensException {
        if (lineTokens == null || lineTokens.isEmpty()) {
            throw new OperationTokensException("A non-empty list of tokens was expected, but received " + lineTokens);
        }

        operatorName = lineTokens.get(0).toString();
        operands = lineTokens.subList(1, lineTokens.size());
    }

    public String getOperatorName() {
        return operatorName;
    }

    public List<CalculatorToken> getOperands() {
        return operands;
    }
}
