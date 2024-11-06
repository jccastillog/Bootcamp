package partidos.modelo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RegistroPartido {

    private Partido[] partidos ;
    private int contadorPartidos ;

    public RegistroPartido() {
        this.partidos = new Partido[10];
        this.contadorPartidos = 0;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        while (true) {

            System.out.println("\n1. Registrar Partido");
            System.out.println("\n2. Ver Resultados");
            System.out.println("\n3. Tabla de Clasificacion");
            System.out.println("\n4. Salir");
            System.out.println("\nSeleccione una Opción");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> registrarPartido(scanner);
                case 2 -> verResultados();
                case 3 -> verTablaClasificacion();
                case 4 -> {
                    System.out.println("Saliendo");
                    System.exit(0);
                }
                default -> System.out.println("Opción no valida");
            }
        }
    }

    


    public void registrarPartido(Scanner scanner) {
    
            System.out.println("Fecha del partido ( dd/MM/yyyy): ");
            String fechaPartido = scanner.nextLine();

            System.out.println("Nombre rival: ");
            String nombreRival = scanner.nextLine();

            System.out.println("Goles equipo rival: ");
            int golesEquipoRival = Integer.parseInt(scanner.nextLine());

            System.out.println("Goles Universidad: ");
            int golesUniversidad = Integer.parseInt(scanner.nextLine());

            scanner.nextLine();

            Partido partido = new Partido(fechaPartido, nombreRival, golesEquipoRival, golesUniversidad);
            partidos[contadorPartidos] = partido;
            contadorPartidos ++;
            System.out.println("Partido registrado");

            System.out.println("Desea registrar otro partido (s/n)");
            String opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("s")) {
                registrarPartido(scanner);
            }
    }
    

    public void verResultados() {
        ordenarPartidosPorFecha();

        for (int i = 0; i < contadorPartidos; i++) {
            System.out.println(partidos[i]);
        }
    }

    private void ordenarPartidosPorFecha(){
        Arrays.sort(partidos,0,contadorPartidos,new Comparator<Partido>(){
        @Override
        public int compare(Partido p1, Partido p2){
            return p2.getFechaPartido().compareTo(p1.getFechaPartido());
        }
    });

    }

    public void verTablaClasificacion() {
        int jugados = contadorPartidos;
        int ganados = 0;
        int empatados = 0;
        int perdidos = 0;
        int puntos = 0;

        for (int i = 0; i < contadorPartidos; i++) {
            Partido partido= partidos[i];
            if (partido.getGolesUniverdidad()>partido.getGolesEquipoRival()) {
                ganados ++;
                puntos += 3;
            } else if (partido.getGolesUniverdidad()==partido.getGolesEquipoRival()){
                empatados ++;
                puntos += 1;
            }else {
                perdidos ++;
            }
        }

        System.out.println("Tabla Clasificacion");
        System.out.println("Jugados: " +jugados);
        System.out.println("Ganados: "+ganados);
        System.out.println("Empatados: "+empatados);
        System.out.println("Perdidos: "+perdidos);
        System.out.println("Puntos: "+puntos);


    }

}
