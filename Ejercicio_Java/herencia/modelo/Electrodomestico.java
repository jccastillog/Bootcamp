package herencia.modelo;

public class Electrodomestico extends Producto{

    private String marca;

    public Electrodomestico(String nombre, double precio, int cantidad,String marca) {
        super(nombre, precio, cantidad);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void mostrarInfoElectrodomestico(){
        System.out.println("Nombre " + getNombre());
        System.out.println("Precio " + getPrecio());
        System.out.println("Cantidad " + getCantidad());
        System.out.println("Marca " + marca);
    }

    @Override
    public String toString() {
        return "Marca " + marca + ", Nombre" + getNombre() + ", Precio " + getPrecio() + ", Cantidad " + getCantidad();
    }

}
