package org.mikhail.stackcalculator.calculator.common;

import org.mikhail.stackcalculator.exceptions.OperandsInterpretationException;

import javax.lang.model.SourceVersion;

public class CalculatorToken {
    private String stringValue;
    private Double doubleValue;

    public CalculatorToken(String stringValue) {
        this.stringValue = stringValue;
    }

    public CalculatorToken(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String toString() {
        if (stringValue == null) {
            stringValue = doubleValue.toString();
        }

        return stringValue;
    }

    public Double toDouble() throws OperandsInterpretationException {
        if (doubleValue != null) {
            return doubleValue;
        } else {
            try {
                doubleValue = Double.valueOf(stringValue);
                return doubleValue;
            } catch (NumberFormatException exception) {
                throw new OperandsInterpretationException(this);
            }
        }
    }

    public boolean isIdentifier() {
        return SourceVersion.isIdentifier(toString());
    }
}
