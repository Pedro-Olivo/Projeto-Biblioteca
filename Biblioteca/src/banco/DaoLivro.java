package banco;

import java.sql.*;
import java.util.ArrayList;
import models.LivroModel;


public class DaoLivro {
    
    public void cadastroLivro(LivroModel livro){

        String sql = "INSERT INTO LIVRO (NOME, AUTOR) VALUES (?, ?)";
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            ps.setString(1, livro.getNome());
            ps.setString(2, livro.getAutor());
           
            
            ps.execute();
            ps.close();

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso");
            System.out.println("-----------------------------------------------------------------------------------------------");;

        } catch (SQLException e) {
            System.out.println("Erro ao realizar o cadastro: " + e.getMessage());
        }
    }

    public ArrayList<LivroModel> listarLivros(ArrayList<LivroModel> livros){

        String sql = "SELECT * FROM LIVRO";

        PreparedStatement ps;
        Connection conn = null;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            
            ResultSet resultset = ps.executeQuery();

            while(resultset.next()){

                int id = resultset.getInt(1);
                String nome = resultset.getString(2);
                String autor = resultset.getString(3);
                

                livros.add(new LivroModel(id, nome, autor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return livros;
    }

    public void deletarLivros(int id){

        String sql = "DELETE FROM LIVRO WHERE IDLIVRO = ?";
        Connection conn = null;
        PreparedStatement ps;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            ps.setInt(1, id);
            System.out.println(id);
            ps.execute();
            ps.close();

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Professor deletado");
            System.out.println("-----------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Não foi possível deletar o registro do livro");
        }

    }

    public void editarLivro(int id, String nome, String autor){

        String sql = "UPDATE LIVRO SET NOME = ?, AUTOR = ? WHERE IDLIVRO = ?";
        Connection conn = null;
        PreparedStatement ps;

        try {

            ps = Conexao.getConexao(conn).prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, autor);
            ps.setInt(3, id);

            ps.execute();
            ps.close();

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Edição concluída");
            System.out.println("-----------------------------------------------------------------------------------------------");
            
        } catch (SQLException e) {
            System.out.println("Não foi possível atualizar o registro do livro");
        }
    }
}
