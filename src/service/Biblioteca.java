package service;
import java.util.ArrayList;
import java.util.List;

import model.Autor;
import model.Livro;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>(); 
    private List<Autor> autores = new ArrayList<>();

    //          AUTORES

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

    public List<Autor> ListarAutores() {
        return autores;
    }

    public void deletarAutor(int idDelete) {
        autores.removeIf(autor -> autor.getId() == idDelete);
    }

    //          LIVROS

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public void atualizarLivro(int id, String newTitulo){
        for (Livro livro : livros){
            if (livro.getId() == id) {
                livro.setTitulo(newTitulo);
                break;
            }
        }
    }

    public List<Livro> ListarLivros(){
       return livros; 
    }

    public void deletarLivro(int idDelete){
        livros.removeIf(livro -> livro.getId() == idDelete);
    }


}