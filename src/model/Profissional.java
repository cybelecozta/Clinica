package model;

public class Profissional extends Pessoa {
    private String especialidade;
    private String crm;

    public Profissional(String nome, String cpf, int id, String especialidade, String crm) {
        super(nome, cpf, id);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Nome: " + super.getNome() + '\n' +
                "Especialidade: " + especialidade + '\n' +
                "ID: " + getId() + "\n" +
                "CRM: " + crm + '\n';
    }

}


