package uy.edu.um.adt;

import uy.edu.um.adt.Entities.Cliente;
import uy.edu.um.adt.Entities.Song;
import uy.edu.um.adt.Exceptions.MissingClient;
import uy.edu.um.adt.Exceptions.MissingSong;
import uy.edu.um.adt.Exceptions.WrongInformationException;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;

import java.util.Objects;
import java.util.Scanner;

public class Sistema {
    public MyLinkedListImpl<Cliente> clientes = new MyLinkedListImpl<>();
    public MyLinkedListImpl<Song> canciones = new MyLinkedListImpl<>();

    public void registerClient() throws WrongInformationException {
        // Pedir los datos del cliente
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        int cedula = sc.nextInt();
        System.out.println("Ingrese la cedula del cliente: ");
        String mail = sc.nextLine();
        System.out.println("Ingrese el mail del cliente: ");
        String domicilio = sc.nextLine();
        System.out.println("Ingrese el domicilio del cliente: ");

        // Registrar el cliente
        if (nombre == null || cedula < 0 || mail == null || domicilio == null) throw new WrongInformationException();
        Cliente cliente = new Cliente(nombre,cedula,mail,domicilio);
        clientes.add(cliente);
    }

    public void registerSong() throws WrongInformationException {
        // Pedir los datos de la cancion
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        System.out.println("Ingrese el titulo de la cancion: ");

        String artista = sc.nextLine();
        System.out.println("Ingrese el nombre del artista: ");

        int duracion = sc.nextInt();
        System.out.println("Ingrese la duracion de la cancion: ");

        String genero = sc.nextLine();
        System.out.println("Ingrese el genero de la cancion: ");

        // Registrar el cliente
        if (titulo == null || artista == null || duracion < 0 || genero == null) throw new WrongInformationException();
        Song cancion = new Song(titulo,artista,duracion,genero);
        canciones.add(cancion);
    }

    public void addSongToFavourites(String titulo, int cedula) throws MissingClient, MissingSong {
        Cliente c = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula() == cedula) {
                c = clientes.get(i);
            }
        }
        Song s = null;
        for (int i = 0; i < canciones.size(); i++) {
            if (Objects.equals(canciones.get(i).getTitulo(), titulo)) {
                s = canciones.get(i);
            }
        }
        if (c == null) throw new MissingClient();
        else if (s == null) throw new MissingSong();
        else c.getCancionesFavoritas().add(s);
    }

    public void removeSongFromFavourites() {

    }
}
