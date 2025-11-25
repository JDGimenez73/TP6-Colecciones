/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6biblioteca;

/**
 *
 * @author Dario
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    private String nombre;
    private List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    // agregarLibro(...)
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        if (buscarLibroPorIsbn(isbn) != null) {
            System.out.println("Ya existe un libro con ISBN " + isbn);
            return;
        }
        libros.add(new Libro(isbn, titulo, anioPublicacion, autor));
    }

    // listarLibros()
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        libros.forEach(Libro::mostrarInfo);
    }

    // buscarLibroPorIsbn(...)
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) return l;
        }
        return null;
    }

    // eliminarLibro(...)
    public boolean eliminarLibro(String isbn) {
        Libro l = buscarLibroPorIsbn(isbn);
        if (l != null) {
            libros.remove(l);
            return true;
        }
        return false;
    }

    // obtenerCantidadLibros()
    public int obtenerCantidadLibros() {
        return libros.size();
    }

    // filtrarLibrosPorAnio(int año)
    public List<Libro> filtrarLibrosPorAnio(int anio) {
        return libros.stream()
                .filter(l -> l.getAnioPublicacion() == anio)
                .collect(Collectors.toList());
    }

    // mostrarAutoresDisponibles()
    public void mostrarAutoresDisponibles() {
        System.out.println("Autores en la biblioteca:");
        libros.stream()
                .map(Libro::getAutor)
                .distinct()
                .forEach(Autor::mostrarInfo);
    }
}
