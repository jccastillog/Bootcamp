package ejercicio1.modelo;

public class Estudiante extends Persona {
    
    // Atributos
    private String curso;

    // Constructor


    // Métodos getter y setter para nombre
    public String getCurso() {
        return curso;
    }

    public Estudiante(String nombre, int edad, String curso) {
        super(nombre, edad);
        this.curso = curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Método para saludar
    public void estudiar() {
        System.out.println("Hola, mi nombre es " + getNombre() + " y tengo " + getEdad() + " años. y estudio " + curso);
    }

    
}

