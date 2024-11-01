package abstraccion.principal;

import abstraccion.modelo.Enemigo;
import abstraccion.modelo.Escopeta;
import abstraccion.modelo.IArma;
import abstraccion.modelo.Jugador;
import abstraccion.modelo.Pistola;


public class Main {
    public static void main(String[] args) {
        IArma pistola = new Pistola(20, 15);
        IArma escopeta = new Escopeta(50, 5);

        Enemigo enemigo1 = new Enemigo("Enemigo1", 100);
        Jugador jugador1 = new Jugador(15, 30, 100, pistola, "Jugador1", 100);

        enemigo1.mostrarInfo();
        jugador1.mostrarInfo();

        jugador1.atacar(enemigo1);
        enemigo1.atacar(jugador1);

        enemigo1.mostrarInfo();
        jugador1.mostrarInfo();

        jugador1.cambiarArma(escopeta);
        jugador1.atacar(enemigo1);

        enemigo1.mostrarInfo();
        jugador1.mostrarInfo();

        jugador1.limpiar();
        enemigo1.describirArma();


    }
}
