package view;

import java.util.ArrayList;
import java.util.Scanner;
import models.LivroModel;

public class LivroView {
    
    Scanner scanner = new Scanner(System.in);

    public void infoLivro(LivroModel livro){

        System.out.println("Insira o nome do livro (formato Xxxxx): ");
        String nome = scanner.nextLine();
        livro.setNome(nome);

        System.out.println("Insira o nome do autor do livro (formato Xxxxx): ");
        String autor = scanner.nextLine();
        livro.setAutor(autor);

        System.out.println("");
    }

    public void exibirLivros( ArrayList<LivroModel> livros) {
        System.out.printf("%-15s %-15s %-15s%n", "ID", "Nome",
        "Autor");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (LivroModel livroModel: livros) {
            System.out.printf("%-15s %-15s %-15s%n",livroModel.getId(), livroModel.getNome(), livroModel.getAutor());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public int obterId(){
        System.out.println("Qual o id do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public String obterNome(){
        System.out.println("Digite o novo nome do livro (formato Xxxxx): ");
        String nome = scanner.nextLine();
        return nome;
    }

    public String obterAutor(){
        System.out.println("Digite o novo nome do autor (formato Xxxxx): ");
        String autor = scanner.nextLine();
        return autor;
    }
}
