package repository.interfaces;
import java.util.List;

public interface IRepository<T> {
    void adicionar(T entidade);
    void remover(int id);
    T buscar(int id);
    List<T> listar();

}
