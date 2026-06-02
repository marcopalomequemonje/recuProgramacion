package rpg.dao;

import rpg.model.Clase;
import rpg.utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClaseDAO {
    public ClaseDAO() {

    }
    public List<Clase> findAll () {
        String sql = "SELECT * FROM CLASES_RPG";
        List<Clase> clases = new ArrayList<>();
        try(
                Connection connection = ConexionDB.getConexion();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while (resultSet.next()){
                Clase clase = new Clase(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                );
                clases.add(clase);
            }
            return clases;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
