package rpg.dao;

import rpg.model.Clase;
import rpg.model.Item;
import rpg.utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAO {
    public List<Item> findAll () {
        String sql = "SELECT * FROM ITEMS";
        List<Item> items = new ArrayList<>();
        try(
                Connection connection = ConexionDB.getConexion();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while (resultSet.next()){
                Item item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("tipo"),
                        resultSet.getInt("precio_oro"),
                        resultSet.getInt("bonificador_ataque"),
                        resultSet.getInt("bonificador_defensa")
                );
                items.add(item);
            }
            return items;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
