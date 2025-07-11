package com.example.magalu_jade;


import com.example.magalu_jade.controller.AgendamentoController;
import com.example.magalu_jade.dtos.AgendamentoRequestDTO;
import com.example.magalu_jade.enuns.TipoComunicacao;
import com.example.magalu_jade.service.AgendamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

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
                "Eu te amo",
                TipoComunicacao.EMAIL,
                LocalDateTime.now().plusMinutes(1)
        );
        

    }

}
