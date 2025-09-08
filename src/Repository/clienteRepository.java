package Repository;

import java.util.ArrayList;
import java.util.List;

import Componentes.cliente;

public class clienteRepository {
	
	private List<cliente> clientes = new ArrayList<>();
	
	public void Salvar(cliente _cliente) {
		clientes.add(_cliente);
		System.out.println("Cliente salvo");
	}
	
	public void Deletar(String nome) {
		
	}
	
	public void Listar() {
		if (clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
		} else {
			System.out.println("--- Lista de Médicos ---");
			for (cliente m : clientes) {
				m.Listar();
				System.out.println("-------------------------");
			}
		}
	}

}
