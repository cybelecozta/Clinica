package repository;

import model.Profissional;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfissionalRepositoryVetor implements IRepository<Profissional> {
    private Profissional[] profissionais;
    private int contador = 0;

    public ProfissionalRepositoryVetor(int tamanho) {
        this.profissionais = new Profissional[tamanho];
    }

    @Override
    public void adicionar(Profissional pessoa) {
        if (contador < profissionais.length) {
            profissionais[contador++] = pessoa;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (profissionais[i] != null && profissionais[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    profissionais[j] = profissionais[j + 1];
                }
                profissionais[--contador] = null;
                break;
            }
        }
    }


    @Override
    public Profissional buscar(int id) {
        for (int i = 0; i < contador; i++) {
            if (profissionais[i] != null && profissionais[i].getId() == id) {
                return profissionais[i];
            }
        }
        return null;
    }

    @Override
    public List<Profissional> listar() {
        List<Profissional> lista = new ArrayList<>();
        for (int i = 0; i < contador; i++) {
            lista.add(profissionais[i]);
        }
        return lista;
    }



}
