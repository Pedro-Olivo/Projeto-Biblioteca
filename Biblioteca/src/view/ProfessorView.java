package view;

import  java.util.ArrayList;
import java.util.Scanner;
import models.ProfessorModel;

public class ProfessorView {
    
    Scanner scanner = new Scanner(System.in);

    public void infosProfessor(ProfessorModel professor){

        System.out.println("Insira o nome do professor (formato Xxxxx): ");
        String nome = scanner.nextLine();
        professor.setNome(nome);

        System.out.println("Insira a data de nascimento do professor (formato dd/mm/aa): ");
        String dataNascimento = scanner.nextLine();
        professor.setDataNascimento(dataNascimento);

        System.out.println("Insira o email do professor (formato xxxxx@xxxxxxxxxx): ");
        String email = scanner.nextLine();
        professor.setEmail(email);

        System.out.println("Insira o endereço do professor (formato Xxxxxxx): ");
        String endereco = scanner.nextLine();
        professor.setEndereco(endereco);

        System.out.println("Insira o telefone do professor (formato xxxxxxxxxxx): ");
        String telefone = scanner.nextLine();
        professor.setTelefone(telefone);

        System.out.println("");
    }

    public void exibirProfessores( ArrayList<ProfessorModel> professores) {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", "ID", "Nome",
        "Data Nascimento", "Email", "Endereco", "Telefone");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (ProfessorModel professorModel: professores) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",professorModel.getId(), professorModel.getNome(), 
            professorModel.getDataNascimento(), professorModel.getEmail(), professorModel.getEndereco(), professorModel.getTelefone());
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public int obterId(){
        System.out.println("Qual o id do professor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public String obterEmail(){
        System.out.println("Digite o novo email do professor (formato xxxxx@xxxxxxxxxx): ");
        String email = scanner.nextLine();
        return email;
    }

    public String obterTelefone(){
        System.out.println("Digite o novo telefone do professor (formato xxxxxxxxxxx): ");
        String telefone = scanner.nextLine();
        return telefone;
    }
}
