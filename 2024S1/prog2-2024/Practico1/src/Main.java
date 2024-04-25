import uy.edu.um.prog2.tad.linkedlist.*;

import java.util.EmptyStackException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        ListaEnlazada<Integer> mylist = new ListaEnlazada<>();
//        for (int i = 0; i < 10; i++) {
//            mylist.add(i);
//        }
//        System.out.println("lista: " + mylist);
//        System.out.println("size: " + mylist.size);
//        mylist.remove(0);
//        System.out.println("lista r: " + mylist);
//        System.out.println("size: " + mylist.size);
//        System.out.println("pos 9: " + mylist.get(9));


//        ListaDoblementeEncadenada<Integer> l2 = new ListaDoblementeEncadenada<>();
//        l2.add(1);
//        l2.add(2);
//        l2.add(3);
//        System.out.println("size: " + l2.size);
//        System.out.println(l2);
//        l2.remove(0);
//        System.out.println("size: " + l2.size);
//        System.out.println(l2);
//        System.out.println(l2.get(4));


        ListaEncadenadaCircular<Integer> lc = new ListaEncadenadaCircular<>();
        for (int i = 1; i <= 20; i++) {
            lc.add(i);
        }
        System.out.println("size: " + lc.size);
        System.out.println(lc);
        System.out.println(juego(3, lc));

//        Stack2<Integer> s = new Stack2<>(Integer.class, 10);
//        System.out.println(s);
//        s.push(5);
//        s.push(6);
//        s.push(7);
//        s.push(9);
//        s.push(9);
//        System.out.println(s);
//        s.pop();
//        s.pop();
//        s.pop();
//        System.out.println(s);

//        String s1 = "{{([])}}";
//        String s2 = "{{([a)}}";
//        System.out.println(equilibrio(s1));
//        System.out.println(equilibrio(s2));

//        System.out.println(posfija("10 5 * 3 +"));
//        System.out.println(posfija("2 4 6 + +"));
//        System.out.println(posfija("+"));
//        System.out.println(posfija("1 1 - 1 /"));
//        System.out.println(posfija("abc"));
//        System.out.println(posfija("1"));

    }

    /**
     * @param m indica la cantidad de lugares antes de sacar una persona, este valor puede ser negativo e indica la direccion con la cual se recorre la ronda.
     * @param integrantes los integrantes participantes del juego, es una lista de enteros.
     * @throws IllegalArgumentException cuando la cantidad m es mayor que la cantidad de integrantes
     * @return la lista de jugadores que fueron eliminados en el orden de eliminacion.
     */
    public static Lista<Integer> juego(int m, ListaEncadenadaCircular<Integer> integrantes) throws IllegalArgumentException {
        ListaEnlazada<Integer> result = new ListaEnlazada<>();
        NodoDoble<Integer> node = integrantes.access.siguiente;
        int i = 1;
        while (integrantes.size > 1) {
            int c = i % (m + 1);
            if (c == 0) {
                for (int j = 0; j < integrantes.size; j++) {
                    if (Objects.equals(integrantes.get(j), node.value)) {
                        node = node.siguiente;
                        result.addLast(integrantes.get(j));
                        integrantes.remove(j);
                        node = node.anterior;
                    }
                }
            }
            node = node.siguiente;
            i++;
        }
        return result;
    }

    public static boolean equilibrio(String s) {
        Stack2<Character> stack = new Stack2<>(Character.class, s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push('(');
            if (c == '{') stack.push('{');
            if (c == '[') stack.push('[');

            if (c == ')') { if (stack.top() == '(') stack.pop(); else  return false; }
            if (c == '}') { if (stack.top() == '{') stack.pop(); else  return false; }
            if (c == ']') { if (stack.top() == '[') stack.pop(); else  return false; }
        }
        return true;
    }

    public static int posfija(String string) {
        String[] s_arr = string.split(" ");
        Stack2<Integer> stack = new Stack2<>(Integer.class, string.length());
        try {
            for (String s : s_arr) {
                if (    Objects.equals(s, "+")
                    ||  Objects.equals(s, "-")
                    ||  Objects.equals(s, "*")
                    ||  Objects.equals(s, "/")) {
                    int a = stack.top();
                    stack.pop();
                    int b = stack.top();
                    stack.pop();
                    if (Objects.equals(s, "+")) {
                        stack.push(a + b);
                    }
                    if (Objects.equals(s, "-")) {
                        stack.push(a - b);
                    }
                    if (Objects.equals(s, "*")) {
                        stack.push(a * b);
                    }
                    if (Objects.equals(s, "/")) {
                        stack.push(a / b);
                    }
                } else {
                    int num = Integer.parseInt(s);
                    stack.push(num);
                }
            }
            return stack.top();
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer\n" + e);
        } catch (EmptyStackException e) {
            System.out.println("Invalid expresison\n" + e);
        } catch (ArithmeticException e) {
            System.out.println("You tried to divide by zero\n" + e);
        }
        return 0;
    }

}