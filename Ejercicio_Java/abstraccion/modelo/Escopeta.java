package abstraccion.modelo;

public class Escopeta implements IArma{

    private int daño;
    private int balas;

    public Escopeta(int daño, int balas) {
        this.daño = daño;
        this.balas = balas;
    }

    @Override
    public void cargar() {
        System.out.println("Cargando la escopata");
        this.balas = 5;
    }


    @Override
    public void disparar(Personaje objetivo) {
        if(this.balas>0){
            System.out.println("Disparando escopeta a: " + objetivo.getNombre()); 
            objetivo.recibirDano(this.daño);
            balas-- ; 
        }else {
            System.out.println("No hay balas: Debe recargar");
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Arma: Escopeta");
        System.out.println("Daño: " + this.daño);
        System.out.println("Balas: " + this.balas);
    }
    
    
}
