/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6universidad;

/**
 *
 * @author Dario
 */
import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Curso> getCursos() { return cursos; }

    // Agregar curso al profesor
    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            if (c.getProfesor() != this) {
                c.setProfesor(this); // Sincroniza lado Curso
            }
        }
    }

    // Eliminar curso
    public void eliminarCurso(Curso c) {
        if (cursos.contains(c)) {
            cursos.remove(c);
            if (c.getProfesor() == this) {
                c.setProfesor(null); // Sincroniza lado Curso
            }
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println(nombre + " no dicta cursos.");
            return;
        }
        cursos.forEach(c -> System.out.println(c.getCodigo() + " - " + c.getNombre()));
    }

    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + " | ID: " + id +
                " | Especialidad: " + especialidad +
                " | Cursos: " + cursos.size());
    }
}

