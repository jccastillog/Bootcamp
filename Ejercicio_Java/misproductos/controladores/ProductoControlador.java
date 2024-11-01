package misproductos.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import misproductos.modelos.VentaModelo;
import misproductos.servicios.ProductoServicio;

public class ProductoControlador {

    private final Scanner scanner = new Scanner(System.in);
    ProductoServicio productoServicio = new ProductoServicio();

    public void iniciar() {

        while (true) {

            System.out.println("\n1. Crear Tablas e insertar datos");
            System.out.println("\n2. Mostrar productos");
            System.out.println("\n3. Realizar transaccion");
            System.out.println("\n4. Mostrar productos con GROUP BY y HAVING");
            System.out.println("\n5. Buscar productos con subconsultas");
            System.out.println("\n6. Salir");
            System.out.println("\nSeleccione una Opción");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearTablasInsertarDatos();
                    break;
                case 2:
                    mostrarProductosConJoin();
                    break;
                case 3:
                    realizarTransaccion();
                    break;
                case 4:
                    mostrarProductosConGoupBy();
                    break;
                case 5:
                    buscarProductosConSubconsulta();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    System.exit(0);
                    break;                                                                                            
                default:
                    System.out.println("Opción no valida");
                    break;
            }
            
        }
    }

    private void crearTablasInsertarDatos() {
        productoServicio.crearTablas();
        productoServicio.InsertarDatos();
    }

    
    private void mostrarProductosConJoin() {
        productoServicio.mostrarProductosConJoin();
    }

    private void realizarTransaccion() {

        List<VentaModelo> ventaModelosList = new ArrayList<>();

        while(true){
            System.out.println("Ingrese el id del producto a vender o 0 para terminar");
            int productoId = scanner.nextInt();

            if (productoId == 0){
                break;
            }

            System.out.println("Ingrese la cantidad de productos a vender");
            int cantidad = scanner.nextInt();

            VentaModelo ventaModelo = productoServicio.crearVenta(productoId,cantidad);

            if (ventaModelo != null){
                ventaModelosList.add(ventaModelo);

            }else {
                System.out.println("No se pudo crear la venta");
            }

            if (!ventaModelosList.isEmpty()) {
                productoServicio.realizarTransaccion(ventaModelosList);
            }else{
                System.out.println("No se realizaron ventas");
            }       
        }
    }

    private void mostrarProductosConGoupBy() {
        productoServicio.mostrarProductosConGoupBy();
    }

    private void buscarProductosConSubconsulta() {
        System.out.println("Ingrese el ID del producto");
        int productoId = scanner.nextInt();
        productoServicio.buscarProductosConSubconsulta(productoId);
    }

}
