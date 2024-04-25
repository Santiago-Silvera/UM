package uy.edu.um.adt.Entities;

import uy.edu.um.adt.circularlinkedlist.MyCircularLinkedList;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

public class Cliente {
    private String nombre;
    private Integer cedula;
    private String mail;
    private String domicilio;
    private MyCircularLinkedList<Song> cancionesFavoritas = new MyLinkedListImpl<>();

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Cliente cliente = (Cliente) object;
        return cedula == cliente.cedula;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), cedula);
    }

    public MyCircularLinkedList<Song> getCancionesFavoritas() {
        return cancionesFavoritas;
    }

    public void setCancionesFavoritas(MyLinkedListImpl<Song> cancionesFavoritas) {
        this.cancionesFavoritas = cancionesFavoritas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Cliente(String nombre, int cedula, String mail, String domicilio) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.mail = mail;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                ", mail='" + mail + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
