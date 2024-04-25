package uy.edu.um.prog2.tad.linkedlist;

public interface MyQueue<T> {
    void enqueue (T element);
    T dequeue() throws EmptyQueueException;
    boolean isEmpty();
}
