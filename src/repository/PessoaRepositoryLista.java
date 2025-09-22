package repository;

import model.Pessoa;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryLista implements IRepository<Pessoa> {
    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    public void adicionar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    @Override
    public void remover(int id) {
        pessoas.removeIf(p -> p.getId() == id);
    }

    @Override
    public Pessoa buscar(int id) {
        return pessoas.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Pessoa> listar() {
        return pessoas;
    }

}
