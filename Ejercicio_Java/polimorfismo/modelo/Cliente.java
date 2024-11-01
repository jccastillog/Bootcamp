package polimorfismo.modelo;

public class Cliente extends Usuario{

    private String direccion;

    public Cliente(String email, String nombre, String direccion) {
        super(email, nombre);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Ejemplo de sobreescritura de métodos
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Direccion: " + direccion);
    }

    @Override
    public void definirPermisos() {
        System.out.println("Permiso para el Cliente");
    }
    
    
}

