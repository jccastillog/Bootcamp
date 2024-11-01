package misproductos.servicios;


import java.util.Date;
import java.util.List;
import java.util.Map;
import misproductos.dao.CategoriaDao;
import misproductos.dao.ProductoDao;
import misproductos.dao.VentaDao;
import misproductos.modelos.ProductoModelo;
import misproductos.modelos.VentaModelo;
import misproductos.utils.DatabaseException;

public class ProductoServicio {

    private CategoriaDao categoriaDao = new CategoriaDao();
    private ProductoDao productoDao = new ProductoDao();
    private VentaDao ventaDao = new VentaDao();

    public void crearTablas() {
        try {
            categoriaDao.crearTabla();
            productoDao.crearTabla();
            ventaDao.crearTabla();
            System.out.println("Tablas creadas...");
        } catch (DatabaseException e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }

    }

    public void InsertarDatos() {
        try {
            categoriaDao.insertar("Electronica");
            categoriaDao.insertar("Muebles");
            categoriaDao.insertar("Ropa");

            productoDao.insertar(new ProductoModelo("PC", 1200.00, 10,  categoriaDao.obtenerNombre("Electronica")));
            productoDao.insertar(new ProductoModelo("Tablet", 400.00, 15,  categoriaDao.obtenerNombre("Electronica")));
            productoDao.insertar(new ProductoModelo("Sofa", 300.00, 5,  categoriaDao.obtenerNombre("Muebles")));
            productoDao.insertar(new ProductoModelo("Camiseta", 20.00, 50,  categoriaDao.obtenerNombre("Ropa")));

            
            System.out.println("Datos Insertados...");
        } catch (DatabaseException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        } finally {
        }

    }

    public void mostrarProductosConJoin() {
        List<ProductoModelo> productoModelosList= productoDao.obtenerProductosConJoin();
        for (ProductoModelo productoModelo : productoModelosList) {
            System.out.println(productoModelo.getId() + ": " + productoModelo.getNombre() + " - " + productoModelo.getPrecio() + " - " + productoModelo.getCantidad());
        }
    }

    public VentaModelo crearVenta(int productoId, int cantidad) {
        ProductoModelo productoModelo= productoDao.obtenerConId(productoId);

        if (productoModelo != null && productoModelo.getCantidad() >= cantidad) {
             return new VentaModelo(cantidad, new Date(), productoModelo);
        } else {
             System.out.println("Producto no encontrado o cantidad insuficiente.");
             return null;
        }
    }

    public void realizarTransaccion(List<VentaModelo> ventaModelosList) {
        System.out.println("Iniciar transacción");
        try {
            productoDao.realizarTransaccion(ventaModelosList);
            System.out.println("Transacción finalizada");
        } catch (DatabaseException e) {
           System.out.println("Error durante la transacción: " + e.getMessage());
        }
    }

    public void mostrarProductosConGoupBy() {
        List<Map<String, Object>> mapsList= productoDao.obtenerProductosConGroupByHaving();
        
        for (Map<String,Object> map : mapsList) {
            System.out.println("Categoria: " + map.get("categoria") + 
                                " - Total productos: " + map.get("total_productos") + 
                                " - Precio promedio: " + map.get("precio_promedio"));
        }
    }

    public void buscarProductosConSubconsulta(int productoId) {
        ProductoModelo productoModelo= productoDao.obtenerProductosConSubconsulta(productoId);
        if (productoModelo != null) {
            System.out.println("Producto encontrado: " + productoModelo.getNombre() + "- Precio: " + productoModelo.getPrecio());
        } else {
            System.out.println("Producto no encontrado");
        }
    }





}
