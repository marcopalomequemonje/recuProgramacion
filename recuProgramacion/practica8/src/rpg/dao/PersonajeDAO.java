package rpg.dao;

import rpg.model.Ciudad;
import rpg.model.Clase;
import rpg.model.Personaje;
import rpg.model.Raza;
import rpg.utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            try (ResultSet resultSet = preparedStatement.executeQuery()){

            }catch (Exception e){

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modificarPersonaje (Personaje personaje) {
        String sql = "UPDATE PERSONAJE SET nombre = ?, nivel = ?, oro = ?, vida_actual = ?, id_raza = ?, id_clase = ?, id_ciudad_actual = ?";
        try (
                Connection connection = ConexionDB.getConexion();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {
            preparedStatement.setString(1,personaje.getNombre());
            preparedStatement.setInt(2,personaje.getNivel());
            preparedStatement.setInt(3,personaje.getOro());
            preparedStatement.setInt(4,personaje.getVida_actual());
            preparedStatement.setInt(5,personaje.getRaza().getId());
            preparedStatement.setInt(6,personaje.getClase().getId());
            preparedStatement.setInt(3,personaje.getCiudad_actual().getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()){

            }catch (Exception e){

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Personaje> findall () {
        String sql = "SELECT P.ID AS ID_PERSONAJE, P.NOMBRE AS NOMBRE_PERSONAJE, P.NIVEL AS NIVEL_PERSONAJE, P.ORO AS ORO_PERSONAJE, P.VIDA_ACTUAL, P.ID_RAZA AS ID_RAZA_PERSONAJE, P.ID_CLASE AS ID_CLASE_PERSONAJE, P.ID_CIUDAD_ACTUAL AS ID_CIUDAD_PERSONAJE, " +
                        "R.ID AS ID_RAZA, R.NOMBRE AS NOMBRE_RAZA, R.BONIFICADOR_VIDA, R.BONIFICADOR_FUERZA, " +
                        "CL.ID AS ID_CLASE, CL.NOMBRE AS NOMBRE_CLASE, " +
                        "C.ID AS ID_CIUDAD, C.NOMBRE AS NOMBRE_CIUDAD, C.NIVEL_MINIMO_ACCESO " +
                     "FROM PERSONAJES P " +
                     "JOIN RAZAS R ON P.ID_RAZA = R.ID " +
                     "JOIN CLASES_RPG CL ON P.ID_CLASE = CL.ID " +
                     "JOIN CIUDADES C ON P.ID_CIUDAD = C.ID";
        List<Personaje> personajes = new ArrayList<>();
        try (
                Connection connection = ConexionDB.getConexion();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
            ){

            while (resultSet.next()){
                Raza raza = new Raza(
                        resultSet.getInt("ID_RAZA"),
                        resultSet.getString("NOMBRE_RAZA"),
                        resultSet.getInt("BONIFICADOR_VIDA"),
                        resultSet.getInt("BONIFICADOR_FUERZA")
                );

                Clase clase = new Clase(
                        resultSet.getInt("ID_CLASE"),
                        resultSet.getString("NOMBRE_CLASE")
                );

                Ciudad ciudad = new Ciudad(
                        resultSet.getInt("ID_CIUDAD"),
                        resultSet.getString("NOMBRE_CIUDAD"),
                        resultSet.getInt("NIVEL_MINIMO_ACCESO")
                );

                Personaje personaje = new Personaje(
                        resultSet.getInt("ID_PERSONAJE"),
                        resultSet.getString("NOMBRE_PERSONAJE"),
                        resultSet.getInt("NIVEL_PERSONAJE"),
                        resultSet.getInt("ORO_PERSONAJE"),
                        resultSet.getInt("VIDA_ACTUAL"),
                        raza,
                        clase,
                        ciudad
                );
                personajes.add(personaje);
            }
            return personajes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
