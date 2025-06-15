package ui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Autor;
import model.Emprestimo;
import model.Livro;
import service.Biblioteca;
import util.ClearConsole;

public class Menu {

    private final Scanner scan;
    private final Biblioteca biblioteca;

    public Menu() {
        scan = new Scanner(System.in);
        biblioteca = new Biblioteca();
    }

    public void exibir() {
        int escolha = 0;
        while (escolha != 99) {
            ClearConsole.clear();
            System.out.println("===========================================");
            System.out.println("|      FUNCIONALIDADES - BIBLIOTECA       |");
            System.out.println("===========================================");
            System.out.println("| 1.  Adicionar autor       -> digite 1   |");
            System.out.println("| 2.  Atualizar autor       -> digite 2   |");
            System.out.println("| 3.  Listar autores        -> digite 3   |");
            System.out.println("| 4.  Excluir autor         -> digite 4   |");
            System.out.println("| 5.  Adicionar Livro       -> digite 5   |");
            System.out.println("| 6.  Listar Livros         -> digite 6   |");
            System.out.println("| 7.  Atualizar Livros      -> digite 7   |");
            System.out.println("| 8.  Excluir Livros        -> digite 8   |");
            System.out.println("| 9.  Realizar Emprestimo   -> digite 9   |");
            System.out.println("| 10. Realizar Devolução    -> digite 10  |");
            System.out.println("| 11. Listar Emprestimos    -> digite 11  |");
            System.out.println("| 99. Sair                  -> digite 99  |");
            System.out.println("==========================================");
            System.out.print("Escolha uma opção: ");
            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1:
                    adicionarAutor();
                    break;
                case 2:
                    atualizarAutor();
                    break;
                case 3:
                    listarAutores();
                    pausar();
                    break;
                case 4:
                    deletarAutor();
                    break;
                case 5:
                    adicionarLivro();
                    break;
                case 6:
                    ListarLivros();
                    pausar();
                    break;
                case 7:
                    atualizarLivro();
                    break;
                case 8:
                    deletarLivro();
                    break;
                case 9:
                    emprestarLivro();
                    break;
                case 10:
                    devolverLivro();
                    break;
                case 11:
                    visualizarEmprestimos();
                    pausar();
            }
        }
    }

    private void adicionarAutor() {
        ClearConsole.clear();
        System.out.println("-------ADICIONANDO-AUTOR-------\n");
        System.out.print("Digite o id do autor: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite o nome do autor: ");
        String nome = scan.nextLine();

        biblioteca.adicionarAutor(new Autor(id, nome, new Date()));

        System.out.println("\n----ADICIONADO COM SUCESSO----");
    }

    private void atualizarAutor() {
        ClearConsole.clear();
        System.out.println("-------EDITANDO-AUTOR-------\n");
        System.out.print("Digite o id do autor: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite o novo nome: ");
        String nome = scan.nextLine();

        biblioteca.atualizarAutor(id, nome);

        System.out.println("\n----EDITADO COM SUCESSO----");
    }

    private void listarAutores() {
        ClearConsole.clear();
        List<Autor> autores = biblioteca.listarAutores();
        System.out.println("-------LISTANDO-AUTORES-------\n");

        for (Autor autor : autores) {
            System.out.printf("%d %s\n", autor.getId(), autor.getNome());
        }

        System.out.println("\n----LISTADO COM SUCESSO----");
    }

    private void deletarAutor() {
        ClearConsole.clear();
        System.out.println("-------EXCLUINDO-AUTOR-------\n");
        System.out.print("Digite o id do autor: ");
        int id = scan.nextInt();

        biblioteca.deletarAutor(id);

        System.out.println("\n----EXCLUÍDO COM SUCESSO----");
    }

    private void pausar() {
        System.out.println("Pressione ENTER para continuar...");
        scan.nextLine();
    }

    private void adicionarLivro() {
        ClearConsole.clear();
        System.out.println("-------ADICIONANDO-LIVRO-------\n");
        System.out.print("Digite o id do livro: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Digite o titulo do livro: ");
        String titulo = scan.nextLine();

        ClearConsole.clear();
        listarAutores();

        System.out.print("Digite o id do autor do livro: ");
        int idAutor = scan.nextInt();

        List<Autor> autores = biblioteca.listarAutores();

        Autor autorLivro = null;

        for (Autor autor : autores) {
            if (autor.getId() == idAutor) {
                autorLivro = autor;
            }
        }

        biblioteca.adicionarLivro(new Livro(id, titulo, autorLivro));

        System.out.println("\n----ADICIONADO COM SUCESSO----");
    }

    private void atualizarLivro() {
        ClearConsole.clear();
        ListarLivros();
        System.out.println("-------EDITANDO-LIVRO-------\n");
        System.out.print("Digite o id do Livro: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o novo titulo do Livro: ");
        String titulo = scan.nextLine();

        biblioteca.atualizarLivro(id, titulo);

        System.out.println("\n----EDITADO COM SUCESSO----");

    }

    private void ListarLivros() {
        ClearConsole.clear();
        List<Livro> livros = biblioteca.ListarLivros();
        System.out.println("-------LISTANDO-LIVROS-------\n");

        for (Livro livro : livros) {
            System.out.printf("%d: %s de %s\n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
        }

        System.out.println("\n----LISTADO COM SUCESSO----");
    }

    private void deletarLivro() {

        ClearConsole.clear();
        System.out.println("-------EXCLUINDO-LIVRO-------\n");
        System.out.print("Digite o id do livro: ");
        int id = scan.nextInt();

        biblioteca.deletarLivro(id);

        System.out.println("\n----EXCLUÍDO COM SUCESSO----");

    }

    private void emprestarLivro() {
        ClearConsole.clear();
        System.out.println("-------EMPRESTANDO-LIVRO-------\n");

        List<Livro> livros = biblioteca.ListarLivros();

        for (Livro livro : livros) {
            System.out.printf("%d: %s de %s\n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
        }

        System.out.print("\nDigite o id do livro: ");
        int id = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o nome do usuario: ");
        String nomeUsuario = scan.nextLine();

        Livro livroEmprestimo = null;
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livroEmprestimo = livro;
            }
        }

        if (livroEmprestimo != null) {
            biblioteca.emprestarLivro(livroEmprestimo, nomeUsuario);
            System.out.println("\n----EMPRESTADO COM SUCESSO----");
        } else {
            System.out.println("\n!! Livro com ID inválido !!");
        }
    }

    private void devolverLivro() {
        ClearConsole.clear();
        visualizarEmprestimos();
        System.out.println("-------DEVOLVER-LIVRO-------\n");
        System.out.print("Digite o id do emprestimo: ");
        int id = scan.nextInt();

        biblioteca.devolverLivro(id);

        System.out.println("\n----DEVOLVIDO COM SUCESSO----");
    }

    private void visualizarEmprestimos() {
        ClearConsole.clear();
        List<Emprestimo> emprestimos = biblioteca.listarEmprestimos();
        System.out.println("-------LISTANDO-EMPRESTIMOS-------\n");

        for (Emprestimo emprestimo : emprestimos) {
            System.out.printf("id: %d Livro: %s - Emprestado para: %s\n", emprestimo.getId(), emprestimo.getLivro().getTitulo(),
                    emprestimo.getNomeUsuario());
        }

        System.out.println("\n----LISTADO COM SUCESSO----");
    }
}
