package menus;

import java.util.Scanner;

public class MenuPrincipal {
    
    public static void main(String[] args) {
        
        MenuAluno menuAluno = new MenuAluno();
        MenuProfessor menuProfessor = new MenuProfessor();
        MenuLivro menuLivro = new MenuLivro();
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 1;

        while(opcao != 4){

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Escolha a opção desejada:");
            System.out.println("1-Aluno");
            System.out.println("2-Professor");
            System.out.println("3-Livro");
            System.out.println("4-Sair");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("");

            System.out.println("Digite o número da sua escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuAluno.main(args);
                    System.out.println("");
                    break;

                case 2:
                    menuProfessor.main(args);
                    System.out.println("");
                    break;

                case 3:
                    menuLivro.main(args);
                    System.out.println("");
                    break;

                case 4:
                        System.out.println("Programa encerrado");
                        break;

                default:
                    System.out.println("Opção inválida. tente novamente.");
                    System.out.println("");
            }
        }
    }
}
