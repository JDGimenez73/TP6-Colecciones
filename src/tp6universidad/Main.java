/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6universidad;

/**
 *
 * @author Dario
 */
public class Main {

    public static void main(String[] args) {

        Universidad uni = new Universidad("UTN");

        // 1. Crear 3 profesores y 5 cursos
        Profesor p1 = new Profesor("P01", "Ana Torres", "Matemática");
        Profesor p2 = new Profesor("P02", "Luis Pérez", "Informática");
        Profesor p3 = new Profesor("P03", "Marta Dias", "Física");

        Curso c1 = new Curso("C01", "Álgebra");
        Curso c2 = new Curso("C02", "Programación I");
        Curso c3 = new Curso("C03", "Estadística");
        Curso c4 = new Curso("C04", "Física I");
        Curso c5 = new Curso("C05", "Programación II");

        uni.agregarProfesor(p1);
        uni.agregarProfesor(p2);
        uni.agregarProfesor(p3);

        uni.agregarCurso(c1);
        uni.agregarCurso(c2);
        uni.agregarCurso(c3);
        uni.agregarCurso(c4);
        uni.agregarCurso(c5);

        // 3. Asignar profesores a cursos
        uni.asignarProfesorACurso("C01", "P01");
        uni.asignarProfesorACurso("C03", "P01");
        uni.asignarProfesorACurso("C02", "P02");
        uni.asignarProfesorACurso("C05", "P02");
        uni.asignarProfesorACurso("C04", "P03");

        System.out.println("\n=== 4. Listar cursos con profesor ===");
        uni.listarCursos();

        System.out.println("\n=== 4. Listar profesores con cursos ===");
        uni.listarProfesores();

        System.out.println("\n=== 5. Cambiar profesor del curso C05 a P03 ===");
        uni.asignarProfesorACurso("C05", "P03");
        uni.listarCursos();

        System.out.println("\n=== 6. Eliminar curso C03 ===");
        uni.eliminarCurso("C03");
        uni.listarProfesores();

        System.out.println("\n=== 7. Eliminar profesor P02 ===");
        uni.eliminarProfesor("P02");
        uni.listarCursos();

        System.out.println("\n=== 8. Reporte: cursos por profesor ===");
        uni.listarProfesores();
    }
}

