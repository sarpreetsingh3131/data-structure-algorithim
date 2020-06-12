package org.sarpreet.stack;

import java.util.EmptyStackException;

public interface Stack {

    boolean isEmpty();

    int size();

    void push(int value);

    int pop() throws EmptyStackException;

    int peek() throws EmptyStackException;

    boolean contains(int value);

    String toString();
}
