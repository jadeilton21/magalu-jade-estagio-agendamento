package com.example.magalu_jade.service;


import com.example.magalu_jade.dtos.AgendamentoReponseDTO;
import com.example.magalu_jade.dtos.AgendamentoRequestDTO;
import com.example.magalu_jade.enuns.StatusAgendamento;
import com.example.magalu_jade.model.Agendamento;
import com.example.magalu_jade.repository.AgendamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {


    private final AgendamentoRepository agendamentoRepository;


    public AgendamentoReponseDTO agendar(AgendamentoRequestDTO agendamentoRequestDTO) {

        Agendamento agendamento = Agendamento.builder()
                .destinatario(agendamentoRequestDTO.destinatario())
                .mensagem(agendamentoRequestDTO.mensagem())
                .tipoComunicacao(agendamentoRequestDTO.tipoComunicacao())
                .dataHoraEnvio(agendamentoRequestDTO.dataHoraEnvio())
                .status(StatusAgendamento.AGENDADO)
                .criadoEm(LocalDateTime.now())
                .build();

        return toReponse(agendamentoRepository.save(agendamento));
    }



    public AgendamentoReponseDTO buscarPorId(Long id){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Agendamento não Encontrado"));
        return toReponse(agendamento);
    }

    public void remover(Long id){
        if(!agendamentoRepository.existsById(id)){
            throw new EntityNotFoundException("Agendamento não encontrado!!");
        }

        agendamentoRepository.deleteById(id);
    }


    public AgendamentoReponseDTO toReponse(Agendamento agendamento) {
        return new AgendamentoReponseDTO(
                agendamento.getId(),
                agendamento.getDestinatario(),
                agendamento.getMensagem(),
                agendamento.getTipoComunicacao(),
                agendamento.getDataHoraEnvio(),
                agendamento.getStatus(),
                agendamento.getCriadoEm()
        );

    }
}
