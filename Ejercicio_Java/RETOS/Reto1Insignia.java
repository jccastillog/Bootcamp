import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto1{
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run(){
        int cantidadEstudiantes = Integer.parseInt(read());
        List<Double> alturas = new ArrayList<>();
        double suma=0;
        double media=0;
        int mayores=0;
        int menores=0;

        for (int i = 0; i < cantidadEstudiantes; i++) {
            double altura = Double.parseDouble(read());
            alturas.add(altura);
            suma+=altura;
        }

        media=suma/cantidadEstudiantes;

        for (Double altura : alturas) {

            if(alturas.size()==1){
                mayores=0;
                menores=0;
            }else if(altura>media){
                mayores++;
            }else if(altura<=media){
                menores++;
            }
        }

        System.out.println(alturas);
        System.out.printf("%.2f%n",media);
        System.out.println(mayores);
        System.out.println(menores);

    }
}