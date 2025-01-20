package banco;

import java.sql.*;


public class Conexao {
    
    public static Connection getConexao(Connection conn){

        try {
            if (conn == null || conn.isClosed()) {
                System.out.println("");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancobiblioteca", "root", "root1234");
                
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            System.out.println("Falha ao obter conexão");
            return null;
        }
    }
}
