package controller;

import models.BibliotecaModel;
import models.LivroModel;

public class BibliotecaController extends BibliotecaModel {
    
    public void salvarLivros(LivroModel livros){

        livrosCadastrados.add(livros);
        livrosDisponiveis.add(livros);
    }

    public void realizaImprestimo(LivroModel livros){

        livrosDisponiveis.remove(livros.getId());
        livrosOcupados.add(livros);
    }

    public void devolucaoLivros(LivroModel livros){

        livrosOcupados.remove(livros.getId());
        livrosOcupados.add(livros);
    }
}
