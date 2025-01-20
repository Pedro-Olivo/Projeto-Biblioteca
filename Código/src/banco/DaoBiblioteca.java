package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.LivroModel;

public class DaoBiblioteca {
    
    public List<LivroModel> listarLivrosDisponiveis(List<LivroModel> livrosDisponiveis){

        String sql = "SELECT * FROM LIVROSDISPONIVEIS";

        PreparedStatement ps;
        Connection conn = null;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            
            ResultSet resultset = ps.executeQuery();

            while(resultset.next()){

                int id = resultset.getInt(1);
                String nome = resultset.getString(2);
                String autor = resultset.getString(3);
                

                livrosDisponiveis.add(new LivroModel(id, nome, autor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return livrosDisponiveis;
    }
}
