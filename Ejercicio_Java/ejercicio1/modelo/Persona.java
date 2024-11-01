package ejercicio1.modelo;

public class Persona {

    // Atributos
    private String nombre;
    private int edad;
    
    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método para mostrar los datos de la persona
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

    // Método para saludar
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }
}


