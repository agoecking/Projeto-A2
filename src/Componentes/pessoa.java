package Componentes;

public abstract class pessoa {

    // --- ATRIBUTOS ---
    private String nome;
    private int telefone;
    private int rg;
    private int cpf;
    private String genero;
    private String email;

    // --- CONSTRUTOR ---
    public pessoa(String nome, int telefone, int rg, int cpf, String genero, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
        this.genero = genero;
        this.email = email;
    }
    
    // --- 

    public abstract void Listar();
    	

	// --- GETTERS E SETTERS ---

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}