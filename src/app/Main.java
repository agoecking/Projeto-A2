package app;

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
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // MENU
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Novo Médico");
            System.out.println("2 - Listar Todos os Médicos");
            System.out.println("3 - Cadastrar Novo Cliente");
            System.out.println("4 - Listar Todos os Clientes");
            System.out.println("5 - Sair");
            System.out.print("Digite uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opção inválida.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // CADASTRO DE MÉDICO
                    System.out.println("\n--- SALVAR NOVO MÉDICO ---");

                    try {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Telefone: ");
                        int telefone = Integer.parseInt(scanner.nextLine());

                        System.out.print("RG: ");
                        int rg = Integer.parseInt(scanner.nextLine());

                        System.out.print("CPF: ");
                        int cpf = Integer.parseInt(scanner.nextLine());

                        System.out.print("Gênero: ");
                        String genero = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("CRM: ");
                        String crm = scanner.nextLine();

                        // cria o médico
                        Medico novoMedico = new Medico(nome, telefone, rg, cpf, genero, email, crm);

                        // pergunta especialidades
                        System.out.print("Quantas especialidades este médico possui? ");
                        int qtdEsp = Integer.parseInt(scanner.nextLine());

                        for (int i = 0; i < qtdEsp; i++) {
                            System.out.print("Digite o nome da especialidade " + (i + 1) + ": ");
                            String nomeEsp = scanner.nextLine();
                            novoMedico.adicionarEspecialidade(new Especialidade(nomeEsp));
                        }

                        // pergunta disponibilidades
                        System.out.print("Quantas disponibilidades este médico possui? ");
                        int qtdDisp = Integer.parseInt(scanner.nextLine());

                        for (int i = 0; i < qtdDisp; i++) {
                            System.out.print("Dia da semana da disponibilidade " + (i + 1) + ": ");
                            String dia = scanner.nextLine();

                            System.out.print("Hora (exemplo 14:00): ");
                            String hora = scanner.nextLine();

                            novoMedico.adicionarDisponibilidade(new Disponibilidade(dia, hora));
                        }

                        medicoRepo.Salvar(novoMedico);
                        System.out.println("Médico cadastrado com sucesso!");

                    } catch (Exception e) {
                        System.out.println("Erro: Por favor, digite um número válido para Telefone, RG ou CPF.");
                    }
                    break;

                case 2:
                    // LISTAGEM DE MÉDICOS
                    System.out.println("\n--- LISTAR TODOS OS MÉDICOS ---");
                    medicoRepo.Listar();
                    break;

                case 3:
                    // CADASTRO DE CLIENTE
                    System.out.println("\n--- SALVAR NOVO CLIENTE ---");

                    try {
                        System.out.print("Nome: ");
                        String nomeCliente = scanner.nextLine();

                        System.out.print("Telefone: ");
                        int telefoneCliente = Integer.parseInt(scanner.nextLine());

                        System.out.print("RG: ");
                        int rgCliente = Integer.parseInt(scanner.nextLine());

                        System.out.print("CPF: ");
                        int cpfCliente = Integer.parseInt(scanner.nextLine());

                        System.out.print("Gênero: ");
                        String generoCliente = scanner.nextLine();

                        System.out.print("Email: ");
                        String emailCliente = scanner.nextLine();

                        // endereço
                        System.out.println("\n--- ENDEREÇO DO CLIENTE ---");
                        System.out.print("CEP: ");
                        int cep = Integer.parseInt(scanner.nextLine());

                        System.out.print("Rua: ");
                        String rua = scanner.nextLine();

                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();

                        System.out.print("Estado: ");
                        String estado = scanner.nextLine();

                        Endereco endereco = new Endereco(cep, rua, cidade, estado);
                        Cliente novoCliente = new Cliente(nomeCliente, telefoneCliente, rgCliente, cpfCliente, generoCliente, emailCliente, endereco);

                        clienteRepo.Salvar(novoCliente);
                        System.out.println("Cliente cadastrado com sucesso!");

                    } catch (Exception e) {
                        System.out.println("Erro: Por favor, digite um número válido.");
                    }
                    break;

                case 4:
                    // LISTAGEM DE CLIENTES
                    System.out.println("\n--- LISTAR TODOS OS CLIENTES ---");
                    clienteRepo.Listar();
                    break;

                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
