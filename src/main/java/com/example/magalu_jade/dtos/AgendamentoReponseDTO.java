package com.example.magalu_jade.dtos;

import com.example.magalu_jade.enuns.StatusAgendamento;
import com.example.magalu_jade.enuns.TipoComunicacao;

import java.time.LocalDateTime;

public record AgendamentoReponseDTO(

        Long id,
        String destinatario,
        String mensagem,
        TipoComunicacao tipoComunicacao,

        LocalDateTime dataHoraEnvio,

        StatusAgendamento status,
        LocalDateTime dataHoraFinalizacao
) {
}
