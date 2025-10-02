package componentes;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {

    private String crm;
    private List<Especialidade> especialidades = new ArrayList<>();
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    public Medico(String nome, int telefone, int rg, int cpf, String genero, String email, String crm) {
        super(nome, telefone, rg, cpf, genero, email);
        this.crm = crm;
    }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    // --- Especialidades ---
    public void adicionarEspecialidade(Especialidade esp) {
        especialidades.add(esp);
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    // --- Disponibilidades ---
    public void adicionarDisponibilidade(Disponibilidade disp) {
        disponibilidades.add(disp);
    }

    public List<Disponibilidade> getDisponibilidades() {
        return disponibilidades;
    }

    // --- Listagem ---
    @Override
    public void Listar() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("CRM: " + this.crm);

        // Especialidades
        if (especialidades.isEmpty()) {
            System.out.println("Especialidades: nenhuma cadastrada");
        } else {
            System.out.print("Especialidades: ");
            for (Especialidade e : especialidades) {
                System.out.print(e.getNome() + " ");
            }
            System.out.println();
        }

        // Disponibilidades
        if (disponibilidades.isEmpty()) {
            System.out.println("Disponibilidades: nenhuma cadastrada");
        } else {
            System.out.println("Disponibilidades:");
            for (Disponibilidade d : disponibilidades) {
                System.out.println("  - " + d);
            }
        }
    }
}