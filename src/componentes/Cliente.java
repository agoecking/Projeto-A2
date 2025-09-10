package componentes;

public class Cliente extends Pessoa {
	
	public Cliente(String nome, int telefone, int rg, int cpf, String genero, String email, Endereco _endereco) {
		super(nome, telefone, rg, cpf, genero, email);
		this.set_endereco(_endereco);
		// TODO Auto-generated constructor stub
	}

	private Endereco _endereco;

	
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

	public Endereco get_endereco() {
		return _endereco;
	}

	public void set_endereco(Endereco _endereco) {
		this._endereco = _endereco;
	}
	
}
