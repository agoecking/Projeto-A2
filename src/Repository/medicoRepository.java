package Repository;

import java.util.ArrayList;
import java.util.List;

import Componentes.medico;

public class medicoRepository {
	
	private List<medico> medicos = new ArrayList<>();
	
	public void Salvar(medico _medico) {
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
			for (medico m : medicos) {
				m.Listar();
				System.out.println("-------------------------");
			}
		}
	}
}
