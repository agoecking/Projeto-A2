package componentes;

public class Disponibilidade {
    private String diaSemana;
    private String hora; // pode ser só "14:00" ou até "14:00 - 15:00"

    public Disponibilidade(String diaSemana, String hora) {
        this.diaSemana = diaSemana;
        this.hora = hora;
    }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    @Override
    public String toString() {
        return diaSemana + " às " + hora;
    }
}