package swrpg.dao;

import swrpg.model.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonajeDAO {
    public PersonajeDAO(){}

    public void registrarPersonaje (Personaje p){
        String sql = "INSERT INTO PERSONAJES (id, nombre, nivel, creditos, vida_actual, lado_oscuro, id_especie, id_profesion, id_planeta_actual)" +
                     "VALUES (?,?,?,?,?,?,?,?,?)";
        try (
                Connection c = ConexionDB.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
            ){
                ps.setInt(1,p.getId());
                ps.setString(2,p.getNombre());
                ps.setInt(3,1);
                ps.setInt(4,500);
                ps.setInt(5,100);
                ps.setInt(6,0);
                ps.setInt(7,p.getIdEspecie().getId());
                ps.setInt(8,p.getIdPlanetaActual().getId());
                ps.setInt(9,p.getIdPlanetaActual().getId());
                ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
