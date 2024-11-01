package abstraccion.modelo;

public class Jugador extends Personaje implements IArma{

    private int energia;
    private int balas;
    private int daño;
    private IArma iArma;

    public Jugador(int balas, int daño, int energia, IArma iArma, String nombre, int salud) {
        super(nombre, salud);
        this.balas = balas;
        this.daño = daño;
        this.energia = energia;
        this.iArma = iArma;
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println("El jugador " + getNombre()+ " esta atacando a"+ objetivo.getNombre());
        disparar(objetivo);  
        this.energia -= 10;      
    }

    @Override
    public void cargar() {
        System.out.println("Cargando arma del jugador");
        this.balas = 15;        
    }

    @Override
    public void disparar(Personaje objetivo) {
        if(this.balas>0){
            System.out.println("El jugador " + getNombre()+" esta disparando a: " + objetivo.getNombre()); 
            objetivo.recibirDano(this.daño);
            balas-- ; 
        }else {
            System.out.println("No hay balas: Debe recargar");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Energia: " + this.energia);
        System.out.println("Daño: " + this.daño);
        System.out.println("Balas: " + this.balas);
    }

    @Override
    public void limpiar() {
        IArma.super.limpiar();
    }

    public void cambiarArma(IArma nuevaArma){
        System.out.println("El jugador está cambiando arma");
        this.iArma = nuevaArma;

    }
    
    
}
