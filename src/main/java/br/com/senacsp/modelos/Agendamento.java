package br.com.senacsp.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String horario;
    private String data;
    private String nomeCliente;
    private Boolean disponivel = true;

    public Agendamento(Long id, String horario, String data, String nomeCliente) {
        this.id = id;
        this.horario = horario;
        this.data = data;
        this.nomeCliente = nomeCliente;
    }

    public Agendamento() {}

    @Override
    public String toString() {
        return nomeCliente + " - " + horario + " - " + data;
    }

    public Long getId() { return id; }
    public String getHorario() { return horario; }
    public String getNomeCliente() { return nomeCliente; }
    public String getData() { return data; }
    public Boolean getDisponivel() { return disponivel; }

    public void setHorario(String horario) { this.horario = horario; }
    public void setData(String data) { this.data = data; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}