package org.mikhail.stackcalculator.calculator.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.operators.Add;
import org.mikhail.stackcalculator.calculator.operators.Define;
import org.mikhail.stackcalculator.calculator.operators.Divide;
import org.mikhail.stackcalculator.calculator.operators.Multiply;
import org.mikhail.stackcalculator.calculator.operators.Pop;
import org.mikhail.stackcalculator.calculator.operators.Print;
import org.mikhail.stackcalculator.calculator.operators.Push;
import org.mikhail.stackcalculator.calculator.operators.Sqrt;
import org.mikhail.stackcalculator.calculator.operators.Subtract;
import org.mikhail.stackcalculator.exceptions.FactoryException;

import static org.junit.jupiter.api.Assertions.*;

public class OperatorsFactoryTest {
    private static Logger LOGGER;
    private static OperatorsFactory operatorsFactory;

    @BeforeAll
    public static void setLogger() {
        System.setProperty("logback.configurationFile", "logback-test.xml");
        LOGGER = LogManager.getLogger();
    }

    @BeforeAll
    public static void initializeOperatorsFactory() {
        try {
            operatorsFactory = new OperatorsFactory();
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to initialize operators factory", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of PUSH operator")
    public void getInstanceOfPushOperator() {
        try {
            assertInstanceOf(Push.class, operatorsFactory.getInstance("PUSH"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of PUSH operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of POP operator")
    public void getInstanceOfPopOperator() {
        try {
            assertInstanceOf(Pop.class, operatorsFactory.getInstance("POP"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of POP operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of DEFINE operator")
    public void getInstanceOfDefineOperator() {
        try {
            assertInstanceOf(Define.class, operatorsFactory.getInstance("DEFINE"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of DEFINE operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of PRINT operator")
    public void getInstanceOfPrintOperator() {
        try {
            assertInstanceOf(Print.class, operatorsFactory.getInstance("PRINT"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of PRINT operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of + operator")
    public void getInstanceOfAddOperator() {
        try {
            assertInstanceOf(Add.class, operatorsFactory.getInstance("+"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of + operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of - operator")
    public void getInstanceOfSubtractOperator() {
        try {
            assertInstanceOf(Subtract.class, operatorsFactory.getInstance("-"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of - operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of * operator")
    public void getInstanceOfMultiplyOperator() {
        try {
            assertInstanceOf(Multiply.class, operatorsFactory.getInstance("*"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of * operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of / operator")
    public void getInstanceOfDivideOperator() {
        try {
            assertInstanceOf(Divide.class, operatorsFactory.getInstance("/"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of / operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of SQRT operator")
    public void getInstanceOfSqrtOperator() {
        try {
            assertInstanceOf(Sqrt.class, operatorsFactory.getInstance("SQRT"));
        } catch (FactoryException exception) {
            LOGGER.error("Impossible to get instance of SQRT operator", exception);
            fail();
        }
    }

    @Test
    @DisplayName("Getting instance of incorrect operator")
    public void getInstanceOfIncorrectOperator() {
        assertThrows(FactoryException.class, () -> operatorsFactory.getInstance("%"));
    }
}