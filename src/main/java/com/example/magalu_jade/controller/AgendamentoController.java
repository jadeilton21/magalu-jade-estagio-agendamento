package com.example.magalu_jade.controller;


import com.example.magalu_jade.dtos.AgendamentoReponseDTO;
import com.example.magalu_jade.dtos.AgendamentoRequestDTO;
import com.example.magalu_jade.repository.AgendamentoRepository;
import com.example.magalu_jade.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {


    private final AgendamentoService agendamentoService;


    @PostMapping
    public ResponseEntity<AgendamentoReponseDTO> agendar(AgendamentoRequestDTO request) {

        AgendamentoReponseDTO  response = agendamentoService.agendar(request);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoReponseDTO> buscarPorId(@PathVariable Long id) {

        AgendamentoReponseDTO  response = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        agendamentoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
