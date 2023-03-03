package org.mikhail.stackcalculator.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.common.CalculatorOperation;
import org.mikhail.stackcalculator.calculator.factory.OperatorsFactory;
import org.mikhail.stackcalculator.calculator.operators.IOperator;
import org.mikhail.stackcalculator.exceptions.CalculatorException;
import org.mikhail.stackcalculator.exceptions.FactoryException;

public class OperationsExecutor {
    private static final Logger LOGGER = LogManager.getLogger();

    private final OperatorsFactory operatorsFactory;
    private final ExecutionContext executionContext = new ExecutionContext();

    public OperationsExecutor() throws FactoryException {
        operatorsFactory = new OperatorsFactory();
    }

    public void execute(CalculatorOperation calculatorOperation) throws CalculatorException, FactoryException {
        IOperator operator = operatorsFactory.getInstance(calculatorOperation.getOperatorName());
        operator.saveOperands(calculatorOperation.getOperands());
        operator.execute(executionContext);

        String operatorOutput = operator.getOutput();
        if (operatorOutput != null) {
            LOGGER.info("Output received: " + operatorOutput);
        }
    }
}
