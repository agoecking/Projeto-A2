package repository;

import componentes.Agendamento;
import componentes.StatusAgendamento;
import database.GerenciamentoDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class AgendamentoRepository implements CrudRepository<Agendamento> {

    private List<Agendamento> agendamentos;
    private static final String ARQUIVO_AGENDAMENTOS = "agendamentos.txt";

    public AgendamentoRepository() {
        agendamentos = carregarDoArquivo();
    }

    @Override
    public void Salvar(Agendamento agendamento) {
        agendamentos.add(agendamento);
        List<String> linhas = agendamentos.stream()
                                          .map(Agendamento::toString)
                                          .collect(Collectors.toList());
        GerenciamentoDatabase.salvarLista(ARQUIVO_AGENDAMENTOS, linhas);
    }

    @Override
    public void Listar() {
        List<Agendamento> ags = carregarDoArquivo(); // carrega do arquivo sempre
        if (ags.isEmpty()) {
            System.out.println("Nenhum agendamento cadastrado.");
        } else {
            for (Agendamento ag : ags) {
                System.out.println(ag);
            }
        }
    }

    @Override
    public void Deletar(String nome) {
        agendamentos.removeIf(ag -> ag.getNomeCliente().equalsIgnoreCase(nome));
    }

    private List<Agendamento> carregarDoArquivo() {
        List<String> linhas = GerenciamentoDatabase.carregar(ARQUIVO_AGENDAMENTOS);
        return linhas.stream().map(linha -> {
            try {
                return Agendamento.fromString(linha);
            } catch (Exception e) {
                System.err.println("Erro ao carregar agendamento do arquivo: " + e.getMessage());
                return null;
            }
        }).filter(ag -> ag != null).collect(Collectors.toList());
    }
    
    public List<Agendamento> listarHorariosLivres() {
        return carregarDoArquivo().stream()
                .filter(ag -> ag.getStatus() == StatusAgendamento.LIVRE)
                .collect(Collectors.toList());
    }

    public Agendamento buscarPorId(int id) {
        return carregarDoArquivo().stream()
                .filter(ag -> ag.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
