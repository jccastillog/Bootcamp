package misproductos;

import misproductos.controladores.ProductoControlador;

public class Main {

    public static void main(String[] args) {
        
        ProductoControlador productoControlador = new ProductoControlador();
        productoControlador.iniciar();
    }
    
}
