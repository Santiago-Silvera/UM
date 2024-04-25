package uy.edu.um.prog2.tad.linkedlist;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class Stack2<T extends Comparable<T>> implements MyStack<T>{
    private int size;
    T[] array;
    public Stack2(Class<T> tClass, int capacity) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(tClass, capacity);
        this.array = array;
    }

    @Override
    public void pop() throws EmptyStackException {
        if (this.getSize() == 0) {
            throw new EmptyStackException();
        }
        array[size - 1] = null;
        this.size--;
    }

    @Override
    public T top() throws EmptyStackException {
        if (this.getSize() == 0) {
            throw new EmptyStackException();
        }
        return array[getSize() - 1];
    }

    @Override
    public void push(T element) {
        int i = 0;
        for (T t : array) {
            if (t == null) {
                array[i] = element;
                this.size++;
                return;
            }
            i++;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < this.getSize() - 1; i++) {
            array[i] = null;
        }
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        String s = "";
        for (T t : array) {
            if (t == null) {
                s += "null\n";
            } else {
                s += t.toString() + "\n";
            }
        }
        return s;
    }

}
