/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6universidad;

/**
 *
 * @author Dario
 */
public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor nuevoProfesor) {

        // 1. Si ya tenía profesor, sacarlo de su lista
        if (this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.getCursos().remove(this);
        }

        // 2. Asignar nuevo profesor
        this.profesor = nuevoProfesor;

        // 3. Agregar este curso al nuevo profesor si corresponde
        if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        System.out.println("Curso: " + codigo + " - " + nombre +
                " | Profesor: " + (profesor == null ? "Sin asignar" : profesor.getNombre()));
    }
}

