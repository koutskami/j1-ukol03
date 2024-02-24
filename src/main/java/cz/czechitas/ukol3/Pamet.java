package cz.czechitas.ukol3;

public class Pamet {
    private Long kapacita;

    //getter a setter pro kapacitu:
    public Long getKapacita() {
        return kapacita;
    }

    public void setKapacita(Long kapacita) {
        this.kapacita = kapacita;
    }

    @Override
    public String toString() {
        return "Pamet{" +
                "kapacita=" + kapacita +
                '}';
    }
}
