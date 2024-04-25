package uy.edu.um.prog2.tad.linkedlist;


public class Queue<T extends Comparable<T>> implements MyQueue<T>{
    Lista<T> list = new ListaEnlazada<>();
    @Override
    public void enqueue(T element) {
        list.add(element);
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
