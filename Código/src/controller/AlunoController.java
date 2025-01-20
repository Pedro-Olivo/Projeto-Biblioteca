package controller;

import banco.DaoAluno;
import java.util.ArrayList;
import models.AlunoModel;
import view.AlunoView;

public class AlunoController implements Icrud{

    private AlunoView view = new AlunoView();
    private DaoAluno daoAluno = new DaoAluno();
    private AlunoModel alunoModel = new AlunoModel();

    @Override
    public void cadastrar(){
        view.infosAluno(alunoModel);
        daoAluno.cadastroAluno(alunoModel);
    }

    @Override
    public void listar(){
        ArrayList<AlunoModel> alunos = new ArrayList<>();
        daoAluno.listarAlunos(alunos);
        view.exibirAlunos(alunos);
    }

    @Override
    public void editar(){
        int id = view.obterId();
        String email = view.obterEmail();
        String telefone = view.obterTelefone();

        try {
            daoAluno.editarAluno(id, email, telefone);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public void remover(){
        int id = view.obterId();
        daoAluno.deletarAlunos(id);
    }
}
