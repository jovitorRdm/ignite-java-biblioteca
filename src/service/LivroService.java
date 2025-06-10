package service;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private List<Livro> livros = new ArrayList<>();

    public void adicionar(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarTodos() {
        return livros;
    }

    public List<Livro> listarDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public Livro buscarPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) return livro;
        }
        return null;
    }

    public void atualizar(int id, String novoTitulo) {
        Livro livro = buscarPorId(id);
        if (livro != null) {
            livro.setTitulo(novoTitulo);
        }
    }

    public void remover(int id) {
        livros.removeIf(livro -> livro.getId() == id);
    }
}
