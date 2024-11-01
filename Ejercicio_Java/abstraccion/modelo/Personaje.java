package abstraccion.modelo;

public abstract class Personaje {
    
    private String nombre;
    private int salud;

    public Personaje(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void recibirDano(int cantidad){
        this.salud -= cantidad;        
        if(this.salud<0){
            this.salud=0;
        }
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Salud: " + salud);
    }

    //El metodo abstracto no tiene implementacion {} porque eso se hace en la clase que hereda. Es obligatorio en la clase que
    public abstract void atacar(Personaje objetivo);

}
