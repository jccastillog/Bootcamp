package RETOS;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Reto1p {
    
    private final Scanner scanner = new Scanner(System.in);

    public String read(){
        return this.scanner.nextLine();
    }

    public void run(){
        String texto = read();
        String[] palabras = texto.split("\\s+");
        int cantidadPalabras = palabras.length;

        Set<String> palabrasUnicas = new HashSet<>();

        int totalCantidadLetras = 0;

        for (String palabra : palabras) {
            palabrasUnicas.add(palabra);
            totalCantidadLetras += palabra.length();
        }


        int cantidadPalabrasUnicas = palabrasUnicas.size();
        double promedioCantidadPalabras = (double) totalCantidadLetras/cantidadPalabras;

        System.out.println(cantidadPalabras);
        System.out.println(cantidadPalabrasUnicas);
        System.out.printf("%.2f",promedioCantidadPalabras);

    }

    public static void main(String[] args) {
        Reto1p reto1p = new Reto1p();
        reto1p.run();

    }
}
