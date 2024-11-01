package encapsulamiento.modelo;

public class Personal {
    private String nombre;
    public String telefono;
    protected int edad;
    String direccion;
    
    public Personal(String nombre, String telefono, int edad, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void mostrarinfo(){
        System.out.println(nombre);
        System.out.println(edad);
        System.out.println(telefono);
        System.out.println(direccion);
    }

    public void aumentarEdad(){
        edad++;
    }

    public void cambiarDireccion(String nuevaDireccion){
        direccion=nuevaDireccion;
    }

    @Override
    public String toString() {
        return "Información de la persona " +nombre + "  "+ edad + "  "+ direccion + "  "+ telefono;
    }

    
}
