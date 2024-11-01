package herencia.principal;

import herencia.modelo.Alimento;
import herencia.modelo.Electrodomestico;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        //Producto producto1 = new Producto("Agua", 10, 100);
    
        Electrodomestico electrodomestico1 = new Electrodomestico("lavadora", 100, 2, "Samsung");
    
        Alimento alimento1 = new Alimento("Arroz", 5, 15, LocalDate.of(2024, 9, 25));
    
        alimento1.mostrarInfoAlimento();
        electrodomestico1.mostrarInfoElectrodomestico();
    
    }

}
