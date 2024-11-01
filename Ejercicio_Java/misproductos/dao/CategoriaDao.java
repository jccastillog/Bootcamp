package misproductos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import misproductos.modelos.CategoriaModelo;
import misproductos.utils.ConexionBD;
import misproductos.utils.DatabaseException;

public class CategoriaDao {

    public void crearTabla() {
        String crearTablaSql= "CREATE TABLE IF NOT EXISTS categorias(id INT AUTO_INCREMENT PRIMARY KEY,nombre VARCHAR(50) NOT NULL,UNIQUE INDEX idx_nombre_unico (nombre) )";

        try (Connection connection= ConexionBD.getConnection();
                PreparedStatement stmt= connection.prepareStatement(crearTablaSql)){
                                
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error al crear la tabla categorias"+ e.getMessage(), e);
        }
    }

    public void insertar(String nombre) {
        String seleccionarCategoriasSql= "SELECT COUNT(*) FROM categorias WHERE nombre= ?";
        String insertarCategoriaSql = "INSERT INTO categorias (nombre) VALUES(?)";

        try(Connection connection = ConexionBD.getConnection();
            PreparedStatement stmtSeleccionar= connection.prepareStatement(seleccionarCategoriasSql);
            PreparedStatement stmtInsertar = connection.prepareStatement(insertarCategoriaSql)) {
            
            //Se mapean los datos a cargar que reemplazan los ?, es la forma de llenar los values, el set determina el tipo de datos que se va a cargar
            stmtSeleccionar.setString(1, nombre);
            ResultSet rs= stmtSeleccionar.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                stmtInsertar.setString(1, nombre);
                stmtInsertar.executeUpdate();
            } 

        } catch (SQLException e) {
            throw new DatabaseException("Error al insertar la categoria", e);
        }

    }

    

    public CategoriaModelo obtenerNombre(String nombre) {
        String seleccionarNombreSql = "SELECT * FROM categorias WHERE nombre = ?";

        CategoriaModelo categoriaModelo = null;

        try(Connection connection = ConexionBD.getConnection();
            PreparedStatement stmt = connection.prepareStatement(seleccionarNombreSql)) {
            
                stmt.setString(1,nombre);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()){
                    categoriaModelo = new CategoriaModelo(
                        rs.getInt("id"), 
                        rs.getString("nombre"));
                }

        } catch (SQLException e) {
            throw new DatabaseException("Error al obtener la  categoria"+e.getMessage(), e);
        }

        return categoriaModelo;
    }
    
}
