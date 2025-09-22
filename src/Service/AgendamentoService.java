package service;

import model.Agendamento;
import repository.interfaces.IRepository;
import java.util.List;

public class AgendamentoService {
    private IRepository<Agendamento> repository;

    public AgendamentoService(IRepository<Agendamento> repository) {
        this.repository = repository;
    }

    public void adicionar(Agendamento agendamento) {
        repository.adicionar(agendamento);
    }

    public void remover(int id) {
        repository.remover(id);
    }

    public Agendamento buscar(int id) {
        return repository.buscar(id);
    }

    public List<Agendamento> listar() {
        return repository.listar();
    }
}
