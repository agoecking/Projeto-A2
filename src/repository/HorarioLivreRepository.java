package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import componentes.Agendamento;
import database.GerenciamentoDatabase;
import logs.LogService;

public class HorarioLivreRepository implements CrudRepository<Agendamento> {

    private static final String ARQUIVO_HORARIOS = "horarioslivres.txt";
    private List<Agendamento> horariosLivres;

    public HorarioLivreRepository() {
        horariosLivres = carregarDoArquivo();
    }

    //chama método responsável por carregar os dados do txt
    public List<Agendamento> listarTodos() {
        return carregarDoArquivo();
    }

    public Agendamento buscarPorId(int id) {
        return listarTodos().stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //Salva dados em uma List que chamará o método responsável pelo salvamento em txt
    @Override
    public void Salvar(Agendamento horario) {
        horariosLivres.add(horario);
        persistir();
        System.out.println("Horário livre salvo");
    }

    @Override
    public void Deletar(String id) {
        horariosLivres.removeIf(h -> String.valueOf(h.getId()).equals(id));
        persistir();
    }

    @Override
    public void Listar() {
        List<Agendamento> items = listarTodos();
        if (items.isEmpty()) {
            System.out.println("Nenhum horário livre cadastrado.");
        } else {
            System.out.println("--- Horários Livres ---");
            for (Agendamento h : items) {
                System.out.println("ID: " + h.getId() +
                                   " | Médico: " + h.getNomeMedico() +
                                   " | Data: " + h.getData());
            }
        }
    }

    //Método que chama a classe responsável por gerenciar os arquivos txt
    private void persistir() {
        List<String> linhas = horariosLivres.stream()
                .map(h -> h.toString())
                .collect(Collectors.toList());
        GerenciamentoDatabase.salvarLista(ARQUIVO_HORARIOS, linhas);
    }

    //responsável por carregar os dados do txt, com base no gerenciamento de database
    private List<Agendamento> carregarDoArquivo() {
        List<String> linhas = GerenciamentoDatabase.carregar(ARQUIVO_HORARIOS);
        if (linhas == null) return new ArrayList<>();
        List<Agendamento> out = new ArrayList<>();
        for (String linha : linhas) {
            try {
                out.add(Agendamento.fromString(linha));
            } catch (Exception e) {
                System.err.println("Erro ao carregar horário: " + e.getMessage());
                LogService.registrar("mensagem");
            }
        }
        return out;
    }
}
