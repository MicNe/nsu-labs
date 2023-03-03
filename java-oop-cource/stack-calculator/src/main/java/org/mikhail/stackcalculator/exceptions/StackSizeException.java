package org.mikhail.stackcalculator.exceptions;

import java.util.Stack;

public class StackSizeException extends StackException {
    public StackSizeException(int expectedStackSize, Stack<?> stack) {
        super("Expected stack size: " + expectedStackSize + ", actual stack size: " + stack.size());
    }
}
