package uy.edu.um.prog2.tad.linkedlist;

public class ListaEncadenadaCircular<T> implements Lista<T>{
    public NodoDoble<T> access;
    public int size = 0;

    @Override
    public void add(T value) {
        if (access == null) {
            NodoDoble<T> nuevo = new NodoDoble<>(value, null, null);
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            access = nuevo;
            size++;
            return;
        }
        NodoDoble<T> node = new NodoDoble<>(value, access, access.anterior);
        access.anterior.siguiente = node;
        access.anterior = node;
        size++;
    }

    @Override
    public void remove(int position) {
        int position2 = position;
        if (position > size) position2 = size % position;
        if (position < 0) position2 = size % (-1 * position);
        NodoDoble<T> node = access;
        try {
            for (int i = 0; i < position2; i++) {
                node = node.siguiente;
            }
            node.anterior.siguiente = node.siguiente;
            node.siguiente.anterior = node.anterior;
            if (position2 == 0) {
                access = node.siguiente;
            }
            node.siguiente = null;
            node.anterior = null;
            size--;
        } catch (NullPointerException e) {
            System.out.println("Error");
            System.out.println(e);
        }
    }

    @Override
    public T get(int position) {
        int position2 = position;
        if (position > size) position2 = size % position;
        if (position < 0) position2 = size % (-1 * position);
        NodoDoble<T> nodo = access;
        for (int i = 0; i < position2; i++) {
            nodo = nodo.siguiente;
        }
        return nodo.value;
    }

    @Override
    public String toString() {
        String s = "";
        NodoDoble<T> node = access;
        for (int i = 0; i < size; i++) {
            if (node == null) {
                s += "null \n";
                continue;
            }
            s += node;
            s += "\n";
            node = node.siguiente;
        }
        return s;
    }

}
