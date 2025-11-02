package repository;

import componentes.Agendamento;
import database.GerenciamentoDatabase;

import java.util.ArrayList;
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
                                          .map(a -> a.toString())
                                          .collect(Collectors.toList());
        GerenciamentoDatabase.salvarLista(ARQUIVO_AGENDAMENTOS, linhas);
        System.out.println("Agendamento salvo");
    }

    @Override
    public void Listar() {
        List<Agendamento> ags = carregarDoArquivo();
        if (ags.isEmpty()) {
            System.out.println("Nenhum agendamento cadastrado.");
        } else {
            System.out.println("--- Lista de Agendamentos ---");
            for (Agendamento ag : ags) {
                System.out.println("ID: " + ag.getId() + 
                                   " | Cliente: " + ag.getNomeCliente() + 
                                   " | Médico: " + ag.getNomeMedico() + 
                                   " | Data: " + ag.getData() + 
                                   " | Status: " + ag.getStatus());
            }
        }
    }

    @Override
    public void Deletar(String id) {
        agendamentos.removeIf(a -> String.valueOf(a.getId()).equals(id));
        List<String> linhas = agendamentos.stream()
                                          .map(a -> a.toString())
                                          .collect(Collectors.toList());
        GerenciamentoDatabase.salvarLista(ARQUIVO_AGENDAMENTOS, linhas);
    }

    private List<Agendamento> carregarDoArquivo() {
        List<String> linhas = GerenciamentoDatabase.carregar(ARQUIVO_AGENDAMENTOS);
        if (linhas == null) return new ArrayList<>();
        return linhas.stream().map(linha -> {
            try {
                return Agendamento.fromString(linha);
            } catch (Exception e) {
                System.err.println("Erro ao carregar agendamento do arquivo: " + e.getMessage());
                return null;
            }
        }).filter(ag -> ag != null).collect(Collectors.toList());
    }

    public Agendamento buscarPorId(int id) {
        return carregarDoArquivo().stream()
                .filter(ag -> ag.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
