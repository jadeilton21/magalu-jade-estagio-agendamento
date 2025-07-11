package com.example.magalu_jade;


import com.example.magalu_jade.controller.AgendamentoController;
import com.example.magalu_jade.dtos.AgendamentoReponseDTO;
import com.example.magalu_jade.dtos.AgendamentoRequestDTO;
import com.example.magalu_jade.enuns.StatusAgendamento;
import com.example.magalu_jade.enuns.TipoComunicacao;
import com.example.magalu_jade.model.Agendamento;
import com.example.magalu_jade.service.AgendamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;

@WebMvcTest(AgendamentoController.class)
public class AgendamentoControllerTest {


    // PERMITE SIMULAR REQUISIÇÕES HTTP(POST,GET,DELETE)
    @Autowired
    private MockMvc mockMvc;

    // Objetct Mapper --> Converte Objetos em Json e vice-versa
    @Autowired
    private ObjectMapper objectMapper;



    //Criar um mock do service usando dentro do controller
    // Evitar chamadas reais ao banco de dados ou regra de negocio.

    // Esse mock vai ser injetado no controller pela Spring, simulando o comportamento esperado para testes.
    @MockitoBean
    private AgendamentoService service;

    @Test
    void deveAgendamento() throws Exception {


        AgendamentoRequestDTO requestDTO = new AgendamentoRequestDTO(
                "jadeiltondm@gmail.com",
                "Mensagem de envio",
                TipoComunicacao.EMAIL,
                LocalDateTime.now().plusMinutes(1)
        );


        AgendamentoReponseDTO reponseDTO = new AgendamentoReponseDTO(
          1L,
                requestDTO.destinatario(),
                requestDTO.mensagem(),
                requestDTO.tipoComunicacao(),
                requestDTO.dataHoraEnvio(),
                StatusAgendamento.AGENDADO,
                LocalDateTime.now()

        );


        when(service.agendar(any())).thenReturn(reponseDTO);

        mockMvc.perform(post("/api/agendamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.destinatario").value("jadeiltondm@gmail.com"));


    }



    @Test
    void deveBuscarAgendamentoPorId() throws Exception {
        Long id = 1L;

        AgendamentoReponseDTO reponseDTO = new AgendamentoReponseDTO(

                1L,
                "jadeiltondm@gmail.com",
                "mensagem de envio",
                TipoComunicacao.SMS,
                LocalDateTime.now().plusMinutes(2),
                StatusAgendamento.AGENDADO,
                LocalDateTime.now()
        );


        when(service.buscarPorId(id)).thenReturn(reponseDTO);



        mockMvc.perform(get("/api/agendamentos/{id}",id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.tipoComunicacao").value("SMS"));
    }

    @Test
    void deveRemoverAgendamentoPorId() throws Exception {
        Long id = 1L;
        doNothing().when(service).remover(id);


        mockMvc.perform(delete("/api/agendamentos/{id}",id))
                .andExpect(status().isOk());
    }

}
