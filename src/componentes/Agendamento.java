package componentes;

public class Agendamento {
    private int id;
    private String nomeCliente;
    private String nomeMedico;
    private String data;  
    private String status; 

    public Agendamento(int id, String nomeCliente, String nomeMedico, String data) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeMedico = nomeMedico;
        this.data = data;
        this.status = "MARCADO";
    }

    // Getters e Setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Converte o objeto em uma linha de texto para salvar no TXT.
     * Formato: id;cliente;medico;data;status
     */
    @Override
    public String toString() {
        return id + ";" + nomeCliente + ";" + nomeMedico + ";" + data + ";" + status;
    }

    /**
     * Cria um objeto Agendamento a partir de uma linha do TXT.
     */
    public static Agendamento fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length < 5) {
            throw new IllegalArgumentException("Linha inválida: " + linha);
        }

        Agendamento agendamento = new Agendamento(
                Integer.parseInt(partes[0]),
                partes[1],
                partes[2],
                partes[3]
        );
        agendamento.setStatus(partes[4]);
        return agendamento;
    }
}
