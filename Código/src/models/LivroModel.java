package models;

public class LivroModel {
    
    protected int id;
    protected String nome;
    protected String autor;

    public LivroModel(int id, String nome, String autor){
        this.id = id;
        this.nome = nome;
        this.autor = autor;
    }

    public LivroModel(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
