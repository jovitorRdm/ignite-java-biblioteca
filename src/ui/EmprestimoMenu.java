package ui;

import model.Emprestimo;
import model.Livro;
import service.Biblioteca;
import util.ClearConsole;

import java.util.List;
import java.util.Scanner;

public class EmprestimoMenu {

    private final Scanner scan;
    private final Biblioteca biblioteca;

    public EmprestimoMenu(Scanner scan) {
        this.scan = scan;
        this.biblioteca = new Biblioteca();
    }

    public void exibir() {
        int escolha = 0;
        while (escolha != 4) {
            ClearConsole.clear();
            System.out.println("=== MENU EMPRÉSTIMOS ===");
            System.out.println("1 - Emprestar Livro");
            System.out.println("2 - Devolver Livro");
            System.out.println("3 - Visualizar Empréstimos");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha: ");
            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1 -> emprestarLivro();
                case 2 -> devolverLivro();
                case 3 -> visualizarEmprestimos();
                case 4 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void emprestarLivro() {
        ClearConsole.clear();
        System.out.println("Emprestar livro:");

        List<Livro> livros = biblioteca.ListarLivros();
        for (Livro livro : livros) {
            System.out.printf("%d - %s (Autor: %s)\n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
        }

        System.out.print("\nDigite o ID do livro: ");
        int idLivro = scan.nextInt();
        scan.nextLine();

        Livro livroSelecionado = null;
        for (Livro livro : livros) {
            if (livro.getId() == idLivro) {
                livroSelecionado = livro;
                break;
            }
        }

        if (livroSelecionado != null) {
            System.out.print("Digite o nome do usuário: ");
            String nomeUsuario = scan.nextLine();
            biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }

        pausar();
    }

    private void devolverLivro() {
        ClearConsole.clear();
        visualizarEmprestimos();

        System.out.print("\nDigite o ID do empréstimo para devolver: ");
        int idEmprestimo = scan.nextInt();
        biblioteca.devolverLivro(idEmprestimo);

        System.out.println("Livro devolvido com sucesso!");
        pausar();
    }

    private void visualizarEmprestimos() {
        ClearConsole.clear();
        List<Emprestimo> emprestimos = biblioteca.listarEmprestimos();

        System.out.println("Lista de empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.printf("ID: %d | Livro: %s | Usuário: %s\n",
                    emprestimo.getId(),
                    emprestimo.getLivro().getTitulo(),
                    emprestimo.getNomeUsuario());
        }

        pausar();
    }

    private void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scan.nextLine();
    }
}
