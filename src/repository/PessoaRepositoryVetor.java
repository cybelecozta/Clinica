package repository;

import model.Pessoa;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PessoaRepositoryVetor implements IRepository<Pessoa> {
    private Pessoa[] pessoas;
    private int contador = 0;

    public PessoaRepositoryVetor(int tamanho) {
        this.pessoas = new Pessoa[tamanho];
    }

    @Override
    public void adicionar(Pessoa pessoa) {
        if (contador < pessoas.length) {
            pessoas[contador++] = pessoa;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i] != null && pessoas[i].getId() == id) {
                pessoas[i] = null; // marca como removido
                break;
            }
        }
    }

    @Override
    public Pessoa buscar(int id) {
        for (int i = 0; i < contador; i++) {
            if (pessoas[i] != null && pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }
        return null;
    }

    @Override
    public List<Pessoa> listar() {
        return new ArrayList<>(Arrays.asList(pessoas));
    }
}
