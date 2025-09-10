package repository;

import java.util.ArrayList;
import java.util.List;

import componentes.Cliente;

public class ClienteRepository implements CrudRepository<Cliente>{
	
	private List<Cliente> clientes = new ArrayList<>();
	
	public void Salvar(Cliente cliente) {
		clientes.add(cliente);
		System.out.println("Cliente salvo");
	}
	
	public void Deletar(String nome) {
		
	}
	
	public void Listar() {
		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
		} else {
			System.out.println("--- Lista de Clientes ---");
			for (Cliente c : clientes) {
				c.Listar();
				
				System.out.println("-------------------------");
			}
		}
	}

}
