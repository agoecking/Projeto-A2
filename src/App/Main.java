package App;

import Componentes.medico;
import Repository.medicoRepository;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		medicoRepository medicoRepo = new medicoRepository();	
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n--- SALVAR NOVO MÉDICO ---");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Telefone: ");
		int telefone = Integer.parseInt(scanner.nextLine());
		
		System.out.print("RG: ");
		int rg = Integer.parseInt(scanner.nextLine());
		
		System.out.print("CPF: ");
		int cpf = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Gênero: ");
		String genero = scanner.nextLine();
		
		System.out.print("Email: ");
		String email = scanner.nextLine();

		System.out.print("CRM: ");
		String crm = scanner.nextLine();
		
		medico novoMedico = new medico(nome, telefone, rg, cpf, genero, email, crm);
		medicoRepo.Salvar(novoMedico);
		
		System.out.println("\n--- LISTAR TODOS OS MÉDICOS ---");
		medicoRepo.Listar();
		
		scanner.close();
	}	

}
