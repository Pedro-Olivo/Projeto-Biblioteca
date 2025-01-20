package banco;

import java.sql.*;
import java.util.ArrayList;
import models.ProfessorModel;

public class DaoProfessor {
    
    public void cadastroProfessor(ProfessorModel professor){

        String sql = "INSERT INTO PROFESSOR (NOME, DATANASCIMENTO, EMAIL, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getDataNascimento());
            ps.setString(3, professor.getEmail());
            ps.setString(4, professor.getEndereco());
            ps.setString(5, professor.getTelefone());
            
            ps.execute();
            ps.close();

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso");
            System.out.println("-----------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Erro ao realizar o cadastro: " + e.getMessage());
        }
    }

    public ArrayList<ProfessorModel> listarProfessores(ArrayList<ProfessorModel> professores){

        String sql = "SELECT * FROM PROFESSOR";

        PreparedStatement ps;
        Connection conn = null;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            
            ResultSet resultset = ps.executeQuery();

            while(resultset.next()){

                int id = resultset.getInt(1);
                String nome = resultset.getString(2);
                String dataNascimento = resultset.getString(3);
                String email = resultset.getString(4);
                String endereco = resultset.getString(5);
                String telefone = resultset.getString(6);

                professores.add(new ProfessorModel(id, nome, dataNascimento, email, endereco, telefone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return professores;
    }

    public void deletarProfessores(int id){

        String sql = "DELETE FROM PROFESSOR WHERE IDPROFESSOR = ?";
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
            System.out.println("Não foi possível deletar o registro do professor");
        }

    }

    public void editarProfessor(int id, String email, String telefone){

        String sql = "UPDATE PROFESSOR SET EMAIL = ?, TELEFONE = ? WHERE IDPROFESSOR = ?";
        Connection conn = null;
        PreparedStatement ps;

        try {

            ps = Conexao.getConexao(conn).prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, telefone);
            ps.setInt(3, id);

            ps.execute();
            ps.close();

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Edição concluída");
            System.out.println("-----------------------------------------------------------------------------------------------");
            
        } catch (SQLException e) {
            System.out.println("Não foi possível atualizar o registro do professor");
        }
    }
}
