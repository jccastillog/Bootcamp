package encapsulamiento.principal;

import encapsulamiento.modelo.Personal;

public class Principal {

    public static void main(String[] args) {

        Personal persona1 = new Personal("Juan", "321380", 53, "chia");

        System.out.println(persona1.telefono);
        System.out.println(persona1);
        persona1.aumentarEdad();
        persona1.cambiarDireccion("Calle 3 Sur");
        persona1.mostrarinfo();
        
    }

}
