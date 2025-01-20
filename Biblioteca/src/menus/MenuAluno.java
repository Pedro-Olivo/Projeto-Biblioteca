package menus;

import controller.AlunoController;
import java.util.Scanner;

public class MenuAluno {
    
    public void main(String[] args) {
        
        AlunoController controller = new AlunoController();
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;

        while (opcao != 5){

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Escolha a opção desejada:");
            System.out.println("1-Criar aluno");
            System.out.println("2-Listar alunos");
            System.out.println("3-Editar aluno");
            System.out.println("4-Remover aluno");
            System.out.println("5-Sair");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("");

            System.out.println("Digite o número da sua escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    controller.cadastrar();
                    System.out.println("");
                    break;

                case 2:
                    controller.listar();
                    System.out.println("");
                    break;
                    
                case 3:
                    controller.editar();
                    System.out.println("");
                    break;

                case 4:
                    controller.remover();
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("Encerrando o menu de alunos");
                    System.out.println("");
                    break;

                default:
                    System.out.println("Opção inválida. tente novamente.");
                    System.out.println("");
            }
        }
    }
}
