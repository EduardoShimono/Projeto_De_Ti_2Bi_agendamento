package br.com.senacsp.repository;

import br.com.senacsp.modelos.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    boolean existsByHorarioAndDataAndDisponivelFalse(String horario, String data);
}