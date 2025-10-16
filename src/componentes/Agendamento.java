package componentes;

public class Agendamento {
    private int id;
    private String nomeCliente;
    private String nomeMedico;
    private String data;  
    private StatusAgendamento status; // Usando o enum

    // Construtor principal
    public Agendamento(int id, String nomeCliente, String nomeMedico, String data, StatusAgendamento status) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeMedico = nomeMedico;
        this.data = data;
        this.status = status;
    }

    // --- GETTERS (para ler os dados) ---
    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getData() {
        return data;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    // --- SETTERS (para modificar os dados) ---
    
    // MÉTODO QUE FALTAVA
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    // MÉTODO ATUALIZADO PARA ACEITAR O ENUM
    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
    
    // Setter para o ID, útil para o repositório
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        // Usa .name() para converter o enum para String antes de salvar
        return id + ";" + nomeCliente + ";" + nomeMedico + ";" + data + ";" + status.name();
    }

    public static Agendamento fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length < 5) {
            throw new IllegalArgumentException("Linha inválida: " + linha);
        }
        // Converte a String do arquivo de volta para o enum
        StatusAgendamento status = StatusAgendamento.valueOf(partes[4].toUpperCase());
        
        return new Agendamento(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                partes[3],
                status
        );
    }
}