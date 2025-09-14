package repository;

import model.Paciente;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepositoryLista implements IRepository<Paciente> {
    private List<Paciente> pacientes = new ArrayList<>();

    @Override
    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    @Override
    public void remover(int id) {
        pacientes.removeIf(p -> p.getId() == id);
    }

    @Override
    public Paciente buscar(int id) {
        return pacientes.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Paciente> listar() {
        return new ArrayList<>(pacientes);
    }


}