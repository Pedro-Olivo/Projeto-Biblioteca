package controller;

import banco.DaoProfessor;
import java.util.ArrayList;
import models.ProfessorModel;
import view.ProfessorView;

public class ProfessorController implements Icrud {
    
    private ProfessorView view = new ProfessorView();
    private DaoProfessor daoProfessor = new DaoProfessor();
    private ProfessorModel professorModel = new ProfessorModel();

    @Override
    public void cadastrar(){
        view.infosProfessor(professorModel);
        daoProfessor.cadastroProfessor(professorModel);
    }

    @Override
    public void listar(){
        ArrayList<ProfessorModel> professores = new ArrayList<>();
        daoProfessor.listarProfessores(professores);
        view.exibirProfessores(professores);
    }

    @Override
    public void editar(){
        int id = view.obterId();
        String email = view.obterEmail();
        String telefone = view.obterTelefone();

        try {
            daoProfessor.editarProfessor(id, email, telefone);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public void remover(){
        int id = view.obterId();
        daoProfessor.deletarProfessores(id);
    }
}
