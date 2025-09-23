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
        for (Paciente p : repository.listar()) {
            if (p.getId() == paciente.getId()) {
                System.out.println("ID já cadastrado!");
                return;
            }
            if (p.getCpf() != null && p.getCpf().equals(paciente.getCpf())) {
                System.out.println("CPF já cadastrado!");
                return;
            }
        }

        
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
