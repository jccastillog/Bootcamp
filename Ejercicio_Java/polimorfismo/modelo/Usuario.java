package polimorfismo.modelo;

public class Usuario {
    private String nombre;
    private String email;

    public Usuario(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " + nombre + "E-mail: " + email);
    }

    public void definirPermisos(){
        System.out.println("Permiso para el usuario");
    }

    //Ejemplo de sobre carga de métodos:  se define un metodo con el mismo nombre pero diferente cantidad de parámetros
    public void definirPermisos(String rol){
        System.out.println("Permiso para el Rol: " + rol);
    }

}
