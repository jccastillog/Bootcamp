package misproductos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import misproductos.modelos.CategoriaModelo;
import misproductos.modelos.ProductoModelo;
import misproductos.modelos.VentaModelo;
import misproductos.utils.ConexionBD;
import misproductos.utils.DatabaseException;

public class ProductoDao {

    public void crearTabla() {
        String crearTablaSql = "CREATE TABLE IF NOT EXISTS productos (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100) NOT NULL, precio DECIMAL(10.2) NOT NULL, cantidad INT DEFAULT 0, categoria_id INT, FOREIGN KEY (categoria_id) REFERENCES categorias(id), INDEX idx_nombre_precio (nombre,precio) )";

        try(Connection connection = ConexionBD.getConnection();
            PreparedStatement stmt = connection.prepareStatement(crearTablaSql)) {
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error al crear la tabla productos", e);
        }
    }

    public void insertar(ProductoModelo productoModelo) {
        String insertarProductoSql = "INSERT INTO productos (nombre,precio,cantidad, categoria_id) VALUES(? , ? , ? , ?)";

        try(Connection connection = ConexionBD.getConnection();
            PreparedStatement stmt = connection.prepareStatement(insertarProductoSql)) {
            
            //Se mapean los datos a cargar que reemplazan los ?, es la forma de llenar los values
            stmt.setString(1, productoModelo.getNombre());
            stmt.setDouble(2, productoModelo.getPrecio());
            stmt.setInt(3, productoModelo.getCantidad());
            stmt.setInt(4, productoModelo.getCategoriaModelo().getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error al insertar el producto", e);
        }

    }

    public List<ProductoModelo> obtenerProductosConJoin() {
        String seleccionarProductoSql = "SELECT p.id, p.nombre, p.precio, p.cantidad, p.categoria_id, c.nombre AS categoria  FROM productos p INNER JOIN categorias c ON (c.id=p.categoria_id) ORDER BY p.nombre";

        List<ProductoModelo> productoModelosList= new ArrayList<>();

        try(Connection connection = ConexionBD.getConnection();
        PreparedStatement stmt = connection.prepareStatement(seleccionarProductoSql);
        ResultSet rs = stmt.executeQuery()) {
        
            while (rs.next()){
                ProductoModelo productoModelo = new ProductoModelo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    new CategoriaModelo(rs.getInt("categoria_id"),rs.getString("categoria"))
                );

                productoModelosList.add(productoModelo);
            }
        } 
        catch (SQLException e) {
            throw new DatabaseException("Error al obtener el listado de productos", e);
        }
        return productoModelosList;
    }

    public ProductoModelo obtenerConId(int productoId) {

        String seleccionarProductoSql= "SELECT * FROM productos WHERE id = ?";

        ProductoModelo productoModelo= null;

        try (Connection connection= ConexionBD.getConnection();
                PreparedStatement stmt= connection.prepareStatement(seleccionarProductoSql)){
            
            stmt.setInt(1, productoId);

            ResultSet rs= stmt.executeQuery();

            if (rs.next()) {
                productoModelo= new ProductoModelo(
                    rs.getInt("id"), 
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    null
                );
            }
            
        } catch (SQLException e) {
            throw new DatabaseException("Error al obtener el producto", e);
        }

        return productoModelo;
    }

    public void realizarTransaccion(List<VentaModelo> ventaModelosList) {

        try (Connection connection= ConexionBD.getConnection()){

            connection.setAutoCommit(false);

            try {
                for (VentaModelo ventaModelo : ventaModelosList) {
                    actualizarCantidad(ventaModelo.getProductoModelo().getId(), ventaModelo.getCantidad(), connection);
                    VentaDao.registrarVenta(ventaModelo, connection);
                }

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new DatabaseException("Error durante la transacción", e);
            }
            
        } catch (SQLException e) {
            throw new DatabaseException("Error al iniciar la transacción", e);
        }
    }
    
    private void actualizarCantidad(int id, int cantidad, Connection connection){
        String actualizarCantidad="UPDATE productos SET cantidad= cantidad - ? WHERE id = ?";

        try (PreparedStatement stmt= connection.prepareStatement(actualizarCantidad)){

            stmt.setInt(1, cantidad);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error al actualizar la cantidad", e);
        }
    }

    public List<Map<String, Object>> obtenerProductosConGroupByHaving(){

        String seleccionarProductosSql= "SELECT c.nombre AS categoria, COUNT(p.id) AS total_productos, AVG(p.precio) AS precio_promedio " + 
                                        "FROM productos p " + 
                                        "INNER JOIN categorias c " + 
                                        "ON p.categoria_id = c.id " +
                                        "GROUP BY c.id " + 
                                        "HAVING AVG(p.precio) > 100";

        List<Map<String, Object>> mapsList= new ArrayList<>();

        try (Connection connection= ConexionBD.getConnection();
                PreparedStatement stmt= connection.prepareStatement(seleccionarProductosSql)){
            
            ResultSet rs= stmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> map= new HashMap<>();
                map.put("categoria", rs.getString("categoria"));
                map.put("total_productos", rs.getInt("total_productos"));
                map.put("precio_promedio", rs.getDouble("precio_promedio"));

                mapsList.add(map);
            }
            
        } catch (SQLException e) {
            throw new DatabaseException("Error al obtener el producto", e);
        }

        return mapsList;
    }

    public ProductoModelo obtenerProductosConSubconsulta(int productoId) {
        String seleccionarProductoSql= "SELECT p1.nombre, p1.precio " + 
                                       "FROM productos p1 " + 
                                       "WHERE p1.precio > (SELECT AVG(p2.precio) FROM productos p2 WHERE p2.categoria_id = p1.categoria_id) " +
                                       "AND p1.id= ?";

        ProductoModelo productoModelo= null;

        try (Connection connection= ConexionBD.getConnection();
                PreparedStatement stmt= connection.prepareStatement(seleccionarProductoSql)){
            
            stmt.setInt(1, productoId);

            ResultSet rs= stmt.executeQuery();

            if (rs.next()) {
                productoModelo= new ProductoModelo(
                    productoId, 
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    0,
                    null
                );
            }
            
        } catch (SQLException e) {
            throw new DatabaseException("Error al obtener el producto", e);
        }

        return productoModelo;
    }


}


