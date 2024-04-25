package uy.edu.um.prog2.tad.linkedlist;

import java.util.EmptyStackException;

public class Stack<T extends Comparable<T>> implements MyStack<T>{
    ListaEnlazada<T> lista;

    @Override
    public void pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        lista.remove(0);
    }

    @Override
    public T top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return lista.get(0);
    }

    @Override
    public void push(T element) {
        lista.addFirst(element);
    }

    @Override
    public boolean isEmpty() {
        return lista.size == 0;
    }

    @Override
    public void makeEmpty() {
        lista = new ListaEnlazada<>();
    }
}
