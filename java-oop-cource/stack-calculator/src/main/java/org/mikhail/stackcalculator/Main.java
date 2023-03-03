package org.mikhail.stackcalculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.OperationsExecutor;
import org.mikhail.stackcalculator.calculator.common.CalculatorOperation;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;
import org.mikhail.stackcalculator.exceptions.CalculatorException;
import org.mikhail.stackcalculator.exceptions.FactoryException;
import org.mikhail.stackcalculator.parsing.Lines;
import org.mikhail.stackcalculator.parsing.ReaderGetter;
import org.mikhail.stackcalculator.parsing.TokensParser;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        String inputFileName;
        if (args.length == 0) {
            inputFileName = null;
        } else if (args.length == 1) {
            inputFileName = args[0];
        } else {
            return;
        }

        Lines lines;
        ReaderGetter readerGetter = new ReaderGetter(inputFileName);
        try (Reader reader = readerGetter.getReader()) {
            LOGGER.debug("Reader received: " + reader.getClass().getName());

            lines = new Lines(reader);
            lines.read();
            LOGGER.debug("Lines received");
        } catch (IOException exception) {
            LOGGER.error("Impossible to read lines", exception);
            return;
        }

        OperationsExecutor operationsExecutor;
        try {
            operationsExecutor = new OperationsExecutor();
            LOGGER.debug("Operations executor initialized");
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to initialize operations executor", exception);
            return;
        }

        while (!lines.isEmpty()) {
            try {
                String nextLine = lines.getNextLine();

                List<CalculatorToken> lineTokens = TokensParser.getTokens(nextLine);
                LOGGER.debug("The line divided into tokens");
                if (lineTokens == null) {
                    LOGGER.debug("Comment line skipped");
                    continue;
                }

                CalculatorOperation calculatorOperation = new CalculatorOperation(lineTokens);
                LOGGER.debug("The operation \"" + calculatorOperation.getOperatorName() + "\" created from tokens");

                operationsExecutor.execute(calculatorOperation);
                LOGGER.debug("The operation \"" + calculatorOperation.getOperatorName() + "\" executed");
            } catch (IOException | CalculatorException | FactoryException exception) {
                LOGGER.error("Impossible execute operation", exception);
            }
        }
    }
}
