package cz.czechitas.ukol3;

public class Pocitac {
    private Boolean jeZapnuty = false;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    //gettery a settery:
    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    //metody
    //metoda jeZapnuty printem vypíše true/false, mělo by být ok
    public boolean jeZapnuty() {
        return this.jeZapnuty;
    }

    //implementace metody zapniSe - otestováno, že by mělo fungovat a při druhém zapnutí vypíše chybovou hlášku
    public void zapniSe() {
        if (cpu == null) {
            System.err.println("Počítač nelze zapnout bez procesoru.");
            return;
        }
        if (ram == null) {
            System.err.println("Počítač nelze zapnout bez paměti.");
            return;
        }
        if (pevnyDisk == null) {
            System.err.println("Počítač nelze zapnout bez disku.");
            return;
        }
        if (!jeZapnuty) {
            jeZapnuty = true;
            System.out.println("Počítač se zapnul.");
        } else {
            System.err.println("Počítač nejde zapnout podruhé.");
        }
    }
    public void vypniSe() {
        if (jeZapnuty) {
            jeZapnuty = false;
            System.out.println("Počítač se vypnul.");
        } else {
            return;
        }
    }

    @Override
    public String toString() {
        return "Pocitac{" +
                "jeZapnuty=" + jeZapnuty +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", pevnyDisk=" + pevnyDisk +
                '}';
    }
    //TODO Metoda vytvorSouborOVelikosti(long velikost) zvýší proměnnou vyuziteMisto o velikost.
    //TODO Pokud by se už nově vytvářený soubor na disk nevešel (vyuziteMisto > kapacita), metoda vypíše chybu a vyuziteMisto se nebude měnit.
    //TODO Metoda bude fungovat pouze, pokud je počítač zapnutý.
    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty){
            System.err.println("Nelze vytvořit soubor. Počítač je vypnutý.");
            return;
        }
//        if (pevnyDisk.getKapacita() > velikost){
//            System.err.println("Na disku není pro tento soubor dost místa.");
//            return;
//        }
        pevnyDisk.setVyuziteMisto(velikost);
    }

    //TODO Metoda vymazSouboryOVelikosti(long velikost) sníží proměnnou vyuziteMisto o velikost.
    //TODO vyuziteMisto nemůže klesnout pod 0.
    //TODO Metoda bude fungovat pouze, pokud je počítač zapnutý.
    //TODO public void vymazSouboryOVelikosti(long velikost) {}

}

