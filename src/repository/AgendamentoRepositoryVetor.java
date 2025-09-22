package repository;

import model.Agendamento;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoRepositoryVetor implements IRepository<Agendamento> {
    private Agendamento[] agendamentos;
    private int contador = 0;

    public AgendamentoRepositoryVetor(int tamanho) {
        this.agendamentos = new Agendamento[tamanho];
    }

    @Override
    public void adicionar(Agendamento agendamento) {
        if (contador < agendamentos.length) {
            agendamentos[contador++] = agendamento;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (agendamentos[i] != null && agendamentos[i].getPaciente().getId() == id) {            
                for (int j = i; j < contador - 1; j++) {
                    agendamentos[j] = agendamentos[j + 1];
                }
                agendamentos[--contador] = null;
                break;
            }
        }
    }

    @Override
    public Agendamento buscar(int id) {
        for (int i = 0; i < contador; i++) {
            if (agendamentos[i] != null && agendamentos[i].getPaciente().getId() == id) {
                return agendamentos[i];
            }
        }
        return null;
    }

    @Override
    public List<Agendamento> listar() {
        List<Agendamento> lista = new ArrayList<>();
        for (int i = 0; i < contador; i++) {
            lista.add(agendamentos[i]);
        }
        return lista;
    }
}
