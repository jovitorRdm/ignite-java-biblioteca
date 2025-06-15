package service;

import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.Emprestimo;
import model.Livro;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // AUTORES

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void atualizarAutor(int id, String newNome) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                autor.setNome(newNome);
                break;
            }
        }
    }

    public List<Autor> listarAutores() {
        return autores;
    }

    public void deletarAutor(int idDelete) {
        autores.removeIf(autor -> autor.getId() == idDelete);
    }

    // LIVROS

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void atualizarLivro(int id, String newTitulo) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                livro.setTitulo(newTitulo);
                break;
            }
        }
    }

    public List<Livro> ListarLivros() {
        return livros;
    }

    public void deletarLivro(int idDelete) {
        livros.removeIf(livro -> livro.getId() == idDelete);
    }

    // emprestimo

    public void realizarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void atualizarEmprestimo(int id, String newNome) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                autor.setNome(newNome);
                break;
            }
        }
    }

    public void emprestarLivro(Livro livro, String nomeUsuario) {
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario); 
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        }else{
            System.out.println("livro indisponivel para emprestimo!");
        }
    }

    public void devolverLivro(int idEmprestimo) {
        for(Emprestimo emprestimo : emprestimos){
            if (emprestimo.getId() == idEmprestimo) {
                emprestimo.devolverLivro();
                break;
            }
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

}