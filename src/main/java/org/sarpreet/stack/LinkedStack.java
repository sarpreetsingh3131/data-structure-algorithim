package org.sarpreet.stack;

import org.sarpreet.util.Node;

import java.util.EmptyStackException;

class LinkedStack implements Stack {

    private Node head = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return head == null && size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(int value) {
        Node node = new Node(value);
        if (!isEmpty()) {
            node.next = head;
        }
        head = node;
        size++;
    }

    @Override
    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public int peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.value;
    }

    @Override
    public boolean contains(int value) {
        Node temp =  head;
        while (temp != null) {
            if (temp.value == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            int value = temp.value;
            stringBuilder.append(value + " ");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}
