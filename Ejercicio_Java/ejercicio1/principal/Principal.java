package ejercicio1.principal;

import ejercicio1.modelo.Estudiante;
//import ejercicio1.modelo.Persona;

public class Principal {

    public static void main(String[] args) {
        //Persona persona1 = new Persona("Juan Carlos", 53);
        Estudiante estudiante1 = new Estudiante("JCC", 52, "Java");
        estudiante1.saludar();
        estudiante1.estudiar();
    }
    
}


