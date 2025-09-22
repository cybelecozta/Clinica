package repository;

import model.Profissional;
import repository.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalRepositoryLista implements IRepository<Profissional> {
    private List<Profissional> profissionais = new ArrayList<>();

    @Override
    public void adicionar(Profissional profissional) {
        profissionais.add(profissional);
    }


    @Override
    public void remover(int id) {
        profissionais.removeIf(p -> p.getId() == id);
    }

    @Override
    public Profissional buscar(int id) {
        return profissionais.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Profissional> listar() {
        return new ArrayList<>(profissionais);
    }


}