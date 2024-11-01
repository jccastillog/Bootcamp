package abstraccion.modelo;


//las interfaces no tienen atributos y todos los métodos son públicos y abstractos, no se implementan
public interface IArma {
    
    void cargar();
    void disparar(Personaje objetivo);
    void mostrarInfo();

    //La interfaz tiene metodos por default, son opcionales de implementar, la clase que use la interfaz puede implementar este metodo e incluso sobreescribirlo.
    default void limpiar(){
        System.out.println("Limpiando el arma");
    }

    //La interfaz tiene metodos static pueden ser usados sin necesidad de implementar la interfaz.
    static void describirArma(){
        System.out.println("Arma usada para atacar enemigos");
    }
}
