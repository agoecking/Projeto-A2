Projeto: Serviço de agendamento de consultas médicas
Albrecht
Joallyfer


Projeto em console de um sistema de cadastramento e agendamento de consultas médicas.
Modelos de Cliente e Medico herdam da classe abstrata Pessoa, cada um aplicando alterações necessárias (CRM para médicos, Endereço para Cliente).
Classes repository com métodos de Salvar, Deletar e Listar, atuando como um CRUD implementam a interface CrudRepository aplicando princípios de polimorfismo.
Declaração try/catch assegura tratamento do erro caso usuário insira um tipo diferente de caractere ao cadastrar Pessoa nova.
Dados salvos em um ArrayList.
Menu em loop condicional com switch/case.


Próximos passos incluem:


- implementação de salvar, deletar e ler dados em texto local;
- Função de cadastro de especialidade;
- Função de cadastro de horário vago;
- Função de agendamento baseado em especialidade e horário vago por médico;
- Verificação de agendamento e horários disponíveis;

Diagrama: https://app.diagrams.net/#G1xWk86aoFnFHR_mWdToxIkctkAL8Utgym#%7B%22pageId%22%3A%22Esip6vwrr6jEOZYmGrqr%22%7D