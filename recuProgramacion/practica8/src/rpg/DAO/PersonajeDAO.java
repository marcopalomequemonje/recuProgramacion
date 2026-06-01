package rpg.DAO;

import rpg.model.Personaje;
import rpg.utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonajeDAO {
    public PersonajeDAO() {

    }
    public void crearPersonaje (Personaje personaje){
        //LE HEMOS QUITADO EL ID PORQUE EN LA DB ES AUTOINCREMENTAL
        String sql = "INSERT INTO PERSONAJES (nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual)" +
                                    " VALUES (?,?,?,?,?,?,?)";
        try(
                Connection connection = ConexionDB.getConexion();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1,personaje.getNombre());
            preparedStatement.setInt(2,personaje.getNivel());
            preparedStatement.setInt(3,personaje.getOro());
            preparedStatement.setInt(4,personaje.getVida_actual());
            preparedStatement.setInt(5,personaje.getRaza().getId());
            preparedStatement.setInt(6,personaje.getClase().getId());
            preparedStatement.setInt(7,personaje.getCiudad_actual().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
