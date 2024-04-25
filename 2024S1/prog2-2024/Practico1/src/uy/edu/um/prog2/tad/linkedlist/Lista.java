package uy.edu.um.prog2.tad.linkedlist;

public interface Lista<T> {
    void add(T value);
    void remove(int position);
    T get(int position);
}
