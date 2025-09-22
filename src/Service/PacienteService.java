package service;

import model.Paciente;
import repository.interfaces.IRepository;
import java.util.List;

public class PacienteService {
    private IRepository<Paciente> repository;

    public PacienteService(IRepository<Paciente> repository) {
        this.repository = repository;
    }

    public void adicionar(Paciente paciente) {
        repository.adicionar(paciente);
    }

    public void remover(int id) {
        repository.remover(id);
    }

    public Paciente buscar(int id) {
        return repository.buscar(id);
    }

    public List<Paciente> listar() {
        return repository.listar();
    }
}
