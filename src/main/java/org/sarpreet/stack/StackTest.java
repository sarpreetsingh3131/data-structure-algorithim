package org.sarpreet.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    final int startRange = 0;
    final int endRange = 100;
    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack();
        //stack = new LinkedStack();
    }

    @Test
    void shouldBeEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void shouldNotBeEmpty() {
        fillStack();
        assertFalse(stack.isEmpty());
        assertEquals(endRange - startRange, stack.size());
    }

    @Test
    void shouldNotPopAndPeek() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void shouldPop() throws EmptyStackException {
        fillStack();
        IntStream.range(endRange - 1, startRange - 1)
                .forEach(i -> assertEquals(i, stack.pop()));
    }

    @Test
    void shouldPeek() throws EmptyStackException {
        IntStream.range(startRange, endRange)
                .forEach(this::pushAndAssertPeak);
    }

    @Test
    void shouldNotContains() {
        fillStack();
        assertFalse(stack.contains(endRange * 2));
    }

    @Test
    void shouldContains() {
        fillStack();
        assertTrue(stack.contains(endRange - 1));
    }

    private void fillStack() {
        IntStream.range(startRange, endRange)
                .forEach(i -> stack.push(i));
    }

    private void pushAndAssertPeak(int value) {
        stack.push(value);
        assertEquals(value, stack.peek());
    }
}
