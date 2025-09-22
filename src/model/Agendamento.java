package model;
import java.time.LocalDateTime;

public class Agendamento {
    private Paciente paciente;
    private Profissional profissional;
    private LocalDateTime dataHora;
    private String observacoes;
    private int id;

    public Agendamento(Paciente paciente, Profissional profissional, LocalDateTime dataHora, String observacoes, int id) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
        this.id=id;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getObservacoes() {
        return observacoes;
    }


    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Paciente: " + paciente.getNome() + "\n" +
                "Profissional: " + profissional.getNome() + "\n" +
                "Detalhes: " + dataHora + "\n" +
                "Observacoes: " + observacoes + '\n';
    }
}



