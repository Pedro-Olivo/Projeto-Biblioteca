package view;

import java.util.ArrayList;
import java.util.Scanner;
import models.AlunoModel;

public class AlunoView {
    
    Scanner scanner = new Scanner(System.in);

    public void infosAluno(AlunoModel aluno){


        System.out.println("Insira o nome do aluno (formato Xxxxx): ");
        String nome = scanner.nextLine();
        aluno.setNome(nome);

        System.out.println("Insira a data de nascimento do aluno (formato dd/mm/aa): ");
        String dataNascimento = scanner.nextLine();
        aluno.setDataNascimento(dataNascimento);

        System.out.println("Insira o email do aluno (formato xxxxx@xxxxxxxxxx): ");
        String email = scanner.nextLine();
        aluno.setEmail(email);

        System.out.println("Insira o endereço do aluno (formato Xxxxxxx): ");
        String endereco = scanner.nextLine();
        aluno.setEndereco(endereco);

        System.out.println("Insira o telefone do aluno (formato xxxxxxxxxxx): ");
        String telefone = scanner.nextLine();
        aluno.setTelefone(telefone);

        System.out.println("");
    }

    public void exibirAlunos( ArrayList<AlunoModel> alunos) {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", "ID", "Nome",
        "Data Nascimento", "Email", "Endereco", "Telefone");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (AlunoModel alunoModel: alunos) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",alunoModel.getId(), alunoModel.getNome(), 
            alunoModel.getDataNascimento(), alunoModel.getEmail(), alunoModel.getEndereco(), alunoModel.getTelefone());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public int obterId(){
        System.out.println("Qual o id do aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public String obterEmail(){
        System.out.println("Digite o novo email do aluno(formato Xxxxx): ");
        String email = scanner.nextLine();
        return email;
    }

    public String obterTelefone(){
        System.out.println("Digite o novo telefone do aluno(formato xxxxxxxxxxx): ");
        String telefone = scanner.nextLine();
        return telefone;
    }
}
