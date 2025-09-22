package repository;

import model.Agendamento;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepositoryLista implements IRepository<Agendamento> {
    private List<Agendamento> agendamentos = new ArrayList<>();

    @Override
    public void adicionar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    @Override
    public void remover(int id) {
        agendamentos.removeIf(a -> a.getPaciente().getId() == id);
    }

    @Override
    public Agendamento buscar(int id) {
        return agendamentos.stream()
                .filter(a -> a.getPaciente().getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Agendamento> listar() {
        return new ArrayList<>(agendamentos);
    }
}
