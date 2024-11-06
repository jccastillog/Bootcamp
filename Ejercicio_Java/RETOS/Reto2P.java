package RETOS;

import java.util.Scanner;

public class Reto2P {
    
    
    private final Scanner scanner = new Scanner(System.in);

    public String read(){
        return this.scanner.nextLine();
    }

    public void run(){
        int numeroComprasAnteriores= Integer.parseInt(read());
        double montoCompraActual= Double.parseDouble(read());

        double[] resultado = calcularDescuento(numeroComprasAnteriores,montoCompraActual);
        
        System.out.printf("%.1f\n%.2f\n%.2f", resultado[0], resultado[1], resultado[2]);
        
    }
        
    private double[] calcularDescuento(int numeroComprasAnteriores, double montoCompraActual) {

        double descuentoBase = 5.0;
        double descuentoAdicional = Math.min(numeroComprasAnteriores*2.0,15);
        double montoDescuento = (montoCompraActual * (descuentoBase+descuentoAdicional))/100;

        return new double[]{descuentoBase, descuentoAdicional, montoDescuento};
    }
        
    public static void main(String[] args) {
        Reto2P reto2p = new Reto2P();
        reto2p.run();
    }


}
