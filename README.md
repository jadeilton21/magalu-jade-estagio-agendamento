# 📅 Sistema de Agendamentos - Teste de Estágio Magalu

Este projeto foi desenvolvido como parte de um **teste de estágio para o Magazine Luiza (Magalu)**. Ele consiste em uma API REST simples utilizando **Java com Spring Boot**, com funcionalidades básicas para **agendar, buscar e deletar** compromissos.

---

## 🚀 Tecnologias Utilizadas

- Java 21+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database (banco de dados em memória para testes)
- Maven

---

## 📌 Funcionalidades da API

| Método | Endpoint        | Descrição                                |
|--------|------------------|--------------------------------------------|
| POST   | `/agendamentos`  | Cria um novo agendamento                   |
| GET    | `/agendamentos/{id}` | Busca um agendamento pelo ID             |
| DELETE | `/agendamentos/{id}` | Deleta um agendamento pelo ID            |

---
