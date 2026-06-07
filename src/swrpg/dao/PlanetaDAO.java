package swrpg.dao;

import swrpg.model.Planeta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanetaDAO {

    public PlanetaDAO() {
    }

    public List<Planeta> listarTodosLosPlanetas () {
        String sql = "SELECT * FROM PLANETAS";
        List<Planeta> planetas = new ArrayList<>();
        try (
                Connection c = ConexionDB.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()){
                Planeta planeta = new Planeta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("nivel_amenaza")
                );
                planetas.add(planeta);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return planetas;
    }

    public Planeta obtenerPlanetaMasPeligroso () {
        String sql = "SELECT * FROM PLANETAS ORDER BY NIVEL_AMENAZA DESC LIMIT 1";
        Planeta planeta = null;
        try (
                Connection c = ConexionDB.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            if (rs.next()){
                planeta = new Planeta(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("nivel_amenaza")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return planeta;
    }

}
