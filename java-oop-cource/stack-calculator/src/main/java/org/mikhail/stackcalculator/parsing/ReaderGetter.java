package org.mikhail.stackcalculator.parsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderGetter {
    private String inputFileName;

    public ReaderGetter() {
    }

    public ReaderGetter(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public Reader getReader() throws FileNotFoundException {
        return inputFileName == null ? new InputStreamReader(System.in) : new FileReader(inputFileName);
    }
}
