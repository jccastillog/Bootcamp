package misproductos.modelos;

import java.util.Date;

public class VentaModelo {
    private int id;
    private int cantidad;
    private Date fecha;
    private ProductoModelo productoModelo;
    
    public VentaModelo(int cantidad, Date fecha, ProductoModelo productoModelo) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.productoModelo = productoModelo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public ProductoModelo getProductoModelo() {
        return productoModelo;
    }
    public void setProductoModelo(ProductoModelo productoModelo) {
        this.productoModelo = productoModelo;
    }


    
}
