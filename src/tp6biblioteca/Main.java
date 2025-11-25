/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6biblioteca;

/**
 *
 * @author Dario
 */
public class Main {

    public static void main(String[] args) {

        // 1. Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // 2. Crear autores
        Autor a1 = new Autor("A01", "Gabriel García Márquez", "Colombia");
        Autor a2 = new Autor("A02", "Jorge Luis Borges", "Argentina");
        Autor a3 = new Autor("A03", "Haruki Murakami", "Japón");

        // 3. Agregar 5 libros
        biblioteca.agregarLibro("ISBN001", "Cien Años de Soledad", 1967, a1);
        biblioteca.agregarLibro("ISBN002", "El Aleph", 1949, a2);
        biblioteca.agregarLibro("ISBN003", "Kafka en la Orilla", 2002, a3);
        biblioteca.agregarLibro("ISBN004", "Crónica de una Muerte Anunciada", 1981, a1);
        biblioteca.agregarLibro("ISBN005", "El Libro de Arena", 1975, a2);

        System.out.println("\n=== 4. Listar libros ===");
        biblioteca.listarLibros();

        System.out.println("\n=== 5. Buscar libro por ISBN001 ===");
        Libro buscado = biblioteca.buscarLibroPorIsbn("ISBN001");
        if (buscado != null) buscado.mostrarInfo();

        System.out.println("\n=== 6. Libros publicados en 1981 ===");
        biblioteca.filtrarLibrosPorAnio(1981).forEach(Libro::mostrarInfo);

        System.out.println("\n=== 7. Eliminar ISBN002 ===");
        biblioteca.eliminarLibro("ISBN002");
        biblioteca.listarLibros();

        System.out.println("\n=== 8. Cantidad total de libros ===");
        System.out.println(biblioteca.obtenerCantidadLibros());

        System.out.println("\n=== 9. Autores disponibles ===");
        biblioteca.mostrarAutoresDisponibles();
    }
}

