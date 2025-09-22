package model;

public class Paciente extends Pessoa{
    private String telefone;

    public Paciente(String nome, String cpf, int id, String telefone) {
        super(nome, cpf, id);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Paciente: " + super.getNome() + '\n' +
                "CPF: " + super.getCpf() + '\n' +
                "Telefone: " + telefone + '\n' +
                "ID: " + super.getId();
    }
}

