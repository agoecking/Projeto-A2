package Componentes;

public class medico extends pessoa {
	
	private String crm;


	public medico(String nome, int telefone, int rg, int cpf, String genero, String email, String crm) {
		super(nome, telefone, rg, cpf, genero, email);
		this.crm = crm;
	}

	
	public String getCrm() {
		return crm;
	}
	
	@Override
	public void Listar() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Telefone: " + this.getTelefone());
		System.out.println("CRM: " + this.crm);
		
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}



	
}
