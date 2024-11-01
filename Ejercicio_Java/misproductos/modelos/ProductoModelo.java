package misproductos.modelos;

public class ProductoModelo {

    private int id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaModelo categoriaModelo;

    public ProductoModelo(int id, String nombre, double precio, int cantidad, CategoriaModelo categoriaModelo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoriaModelo = categoriaModelo;
    }

    public ProductoModelo(String nombre, double precio, int cantidad, CategoriaModelo categoriaModelo) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoriaModelo = categoriaModelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaModelo getCategoriaModelo() {
        return categoriaModelo;
    }

    public void setCategoriaModelo(CategoriaModelo categoriaModelo) {
        this.categoriaModelo = categoriaModelo;
    }

    
}
