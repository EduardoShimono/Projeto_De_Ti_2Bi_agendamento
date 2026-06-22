package br.com.senacsp.controller;

import br.com.senacsp.modelos.Agendamento;
import br.com.senacsp.repository.AgendamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository repository;

    public AgendamentoController(AgendamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Agendamento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        return repository.save(agendamento);
    }

    @PatchMapping("/{id}/marcar")
    public ResponseEntity<?> marcar(@PathVariable Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        if (!agendamento.getDisponivel()) {
            return ResponseEntity.badRequest().body("Este agendamento já está ocupado.");
        }

        boolean horarioOcupado = repository.existsByHorarioAndDataAndDisponivelFalse(
                agendamento.getHorario(), agendamento.getData()
        );

        if (horarioOcupado) {
            return ResponseEntity.badRequest().body("Já existe um agendamento neste horário e data.");
        }

        agendamento.setDisponivel(false);
        return ResponseEntity.ok(repository.save(agendamento));
    }
}