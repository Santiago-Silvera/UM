package uy.edu.um.prog2.tad.linkedlist;

public class NodoSimple<T extends Comparable<T>> {
    public T value;
    public NodoSimple<T> siguiente;
    public NodoSimple(T value, NodoSimple<T> siguiente) {
        this.value = value;
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        String s = "{ valor: ";
        s += value.toString();
        s += ", siguiente: ";
        if (siguiente == null) {
            s += "null";
        } else {
            s += siguiente.toString();
        }
        s += " }";
        return s;
    }

}
