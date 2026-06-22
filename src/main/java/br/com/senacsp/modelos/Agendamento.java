package br.com.senacsp.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String horario;
    private String data;
    private String nomeCliente;

    public Agendamento(long id, String horario, String data, String nomeCliente) {
        this.id = id;
        this.horario = horario;
        this.data = data;
        this.nomeCliente = nomeCliente;
    }

    public Agendamento() {
    }

    @Override
    public String toString() {
        return nomeCliente + " - " + horario + " - " + data;
    }

    public long getId() {
        return id;
    }
    public String getHorario() {
        return horario;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public String getData() {
        return data;
    }
}
