package swrpg.dao;
import java.sql.*;

public class ConexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/StarWarsRPG";
    private static final String USER = "republica";
    private static final String PASSWORD = "orden66";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método de ejemplo
    public static void ejemploConsulta() {
        String sql = "SELECT * FROM Ejemplo";
        
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
                
            while (rs.next()) {
                String columna1 = rs.getString("columna1");
                int columna2 = rs.getInt("columna2");
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error al ejecutar la consulta de ejemplo:");
            e.printStackTrace();
        }
    }
}
