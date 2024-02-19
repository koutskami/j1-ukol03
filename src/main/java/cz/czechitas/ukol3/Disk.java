package cz.czechitas.ukol3;

public class Disk {
    private Long kapacita;
    private Long vyuziteMisto;

    //getter a setter pro kapacitu:
    public Long getKapacita() {
        return kapacita;
    }

    public void setKapacita(Long kapacita) {
        this.kapacita = kapacita;
    }

    //getter a setter pro vyuzite misto:
    public Long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(Long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
