package cz.czechitas.ukol3;

public class Procesor {
    private String vyrobce;
    private Long rychlost;

    //getter a setter pro vyrobce:
    public String getVyrobce() {
        return vyrobce;
    }

    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }

    //getter a setter pro rychlost:
    public Long getRychlost() {
        return rychlost;
    }

    public void setRychlost(Long rychlost) {
        this.rychlost = rychlost;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
