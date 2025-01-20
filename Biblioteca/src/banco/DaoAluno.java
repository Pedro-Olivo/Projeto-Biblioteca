package banco;

import java.sql.*;
import java.util.ArrayList;
import models.AlunoModel;

public class DaoAluno {
    
    public void cadastroAluno(AlunoModel aluno){

        String sql = "INSERT INTO ALUNO (NOME, DATANASCIMENTO, EMAIL, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getDataNascimento());
            ps.setString(3, aluno.getEmail());
            ps.setString(4, aluno.getEndereco());
            ps.setString(5, aluno.getTelefone());
            
            ps.execute();
            ps.close();
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Cadastro realizado com sucesso");
            System.out.println("-----------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Erro ao realizar o cadastro: " + e.getMessage());
        }
    }

    public ArrayList<AlunoModel> listarAlunos(ArrayList<AlunoModel> alunos){

        String sql = "SELECT * FROM ALUNO";

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

                alunos.add(new AlunoModel(id, nome, dataNascimento, email, endereco, telefone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }

    public void deletarAlunos(int id){

        String sql = "DELETE FROM ALUNO WHERE IDALUNO = ?";
        Connection conn = null;
        PreparedStatement ps;

        try {
            ps = Conexao.getConexao(conn).prepareStatement(sql);
            ps.setInt(1, id);
            System.out.println(id);
            ps.execute();
            ps.close();

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Aluno deletado");
            System.out.println("-----------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("Não foi possível deletar o registro do aluno");
        }

    }

    public void editarAluno(int id, String email, String telefone){

        String sql = "UPDATE ALUNO SET EMAIL = ?, TELEFONE = ? WHERE IDALUNO = ?";
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
            System.out.println("Não foi possível atualizar o registro do aluno");
        }
    }
}
