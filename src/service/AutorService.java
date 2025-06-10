package service;

import java.util.ArrayList;
import java.util.List;

import model.Autor;

public class AutorService {
    private List<Autor> autores = new ArrayList<>();

    public void adicionar(Autor autor){
        autores.add(autor);
    }

    public List<Autor> listarTodos(){
        return autores;
    }

    public void atualizarNome(int id, String newName){
        for(Autor autor : autores){
            if (autor.getId() == id) {
                autor.setNome(newName);
            }
        }
    }

    public void remover(int idDelet){
        autores.removeIf(autor -> autor.getId() == idDelet);
    }
}
