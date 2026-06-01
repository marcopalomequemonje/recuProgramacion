package rpg.DAO;

import rpg.model.Raza;
import rpg.utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RazaDAO {
    public RazaDAO () {

    }
    public List<Raza> findAll(){
        String sql = "SELECT * FROM RAZAS";
        List<Raza> razas = new ArrayList<>();
        try (
                //AQUI CONECTAMOS CON LA DB
                Connection conexion = ConexionDB.getConexion();
                //ESTO ME PERMITE EJECUTAR LA CONSULTA QUE HEMOS CREADO ANTES
                PreparedStatement instrucion = conexion.prepareStatement(sql);
                //EJECUTAMOS LA CONSULTA
                ResultSet resultado = instrucion.executeQuery();
        ) {
            //RECORREMOS LO OBTENIDO
            while (resultado.next()){
                Raza raza = new Raza(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getInt("bonificador_vida"),
                        resultado.getInt("bonificador_fuerza")
                        );
                razas.add(raza);
            }
            return razas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}