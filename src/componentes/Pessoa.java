package componentes;

public abstract class Pessoa {

    // --- ATRIBUTOS ---
    private String nome;
    private String telefone;
    private String rg;
    private String cpf;
    private String genero;
    private String email;

    // --- CONSTRUTOR ---
    public Pessoa(String nome, String telefone, String rg, String cpf, String genero, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.rg = rg;
        this.cpf = cpf;
        this.genero = genero;
        this.email = email;
    }

    // --- MÉTODO ABSTRATO ---
    public abstract void Listar();

    // --- GETTERS E SETTERS ---
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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
