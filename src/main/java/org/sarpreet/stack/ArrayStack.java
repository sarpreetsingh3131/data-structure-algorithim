package org.sarpreet.stack;

import org.sarpreet.util.Utility;

import static org.sarpreet.util.Utility.resize;

import java.util.EmptyStackException;
import java.util.stream.IntStream;

class ArrayStack implements Stack {

    private int[] values = new int[5];
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(int value) {
        if (values.length == size) {
            values = resize(values, size);
        }
        values[size++] = value;
    }

    @Override
    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return values[--size];
    }

    @Override
    public int peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return values[size - 1];
    }

    @Override
    public boolean contains(int value) {
        return IntStream.of(values)
                .anyMatch(val -> val == value);
    }

    @Override
    public String toString() {
        return Utility.toString(values, size);
    }
}
