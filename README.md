# 📅 Sistema de Agendamentos - Teste de Estágio Magalu

Este projeto foi desenvolvido como parte de um **teste de estágio para o Magazine Luiza (Magalu)**. Ele consiste em uma API REST utilizando **Java com Spring Boot**, com funcionalidades básicas para **agendar compromissos, consultar por ID e excluir agendamentos**, persistindo os dados em um banco **PostgreSQL**.

---

## 🚀 Tecnologias Utilizadas

- Java 21+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

---

## 📌 Funcionalidades da API

| Método | Endpoint            | Descrição                                |
|--------|----------------------|--------------------------------------------|
| POST   | `/agendamentos`      | Cria um novo agendamento                   |
| GET    | `/agendamentos/{id}` | Busca um agendamento pelo ID               |
| DELETE | `/agendamentos/{id}` | Deleta um agendamento pelo ID              |

---

## 🧪 Como Executar o Projeto

### 1. Configure o Banco de Dados PostgreSQL

Crie um banco de dados no PostgreSQL, por exemplo:

```sql
CREATE DATABASE agendamentos;
