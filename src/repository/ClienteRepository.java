package repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import componentes.Cliente;
import database.GerenciamentoDatabase;
import logs.LogService;

public class ClienteRepository implements CrudRepository<Cliente> {

    private List<Cliente> clientes;
    private static final String ARQUIVO_CLIENTES = "clientes.txt";

    public ClienteRepository() {
        clientes = carregarDoArquivo();
    }

    //Método que chama a classe responsável por gerenciar os arquivos txt
    @Override
    public void Salvar(Cliente cliente) {
        clientes.add(cliente);
        List<String> linhas = clientes.stream()
                                      .map(Cliente::toString)
                                      .collect(Collectors.toList());
        GerenciamentoDatabase.salvarLista(ARQUIVO_CLIENTES, linhas);
        System.out.println("Cliente salvo");
    }

    @Override
    public void Deletar(String nome) {
        clientes.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
    }

    @Override
    public void Listar() {
        List<Cliente> clis = carregarDoArquivo();
        if (clis.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("--- Lista de Clientes ---");
            for (Cliente c : clis) {
                c.Listar();
                System.out.println("-------------------------");
            }
        }
    }

    //responsável por carregar os dados do txt, com base no gerenciamento de database
    private List<Cliente> carregarDoArquivo() {
        List<String> linhas = GerenciamentoDatabase.carregar(ARQUIVO_CLIENTES);
        if (linhas == null) return new ArrayList<>();
        return linhas.stream().map(linha -> {
            try {
                return Cliente.fromString(linha);
            } catch (Exception e) {
                System.err.println("Erro ao carregar cliente do arquivo: " + e.getMessage());
                LogService.registrar("mensagem");
                return null;
            }
        }).filter(c -> c != null).collect(Collectors.toList());
    }
}
