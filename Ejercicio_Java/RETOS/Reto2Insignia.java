import java.util.Scanner;

class Reto2{


    private final Scanner scanner = new Scanner(System.in);


    public String read(){
        return this.scanner.nextLine();
    }


    public void run(){
        int numero = Integer.parseInt(read());

        int[] valores =     {1000,900 ,500, 400,100,90  ,50 ,40  ,10 ,9   ,5  ,4   ,1};
        String[] simbolos = {"M" ,"CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        System.out.println(convertirARomano(numero,valores,simbolos));

    }
        private String convertirARomano(int numero, int[] valores, String[] simbolos){
            String resultado = "";

            for (int i = 0; i < valores.length; i++) {
                while(numero >= valores[i]){
                    resultado += simbolos[i];
                    numero -= valores[i];
                }
            }

            return resultado;
        }

}