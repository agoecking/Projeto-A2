package componentes;

public class Cliente extends Pessoa {

    private Endereco _endereco;

    public Cliente(String nome, int telefone, int rg, int cpf, String genero, String email, Endereco _endereco) {
        super(nome, telefone, rg, cpf, genero, email);
        this._endereco = _endereco;
    }

    @Override
    public void Listar() {
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        if (_endereco != null) {
            System.out.println("Endereço:");
            System.out.println("  Rua: " + _endereco.getRua());
            System.out.println("  Cidade: " + _endereco.getCidade());
            System.out.println("  Estado: " + _endereco.getEstado());
            System.out.println("  CEP: " + _endereco.getCep());
        }
    }

    public Endereco get_endereco() { return _endereco; }
    public void set_endereco(Endereco _endereco) { this._endereco = _endereco; }

    @Override
    public String toString() {
        String enderecoStr = (_endereco != null)
            ? (_endereco.getCep() + ";" + _endereco.getRua() + ";" + _endereco.getCidade() + ";" + _endereco.getEstado())
            : "0;;;"; 

        return getNome() + ";" + getTelefone() + ";" + getRg() + ";" + getCpf() + ";" +
               getGenero() + ";" + getEmail() + ";" + enderecoStr;
    }

    public static Cliente fromString(String linha) {
        String[] parts = linha.split(";");
        if (parts.length < 10) {
            throw new IllegalArgumentException("Linha de cliente inválida: " + linha);
        }

        Endereco endereco = null;
        int cep = Integer.parseInt(parts[6]);
        String rua = parts[7];
        String cidade = parts[8];
        String estado = parts[9];

        if (cep != 0 || !rua.isEmpty() || !cidade.isEmpty() || !estado.isEmpty()) {
            endereco = new Endereco(cep, rua, cidade, estado);
        }

        return new Cliente(
            parts[0],
            Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]),
            Integer.parseInt(parts[3]),
            parts[4],
            parts[5],
            endereco
        );
    }
}
