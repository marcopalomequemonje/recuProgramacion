package rpg.dao;

import rpg.model.Ciudad;
import rpg.model.Clase;
import rpg.utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
    public CiudadDAO (){

    }

    public List<Ciudad> findAll () {
        String sql = "SELECT * FROM CIUDADES";
        List<Ciudad> ciudades = new ArrayList<>();
        try(
                Connection connection = ConexionDB.getConexion();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while (resultSet.next()){
                Ciudad ciudad = new Ciudad(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("nivel_minimo_acceso")
                );
                ciudades.add(ciudad);
            }
            return ciudades;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
