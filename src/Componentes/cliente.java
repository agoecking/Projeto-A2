package Componentes;

public class cliente extends pessoa {
	
	public cliente(String nome, int telefone, int rg, int cpf, String genero, String email, endereco _endereco) {
		super(nome, telefone, rg, cpf, genero, email);
		this.set_endereco(_endereco);
		// TODO Auto-generated constructor stub
	}

	private endereco _endereco;

	
	@Override
	public void Listar() {
		// TODO Auto-generated method stub
		
	}

	public endereco get_endereco() {
		return _endereco;
	}

	public void set_endereco(endereco _endereco) {
		this._endereco = _endereco;
	}


	
	
}
