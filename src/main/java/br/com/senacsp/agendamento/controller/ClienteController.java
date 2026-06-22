package br.com.senacsp.agendamento.controller;

import br.com.senacsp.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

   @GetMapping
    public String teste(){
        return "Controller funcionando!";
   }
}
