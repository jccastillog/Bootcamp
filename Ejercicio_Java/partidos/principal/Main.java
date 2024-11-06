package partidos.principal;

import java.util.Scanner;

import partidos.modelo.RegistroPartido;

public class Main {
    public static void main(String[] args) {
        RegistroPartido registroPartido = new RegistroPartido();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            registroPartido.iniciar();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registroPartido.registrarPartido(scanner);
                    break;
                case 2:
                    registroPartido.verResultados();
                    break;   
                case 3:
                    registroPartido.verTablaClasificacion();
                    break;         
                case 4:
                    System.out.println("Saliendo");                            
                    break;
                default:
                    System.out.println("Opcion no valida");
                    
            }

        } while (opcion!=4);

        scanner.close();

    }
}
