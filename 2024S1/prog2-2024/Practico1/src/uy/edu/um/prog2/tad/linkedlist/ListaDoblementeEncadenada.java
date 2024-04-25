package uy.edu.um.prog2.tad.linkedlist;

public class ListaDoblementeEncadenada<T> implements Lista<T> {
    NodoDoble<T> primero;
    NodoDoble<T> ultimo;
    public int size = 0;
    public void add(T value) {
        NodoDoble<T> nodoParaAgregar = new NodoDoble<>(value, null, null);
        if (size == 0) {
            primero = nodoParaAgregar;
            ultimo = nodoParaAgregar;
            size++;
            return;
        }
        nodoParaAgregar.anterior = ultimo;
        ultimo.siguiente = nodoParaAgregar;
        ultimo = nodoParaAgregar;
        size++;
    }

    public void remove(int position) {
        if (position == 0) {
            primero = primero.siguiente;
            primero.anterior = null;
            size--;
            return;
        }
        if (position == size - 1) {
            System.out.println("papa");
            ultimo = ultimo.anterior;
            ultimo.siguiente = null;
            size--;
            return;
        }
        NodoDoble<T> nodoParaBorrar = primero;
        for (int i = 0; i < position; i++) {
            nodoParaBorrar = nodoParaBorrar.siguiente;
        }
        nodoParaBorrar.anterior.siguiente = nodoParaBorrar.siguiente;
        nodoParaBorrar.siguiente.anterior = nodoParaBorrar.anterior;
        size--;
    }

    public T get(int position) {
        if (position > size -1) {
            System.out.println("Error with index");
            return null;
        }
        NodoDoble<T> nodoParaDevolver = primero;
        for (int i = 0; i < position; i++) {
            nodoParaDevolver = nodoParaDevolver.siguiente;
        }
        return nodoParaDevolver.value;
    }

    @Override
    public String toString() {
        NodoDoble<T> node = primero;
        String s = "";
        for (int i = 0; i < size; i++) {
            if (node == null) {
                s += "end";
                continue;
            }
            s += node.toString();
            s += "\n";
            node = node.siguiente;
        }
        return s;
    }
}
