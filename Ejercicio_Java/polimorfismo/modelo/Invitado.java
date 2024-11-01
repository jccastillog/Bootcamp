package polimorfismo.modelo;

public class Invitado extends Usuario{

    public Invitado(String email, String nombre) {
        super(email, nombre);
    }

    

    @Override  //hace referencia a que es metodo del padre
    public void mostrarInfo() {
        super.mostrarInfo();
    }

    //Ejemplo de Polimrfismo, no se usa el metodo del padre sino que se reescribe
    @Override
    public void definirPermisos() {
        //super.definirPermisos();
        System.out.println("Permiso para el Invitado");
    }
    
    
}
