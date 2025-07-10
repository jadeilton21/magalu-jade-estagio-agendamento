package com.example.magalu_jade.model;


import com.example.magalu_jade.enuns.StatusAgendamento;
import com.example.magalu_jade.enuns.TipoComunicacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Agendamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinatario;

    @Column(nullable = false , columnDefinition = "TEXT")
    private String mensagem;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComunicacao tipoComunicacao;

    @Column(nullable = false)
    private LocalDateTime dataHoraEnvio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento status;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

}
