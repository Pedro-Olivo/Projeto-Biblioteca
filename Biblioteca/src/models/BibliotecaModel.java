package models;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaModel {
    protected List<LivroModel> livrosCadastrados = new ArrayList<>();
    protected List<LivroModel> livrosDisponiveis = new ArrayList<>();
    protected List<LivroModel> livrosOcupados = new ArrayList<>();

    public List<LivroModel> getLivrosCadastrados() {
        return livrosCadastrados;
    }

    public void setLivrosCadastrados(List<LivroModel> livrosCadastrados) {
        this.livrosCadastrados = livrosCadastrados;
    }

    public List<LivroModel> getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public void setLivrosDisponiveis(List<LivroModel> livrosDisponiveis) {
        this.livrosDisponiveis = livrosDisponiveis;
    }

    public List<LivroModel> getLivrosOcupados() {
        return livrosOcupados;
    }

    public void setLivrosOcupados(List<LivroModel> livrosOcupados) {
        this.livrosOcupados = livrosOcupados;
    }
}
