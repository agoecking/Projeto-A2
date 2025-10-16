package repository;

import componentes.Agendamento;
import componentes.StatusAgendamento;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Lembre-se de implementar a interface, como você já faz nos outros repositórios
public class AgendamentoRepository implements CrudRepository<Agendamento> {

    private List<Agendamento> agendamentos = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void Salvar(Agendamento agendamento) {
        agendamento.setId(proximoId++);
        agendamentos.add(agendamento);
    }
    
    @Override
    public void Listar() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento cadastrado.");
        } else {
            for (Agendamento ag : agendamentos) {
                System.out.println("ID: " + ag.getId() + 
                                   " | Médico: " + ag.getNomeMedico() + 
                                   " | Cliente: " + (ag.getNomeCliente().isEmpty() ? "----" : ag.getNomeCliente()) + 
                                   " | Data: " + ag.getData() + 
                                   " | Status: " + ag.getStatus());
            }
        }
    }
    
    public List<Agendamento> listarHorariosLivres() {
        return agendamentos.stream()
                .filter(ag -> ag.getStatus() == StatusAgendamento.LIVRE)
                .collect(Collectors.toList());
    }

    // ==================================================================
    // MÉTODO QUE ESTÁ FALTANDO - ADICIONE ESTE BLOCO
    /**
     * Busca um agendamento na lista pelo seu ID.
     * @param id O ID do agendamento a ser encontrado.
     * @return O objeto Agendamento se encontrado, ou null se não existir.
     */
    public Agendamento buscarPorId(int id) {
        for (Agendamento ag : agendamentos) {
            if (ag.getId() == id) {
                return ag; // Retorna o agendamento quando encontra o ID correspondente
            }
        }
        return null; // Retorna nulo se o loop terminar e não encontrar
    }
    // ==================================================================

    @Override
    public void Deletar(String nome) {
        // Futuramente, você pode implementar a lógica para deletar um agendamento
    }
}