import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Autor> autores = new ArrayList<>();

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
}