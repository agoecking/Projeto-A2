package app;

import componentes.Agendamento;
import componentes.StatusAgendamento;
import repository.AgendamentoRepository;
import repository.HorarioLivreRepository;
import java.util.List;

import componentes.Medico;
import repository.MedicoRepository;
import componentes.Endereco;
import repository.ClienteRepository;
import componentes.Cliente;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MedicoRepository medicoRepo = new MedicoRepository();
        ClienteRepository clienteRepo = new ClienteRepository();
        AgendamentoRepository agendamentoRepo = new AgendamentoRepository();
        HorarioLivreRepository horarioRepo = new HorarioLivreRepository();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Novo Médico");
            System.out.println("2 - Listar Todos os Médicos");
            System.out.println("3 - Cadastrar Novo Cliente");
            System.out.println("4 - Listar Todos os Clientes");
            System.out.println("5 - Cadastrar Horário Vago para Médico");
            System.out.println("6 - Listar Todos os Agendamentos");
            System.out.println("7 - Marcar uma Consulta");
            System.out.println("8 - Sair");
            System.out.print("Digite uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CADASTRAR MÉDICO ---");

                    System.out.print("Nome: ");
                    String nomeMed = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefoneMed = scanner.nextLine();

                    System.out.print("RG: ");
                    String rgMed = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpfMed = scanner.nextLine();

                    System.out.print("Gênero: ");
                    String generoMed = scanner.nextLine();

                    System.out.print("Email: ");
                    String emailMed = scanner.nextLine();

                    System.out.print("CRM: ");
                    String crm = scanner.nextLine();

                    Medico novoMedico = new Medico(nomeMed, telefoneMed, rgMed, cpfMed, generoMed, emailMed, crm);
                    medicoRepo.Salvar(novoMedico);

                    System.out.println("Médico cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- LISTAR TODOS OS MÉDICOS ---");
                    medicoRepo.Listar();
                    break;

                case 3:
                    System.out.println("\n--- CADASTRAR CLIENTE ---");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("RG: ");
                    String rg = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    System.out.print("CEP: ");
                    int cep = Integer.parseInt(scanner.nextLine());

                    Endereco endereco = new Endereco(cep, rua, cidade, estado);
                    Cliente novoCliente = new Cliente(nome, telefone, rg, cpf, genero, email, endereco);
                    clienteRepo.Salvar(novoCliente);

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.println("\n--- LISTAR TODOS OS CLIENTES ---");
                    clienteRepo.Listar();
                    break;

                // ✅ CADASTRAR HORÁRIO LIVRE
                case 5:
                    System.out.println("\n--- CADASTRAR HORÁRIO VAGO ---");
                    medicoRepo.Listar();
                    System.out.print("Digite o CRM do médico para adicionar um horário: ");
                    String crmBusca = scanner.nextLine();

                    Medico medicoEncontrado = medicoRepo.buscarPorCrm(crmBusca);

                    if (medicoEncontrado != null) {
                        System.out.print("Digite a data e hora (ex: DD/MM/AAAA HH:MM): ");
                        String data = scanner.nextLine();

                        // Cria um novo horário livre
                        int novoId = horarioRepo.listarTodos().size() + 1;
                        Agendamento novoHorario = new Agendamento(novoId, "", medicoEncontrado.getNome(), data, StatusAgendamento.LIVRE);
                        horarioRepo.Salvar(novoHorario);

                        System.out.println("Horário livre cadastrado com sucesso!");
                    } else {
                        System.out.println("Médico com o CRM " + crmBusca + " não encontrado.");
                    }
                    break;

                // ✅ LISTAR AGENDAMENTOS CONFIRMADOS
                case 6:
                    System.out.println("\n--- LISTA DE AGENDAMENTOS ---");
                    agendamentoRepo.Listar();
                    break;

                // ✅ MARCAR CONSULTA
                case 7:
                    System.out.println("\n--- MARCAR UMA CONSULTA ---");

                    List<Agendamento> horariosLivres = horarioRepo.listarTodos();
                    if (horariosLivres.isEmpty()) {
                        System.out.println("Desculpe, não há horários livres no momento.");
                        break;
                    }

                    System.out.println("Horários disponíveis:");
                    for (Agendamento h : horariosLivres) {
                        System.out.println("ID: " + h.getId() +
                                           " | Médico: " + h.getNomeMedico() +
                                           " | Data: " + h.getData());
                    }

                    System.out.print("\nDigite o ID do horário que deseja marcar: ");
                    int idEscolhido = scanner.nextInt();
                    scanner.nextLine();

                    Agendamento horarioEscolhido = horarioRepo.buscarPorId(idEscolhido);

                    if (horarioEscolhido == null) {
                        System.out.println("ID inválido. Tente novamente.");
                        break;
                    }

                    clienteRepo.Listar();
                    System.out.print("Digite o nome do Cliente para o agendamento: ");
                    String nomeCliente = scanner.nextLine();

                    // Atualiza e move o horário
                    horarioEscolhido.setNomeCliente(nomeCliente);
                    horarioEscolhido.setStatus(StatusAgendamento.AGENDADO);

                    // Remove dos horários livres e adiciona em agendamentos
                    horarioRepo.Deletar(String.valueOf(idEscolhido));
                    agendamentoRepo.Salvar(horarioEscolhido);

                    System.out.println("✅ Consulta marcada com sucesso para " + nomeCliente + "!");
                    break;

                case 8:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 8);

        System.out.println("Salvando dados antes de sair...");
        System.out.println("Dados salvos. Até mais!");

        scanner.close();
    }
}
