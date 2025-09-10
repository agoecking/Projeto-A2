package repository;

import java.util.ArrayList;
import java.util.List;

import componentes.Medico;

public class MedicoRepository implements CrudRepository<Medico>{
	
	private List<Medico> medicos = new ArrayList<>();
	
	public void Salvar(Medico _medico) {
		medicos.add(_medico);
		System.out.println("Médico salvo");
	}
	
	public void Deletar(String nome) {
		
	}
	
	public void Listar() {
		if (medicos.isEmpty()) {
			System.out.println("Nenhum médico cadastrado.");
		} else {
			System.out.println("--- Lista de Médicos ---");
			for (Medico m : medicos) {
				m.Listar();
				System.out.println("-------------------------");
			}
		}
	}
}
