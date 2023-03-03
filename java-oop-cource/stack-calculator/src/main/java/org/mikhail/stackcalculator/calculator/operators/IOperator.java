package org.mikhail.stackcalculator.calculator.operators;

import org.mikhail.stackcalculator.calculator.ExecutionContext;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;
import org.mikhail.stackcalculator.exceptions.CalculationException;
import org.mikhail.stackcalculator.exceptions.ExecutionContextException;
import org.mikhail.stackcalculator.exceptions.OperationException;

import java.util.List;

public interface IOperator {
    void saveOperands(List<CalculatorToken> operands);

    void execute(ExecutionContext executionContext) throws ExecutionContextException, CalculationException, OperationException;

    String getOutput();
}
