package repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import componentes.Medico;
import database.GerenciamentoDatabase;

public class MedicoRepository implements CrudRepository<Medico> {

    private List<Medico> medicos;
    private static final String ARQUIVO_MEDICOS = "medicos.txt";

    public MedicoRepository() {
        medicos = carregarDoArquivo();
    }

    @Override
    public void Salvar(Medico medico) {
        medicos.add(medico);

        // Grava a lista atualizada no arquivo
        List<String> linhas = medicos.stream()
                                     .map(m -> m.toString())
                                     .collect(Collectors.toList());
        GerenciamentoDatabase.salvarLista(ARQUIVO_MEDICOS, linhas);

        System.out.println("Médico salvo");
    }

    @Override
    public void Deletar(String nome) {
        medicos.removeIf(m -> m.getNome().equalsIgnoreCase(nome));

        // Atualiza o arquivo após a exclusão
        List<String> linhas = medicos.stream()
                                     .map(m -> m.toString())
                                     .collect(Collectors.toList());
        GerenciamentoDatabase.salvarLista(ARQUIVO_MEDICOS, linhas);
    }

    @Override
    public void Listar() {
        List<Medico> meds = carregarDoArquivo();
        if (meds.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            System.out.println("--- Lista de Médicos ---");
            for (Medico m : meds) {
                m.Listar();
                System.out.println("-------------------------");
            }
        }
    }

    public Medico buscarPorCrm(String crmBusca) {
        List<Medico> meds = carregarDoArquivo();
        for (Medico m : meds) {
            if (m.getCrm().equalsIgnoreCase(crmBusca)) {
                return m;
            }
        }
        return null;
    }

    private List<Medico> carregarDoArquivo() {
        List<String> linhas = GerenciamentoDatabase.carregar(ARQUIVO_MEDICOS);
        if (linhas == null) return new ArrayList<>();
        return linhas.stream()
                     .map(linha -> {
                         try {
                             return Medico.fromString(linha);
                         } catch (Exception e) {
                             System.err.println("Erro ao carregar médico do arquivo: " + e.getMessage());
                             return null;
                         }
                     })
                     .filter(m -> m != null)
                     .collect(Collectors.toList());
    }
}
