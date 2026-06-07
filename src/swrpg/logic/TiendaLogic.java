package swrpg.logic;

import swrpg.dao.ConexionDB;
import swrpg.exception.CreditosInsuficientesException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TiendaLogic {
    public void comprarEquipamiento (int idPersonaje, int idEquipo) throws CreditosInsuficientesException {
        if (consultarCreditosDispo(idPersonaje)<consultarPrecioEquipo(idEquipo)){
            throw new CreditosInsuficientesException();
        }
        else {
            String sql = "UPDATE Personajes SET creditos = creditos - ? WHERE id = ? ";
            try(
                    Connection c = ConexionDB.getConnection();
                    PreparedStatement ps = c.prepareStatement(sql);
                    ){
                ps.setInt(1, consultarPrecioEquipo(idEquipo));
                ps.setInt(2, idPersonaje);
                ps.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String sqlIns="INSERT INTO INVENTARIOS (ID_PERSONAJE, ID_EQUIPO, CANTIDAD)" +
                            "VALUES (?,?,?)";
            try(
                    Connection c = ConexionDB.getConnection();
                    PreparedStatement ps = c.prepareStatement(sqlIns);
                    ){
                ps.setInt(1,idPersonaje);
                ps.setInt(2,idEquipo);
                ps.setInt(3,1);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public int consultarPrecioEquipo (int id){
        String sql = "SELECT PRECIO_CREDITOS FROM EQUIPAMIENTO WHERE ID = "+id;
        int precio = 0;
        try(
                Connection c = ConexionDB.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            if (rs.next()){
                precio= rs.getInt("precio_creditos");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return precio;
    }
    public int consultarCreditosDispo (int id){
        String sql = "SELECT CREDITOS FROM PERSONAJES WHERE ID ="+id;
        int creditos = 0;
        try (
                Connection c = ConexionDB.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            if(rs.next()){
                creditos = rs.getInt("creditos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return creditos;
    }
}
