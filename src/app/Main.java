package app;

import componentes.Agendamento;
import componentes.StatusAgendamento;
import repository.AgendamentoRepository;
import java.util.List;

import componentes.Medico;
import componentes.Especialidade;
import componentes.Disponibilidade;
import repository.MedicoRepository;
import componentes.Endereco;
import repository.ClienteRepository;
import componentes.Cliente;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MedicoRepository medicoRepo = new MedicoRepository();
        ClienteRepository clienteRepo = new ClienteRepository();
        AgendamentoRepository agendamentoRepo = new AgendamentoRepository(); // NOVO REPOSITÓRIO
        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // 3. MENU COM AS OPÇÕES
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Novo Médico");
            System.out.println("2 - Listar Todos os Médicos");
            System.out.println("3 - Cadastrar Novo Cliente");
            System.out.println("4 - Listar Todos os Clientes");
            System.out.println("5 - Cadastrar Horário Vago para Médico");
            System.out.println("6 - Listar Todos os Agendamentos");
            System.out.println("7 - Marcar uma Consulta");
            System.out.println("8 - Sair"); // OPÇÃO SAIR ATUALIZADA
            System.out.print("Digite uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                
                    break;

                case 2:
                    System.out.println("\n--- LISTAR TODOS OS MÉDICOS ---");
                    medicoRepo.Listar();
                    break;

                case 3:
                  
                    break;

                case 4:
                    System.out.println("\n--- LISTAR TODOS OS CLIENTES ---");
                    clienteRepo.Listar();
                    break;
                
               
                case 5:
                    System.out.println("\n--- CADASTRAR HORÁRIO VAGO ---");
                    // Primeiro, lista os médicos para o usuário saber o CRM
                    medicoRepo.Listar();
                    System.out.print("Digite o CRM do médico para adicionar um horário: ");
                    String crmBusca = scanner.nextLine();
                    
                    // Supõe que o repositório de médico tenha o método buscarPorCrm
                    // Se não tiver, você precisa adicioná-lo!
                    Medico medicoEncontrado = medicoRepo.buscarPorCrm(crmBusca);

                    if (medicoEncontrado != null) {
                        System.out.print("Digite a data e hora (ex: DD/MM/AAAA HH:MM): ");
                        String data = scanner.nextLine();

                        // Cria um novo agendamento com status LIVRE
                        // O ID será 0 por enquanto, o repositório vai atribuir o ID correto
                        Agendamento novoHorario = new Agendamento(0, "", medicoEncontrado.getNome(), data, StatusAgendamento.LIVRE);
                        agendamentoRepo.Salvar(novoHorario);

                        System.out.println("Horário vago cadastrado com sucesso!");
                    } else {
                        System.out.println("Médico com o CRM " + crmBusca + " não encontrado.");
                    }
                    break;

                // 5. NOVO CASE PARA LISTAR OS AGENDAMENTOS
                case 6:
                    System.out.println("\n--- LISTA DE AGENDAMENTOS ---");
                    agendamentoRepo.Listar();
                    break;

                // 6. NOVO CASE PARA MARCAR UMA CONSULTA
                case 7:
                    System.out.println("\n--- MARCAR UMA CONSULTA ---");
                    
                    List<Agendamento> horariosLivres = agendamentoRepo.listarHorariosLivres();
                    if (horariosLivres.isEmpty()) {
                        System.out.println("Desculpe, não há horários livres no momento.");
                        break;
                    }
                    
                    System.out.println("Horários disponíveis:");
                    for (Agendamento ag : horariosLivres) {
                         System.out.println("ID: " + ag.getId() + 
                                           " | Médico: " + ag.getNomeMedico() + 
                                           " | Data: " + ag.getData());
                    }

                    System.out.print("\nDigite o ID do horário que deseja marcar: ");
                    int idEscolhido = scanner.nextInt();
                    scanner.nextLine();

                    Agendamento agendamentoEscolhido = agendamentoRepo.buscarPorId(idEscolhido);

                    if (agendamentoEscolhido != null && agendamentoEscolhido.getStatus() == StatusAgendamento.LIVRE) {
                        // Lista os clientes para facilitar
                        clienteRepo.Listar();
                        System.out.print("Digite o nome do Cliente para o agendamento: ");
                        String nomeCliente = scanner.nextLine();
                        
                        agendamentoEscolhido.setNomeCliente(nomeCliente);
                        agendamentoEscolhido.setStatus(StatusAgendamento.AGENDADO);

                        System.out.println("Consulta marcada com sucesso para " + nomeCliente + "!");
                    } else {
                        System.out.println("ID inválido ou horário já ocupado. Tente novamente.");
                    }
                    break;

                case 8: // OPÇÃO SAIR ATUALIZADA
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 8); // CONDIÇÃO DO LOOP ATUALIZADA
        System.out.println("Salvando dados antes de sair...");
        // medicoRepo.SalvarParaArquivo();
        // clienteRepo.SalvarParaArquivo();
        // agendamentoRepo.SalvarParaArquivo();
        System.out.println("Dados salvos. Até mais!");

        scanner.close();
    }
}