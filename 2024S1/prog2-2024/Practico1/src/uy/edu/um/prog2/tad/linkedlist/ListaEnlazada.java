package uy.edu.um.prog2.tad.linkedlist;

public class ListaEnlazada<T extends Comparable<T>> implements Lista<T> {
    public NodoSimple<T> primero;
    public int size = 0;

    public void add(T value) {
        if (primero == null) {
            primero = new NodoSimple<>(value, null);
            size++;
            return;
        }
        NodoSimple<T> nodoParaAgregar = new NodoSimple<>(value, null);
        NodoSimple<T> nodoCheckeando = primero;
        while (nodoCheckeando.siguiente != null) {
            nodoCheckeando = nodoCheckeando.siguiente;
        }
        nodoCheckeando.siguiente = nodoParaAgregar;
        size++;
    }

    public void remove(int position) {
        if (position == 0) {
            primero = primero.siguiente;
            size--;
            return;
        }
        NodoSimple<T> nodoParaBorrar = primero;
        NodoSimple<T> previoABorrar = null;
        for (int i = 0; i < position; i++) {
            previoABorrar = nodoParaBorrar;
            nodoParaBorrar = nodoParaBorrar.siguiente;
        }
        assert previoABorrar != null;
        previoABorrar.siguiente = nodoParaBorrar.siguiente;
        nodoParaBorrar.siguiente = null;
        size--;
    }

    public T get(int position) {
        if (position < 0 || position > size) {
            System.out.println("Error with position index");
            return null;
        }
        if (primero == null) {
            System.out.println("Error with first node");
            return null;
        }
        NodoSimple<T> nodoParaDevolver = primero;
        for (int i = 0; i < position - 1; i++) {
            nodoParaDevolver = nodoParaDevolver.siguiente;
        }
        return nodoParaDevolver.value;
    }

    public boolean contains(T value) {
        NodoSimple<T> temp = primero;
        boolean hallado = false;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
            if (temp.value.equals(value)) {
                hallado = true;
            }
        }
        return hallado;
    }

    public void addFirst(T value) {
        this.primero = new NodoSimple<>(value, primero);
    }

    public void addLast(T value) {
        add(value);
    }

    @Override
    public String toString() {
        String s = "";
        s += primero.toString();
        return s;
    }

    public void agregar(@org.jetbrains.annotations.NotNull T value) {
        NodoSimple<T> node = new NodoSimple<>(value, null);
        NodoSimple<T> n = primero;
        while (n.value.compareTo(value) > 0) {
            n = n.siguiente;
        }
        node.siguiente = n.siguiente;
        n.siguiente = node;
    }

}