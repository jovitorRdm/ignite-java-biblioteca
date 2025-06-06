import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void clearConsole() {
    try {
      if (System.getProperty("os.name").toLowerCase().contains("windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
    } catch (IOException | InterruptedException ex) {
      System.out.println("Não foi possível limpar o terminal.");
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Biblioteca wiki = new Biblioteca();
    int escolha = 0;
    while (escolha != 9) {
      clearConsole();
      System.out.println("=========================================");
      System.out.println("|      FUNCIONALIDADES - BIBLIOTECA     |");
      System.out.println("=========================================");
      System.out.println("| 1. Adicionar autor         → digite 1 |");
      System.out.println("| 2. Atualizar autor         → digite 2 |");
      System.out.println("| 3. Listar autores          → digite 3 |");
      System.out.println("| 4. Excluir autor           → digite 4 |");
      System.out.println("| 9. Sair                    → digite 9 |");
      System.out.println("=========================================");
      System.out.print("Escolha uma opção: ");
      escolha = scan.nextInt();

      scan.nextLine();
      switch (escolha) {
        case 1:
          clearConsole();
          System.out.println("-------ADICIONANDO-AUTOR-------");
          System.out.println("");

          System.out.print("Digite o id do autor: ");
          int idAutor = scan.nextInt();
          scan.nextLine();

          System.out.print("Digite o nome do autor: ");
          String nomeAutor = scan.nextLine();

          Autor autor = new Autor(idAutor, nomeAutor, new Date());

          wiki.adicionarAutor(autor);

          System.out.println("");
          System.out.println("----ADICIONADO-COM-SUCESSO----");
          break;
        case 2:
          clearConsole();
          System.out.println("-------EDITANDO-AUTOR-------");
          System.out.println("");
          System.out.print("Digite o id do autor: ");
          int idUpdate = scan.nextInt();
          scan.nextLine();

          System.out.print("Digite o novo nome: ");
          String newNome = scan.next();

          wiki.atualizarAutor(idUpdate, newNome);

          System.out.println("");
          System.out.println("----EDITADO-COM-SUCESSO----");
          break;
        case 3:
          clearConsole();
          List<Autor> autores = new ArrayList<>();
          autores = wiki.ListarAutores();
          System.out.println("-------LISTANDO-AUTORES-------");
          System.out.println("");
          for (Autor auto : autores) {
            System.out.println(String.format("%d %s", auto.getId(), auto.getNome()));
          }

          System.out.println("");
          System.out.println("----LISTADO-COM-SUCESSO----");
          System.out.println("Pressione ENTER para continuar...");
          scan.nextLine();
          break;
        case 4:
          clearConsole();
          System.out.println("-------EXCLUINDO-AUTOR-------");
          System.out.println("");
          System.out.print("Digite o id do autor: ");
          int idDelete = scan.nextInt();
          wiki.deletarAutor(idDelete);
          System.out.println("");
          System.out.println("----EXCLUIDO-COM-SUCESSO----");
          break;

        default:
          break;
      }
    }
  }
}