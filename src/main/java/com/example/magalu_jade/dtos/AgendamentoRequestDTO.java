package com.example.magalu_jade.dtos;

import com.example.magalu_jade.enuns.TipoComunicacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        @NotBlank(message = "O destinatário é Obrigatório")
        String destinatario,

        @NotBlank(message = "A mensagem é Obrigatória")
        String mensagem,
        @NotBlank(message = "O tipo de Comunicação é Obrigatorio")
        TipoComunicacao tipoComunicacao,
        @NotNull(message = "A data e hora de envio são Obrigatorios!")
        @NotBlank(message = "A data e hora de envio deve ser futura!")
        LocalDateTime dataHoraEnvio


) {
}
