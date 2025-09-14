package repository;

import model.Paciente;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacienteRepositoryVetor implements IRepository<Paciente> {
    private Paciente[] pacientes;
    private int contador = 0;

    public PacienteRepositoryVetor(int tamanho) {
        this.pacientes = new Paciente[tamanho];
    }

    @Override
    public void adicionar(Paciente paciente) {
        if (contador < pacientes.length) {
            pacientes[contador++] = paciente;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (pacientes[i] != null && pacientes[i].getId() == id) {
                // desloca elementos à esquerda
                for (int j = i; j < contador - 1; j++) {
                    pacientes[j] = pacientes[j + 1];
                }
                pacientes[--contador] = null; // decrementa contador
                break;
            }
        }
    }


    @Override
    public Paciente buscar(int id) {
        for (int i = 0; i < contador; i++) {
            if (pacientes[i] != null && pacientes[i].getId() == id) {
                return pacientes[i];
            }
        }
        return null;
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<>();
        for (int i = 0; i < contador; i++) {
            lista.add(pacientes[i]);
        }
        return lista;
    }

}
