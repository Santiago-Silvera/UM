package uy.edu.um.prog2.tad.linkedlist;

import java.util.EmptyStackException;

public interface MyStack<T> {
    void pop() throws EmptyStackException;
    T top() throws EmptyStackException;
    void push(T element);
    boolean isEmpty();
    void makeEmpty();
}
