package uy.edu.um.prog2.tad.linkedlist;

public class NodoDoble<T> {
    public T value;
    public NodoDoble<T> siguiente;
    public NodoDoble<T> anterior;

    public NodoDoble(T value, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        this.value = value;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        String s = "";
        s += "valor: " + value;
        if (siguiente != null) {
            s += ", siguiente: " + siguiente.value;
        } else {
            s += ", siguiente: null";
        }
        if (anterior != null) {
            s += ", anterior: " + anterior.value;
        } else {
            s += ", anterior: null";
        }
        return s;
    }
}
