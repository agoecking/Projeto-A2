# Projeto: Sistema de Agendamento de Consultas Médicas

## Descrição

Este é um projeto de console desenvolvido em Java, focado na gestão e agendamento de consultas médicas. O sistema permite o cadastro de médicos e clientes, a gestão de horários disponíveis pelos médicos e a marcação de consultas, com persistência de dados em arquivos de texto local (TXT).

## Funcionalidades

O sistema oferece um menu interativo com as seguintes operações (implementadas na classe `Main.java`):

1.  **Cadastrar Novo Médico** (Salva o médico em txt no `MedicoRepository`)
2.  **Listar Todos os Médicos** (Lista todos os médicos do `medicos.txt`)
3.  **Cadastrar Novo Cliente** (Salva o cliente em txt no `ClienteRepository`)
4.  **Listar Todos os Clientes** (Lista todos os clientes do `clientes.txt`)
5.  **Cadastrar Horário Vago para Médico**: Permite que um médico (buscado por CRM) cadastre um horário como `LIVRE`.
6.  **Listar Todos os Agendamentos**: Exibe a lista de consultas confirmadas.
7.  **Marcar uma Consulta**: Permite que um cliente escolha um dos horários `LIVRE` cadastrados, atualizando seu status para `AGENDADO` e movendo o registro do `HorarioLivreRepository` para o `AgendamentoRepository`.

## Arquitetura e Tecnologias

* **Linguagem:** Java (versão 17).
* **Paradigma:** Orientação a Objetos (POO).
* **Arquitetura:** Camadas.
* **Modelagem de Dados:**
    * Classe abstrata `Pessoa` com atributos comuns (nome, CPF, RG, etc.).
    * Classes `Cliente` e `Medico` que herdam de `Pessoa`.
    * `Cliente` inclui a composição de um objeto `Endereco`.
    * `Medico` possui atributos específicos como `crm` e listas de `Especialidade` e `Disponibilidade`.
    * Uso de `enum` (`StatusAgendamento`) para gerenciar o estado das consultas (LIVRE, AGENDADO).
* **Camada de Persistência (CRUD):**
    * Interface `CrudRepository<T>` define os métodos básicos (`Salvar`, `Listar`, `Deletar`).
    * Classes como `ClienteRepository`, `MedicoRepository`, `AgendamentoRepository` e `HorarioLivreRepository` implementam essa interface, aplicando o polimorfismo.
* **Gerenciamento de Arquivos:** A classe utilitária `GerenciamentoDatabase` é responsável por ler e escrever os dados de/para os arquivos TXT, garantindo a persistência.
* **Log:** Implementação da classe `LogService` para registro de ações e erros.

## Autores

* Albrecht (12955345)
* Joallyfer (37869337)

## Diagrama de Classes

O diagrama de classes do projeto pode ser visualizado no seguinte link:

[Diagrama do Projeto](https://app.diagrams.net/#G1xWk86aoFnFHR_mWdToxIkctkAL8Utgym#%7B%22pageId%22%3A%22Esip6vwrr6jEOZYmGrqr%22%7D)
