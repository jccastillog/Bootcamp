package polimorfismo.modelo;

public class Admin extends Usuario{

    private String rol;

    public Admin(String rol, String email, String nombre) {
        super(email, nombre);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Rol: " +rol);
    }

    @Override
    public void definirPermisos() {
        System.out.println("Permiso para el Administrador");
    }

    
    
}
