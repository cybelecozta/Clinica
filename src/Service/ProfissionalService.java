package service;

import model.Profissional;
import repository.interfaces.IRepository;
import java.util.List;

public class ProfissionalService {
    private IRepository<Profissional> repository;

    public ProfissionalService(IRepository<Profissional> repository) {
        this.repository = repository;
    }

    public void adicionar(Profissional profissional) {
        repository.adicionar(profissional);
    }

    public void remover(int id) {
        repository.remover(id);
    }

    public Profissional buscar(int id) {
        return repository.buscar(id);
    }

    public List<Profissional> listar() {
        return repository.listar();
    }
}
