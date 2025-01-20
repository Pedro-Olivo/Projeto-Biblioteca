package controller;

import banco.DaoLivro;
import java.util.ArrayList;
import models.LivroModel;
import view.LivroView;

public class LivroController implements Icrud {
    
    private LivroView view = new LivroView();
    private DaoLivro daoLivro = new DaoLivro();
    private BibliotecaController bibliotecaController = new BibliotecaController();
    ArrayList<LivroModel> livros = new ArrayList<>();

    @Override
    public void cadastrar(){
        LivroModel livroModel = new LivroModel();
        view.infoLivro(livroModel);
        daoLivro.cadastroLivro(livroModel);
        bibliotecaController.salvarLivros(livroModel);
        
    }

    @Override
    public void listar(){
        
        daoLivro.listarLivros(livros);
        view.exibirLivros(livros);
    }

    @Override
    public void editar(){
        int id = view.obterId();
        String nome = view.obterNome();
        String autor = view.obterAutor();

        try {
            daoLivro.editarLivro(id, nome, autor);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    public void remover(){
        int id = view.obterId();
        daoLivro.deletarLivros(id);
    }
}
