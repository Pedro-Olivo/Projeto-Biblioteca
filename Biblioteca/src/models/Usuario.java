package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

    protected int id;
    protected String nome;
    protected String dataNascimento;
    protected String email;
    protected String endereco;
    protected String telefone;
    protected List<LivroModel> listaDeLivros = new ArrayList<>();
    
}
