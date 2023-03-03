package org.mikhail.stackcalculator.calculator.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.operators.IOperator;
import org.mikhail.stackcalculator.exceptions.FactoryException;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class OperatorsFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<String, String> operatorNamesToClassNames = new TreeMap<>();

    public OperatorsFactory() throws FactoryException {
        PropertiesParser propertiesParser = new PropertiesParser();
        try {
            propertiesParser.loadProperties();
            propertiesParser.saveProperties(operatorNamesToClassNames);
        } catch (IOException | NullPointerException exception) {
            throw new FactoryException("Impossible to read configuration file", exception);
        }
    }

    public IOperator getInstance(String operatorName) throws FactoryException {
        String className = operatorNamesToClassNames.get(operatorName);
        LOGGER.debug("Class name received: " + className);

        if (className == null) {
            throw new FactoryException("A correct operator name was expected, but received " + operatorName);
        }

        IOperator operator;
        try {
            Class<?> operatorClass = Class.forName(className);
            LOGGER.debug("Class received: " + operatorClass);

            operator = (IOperator)operatorClass.getDeclaredConstructor().newInstance();
            LOGGER.debug("Operator created: " + operator);
        } catch (ClassNotFoundException exception) {
            throw new FactoryException("Impossible to find class " + className, exception);
        } catch (ReflectiveOperationException exception) {
            throw new FactoryException("Impossible to find constructor for class " + className, exception);
        }

        return operator;
    }
}
