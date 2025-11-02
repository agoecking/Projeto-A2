package componentes;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {

    private String crm;
    private List<Especialidade> especialidades = new ArrayList<>();
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    public Medico(String nome, String telefone, String rg, String cpf, String genero, String email, String crm) {
        super(nome, telefone, rg, cpf, genero, email);
        this.crm = crm;
    }

    public String getCrm() { 
        return crm; 
    }

    public void setCrm(String crm) { 
        this.crm = crm; 
    }

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
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("RG: " + getRg());
        System.out.println("CPF: " + getCpf());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Email: " + getEmail());
        System.out.println("CRM: " + crm);
    }

    // --- toString() e fromString() ---
    @Override
    public String toString() {
        // Padrão idêntico ao Cliente: campos separados por ";"
        return getNome() + ";" + getTelefone() + ";" + getRg() + ";" + getCpf() + ";" +
               getGenero() + ";" + getEmail() + ";" + crm;
    }

    public static Medico fromString(String linha) {
        String[] parts = linha.split(";");
        if (parts.length < 7) {
            throw new IllegalArgumentException("Linha de médico inválida: " + linha);
        }

        // parts: 0=nome, 1=telefone, 2=rg, 3=cpf, 4=genero, 5=email, 6=crm
        return new Medico(
            parts[0], // nome
            parts[1], // telefone
            parts[2], // rg
            parts[3], // cpf
            parts[4], // genero
            parts[5], // email
            parts[6]  // crm
        );
    }
}
