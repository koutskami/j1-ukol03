package cz.czechitas.ukol3;

public class Pocitac {
    private Boolean jeZapnuty = false;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private Disk druhyDisk;

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

    public Disk getDruhyDisk() {
        return druhyDisk;
    }

    public void setDruhyDisk(Disk druhyDisk) {
        this.druhyDisk = druhyDisk;
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
        }
    }

    //Metoda vytvorSouborOVelikosti(long velikost) zvýší proměnnou vyuziteMisto o velikost.
    //Pokud by se už nově vytvářený soubor na disk nevešel (vyuziteMisto > kapacita), metoda vypíše chybu a vyuziteMisto se nebude měnit.
    //Metoda bude fungovat pouze, pokud je počítač zapnutý.
    public void vytvorSouborOVelikosti(long velikost) {
        //pokud je vyuzite misto null, tak chci pracovat s nulou, at mi nepada build
        if (pevnyDisk.getVyuziteMisto()==null) {
            pevnyDisk.setVyuziteMisto(0L);
        }
        if (druhyDisk.getVyuziteMisto()==null) {
            druhyDisk.setVyuziteMisto(0L);
        }

        //krok1: kontroluje zda je pc zapnutý, pokud je vypnutý tak vypíše chybu a nepokračuje
        if (!jeZapnuty){
            System.err.println("Nelze vytvořit soubor. Počítač je vypnutý.");
            return;
        }

        //krok2: kontroluje zda je soubor větší než kapacita prvního a druhého disku, pokud ano tak vypíše hlášku a končí
        if (velikost > pevnyDisk.getKapacita()){
//            System.err.println("Na disku není pro tento soubor dost místa.");
//            return;
            if (velikost > druhyDisk.getKapacita()) {
                System.err.println("Na disku není pro tento soubor dost místa.");
            }
        }

        //krok3: je potřeba zkontrolovat, že součet velikosti a využitého místa nepřesahuje kapacitu
        if (pevnyDisk.getVyuziteMisto() + velikost < pevnyDisk.getKapacita()){
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() + velikost);
        }else if (druhyDisk.getVyuziteMisto() + velikost > druhyDisk.getKapacita()) {
            System.err.println("Soubor je moc velký. Před vložením udělejte místo na disku.");
        }else druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() + velikost);
    }

    //Metoda vymazSouboryOVelikosti(long velikost) sníží proměnnou vyuziteMisto o velikost.
    //vyuziteMisto nemůže klesnout pod 0.
    //Metoda bude fungovat pouze, pokud je počítač zapnutý.
    //Metoda upravena o druhý disk, z něhož se maže nejdříve.
    public void vymazSouboryOVelikosti(long velikost) {
        if (!jeZapnuty){
            System.err.println("Nelze smazat soubor. Počítač je vypnutý.");
            return;
        }
        if (druhyDisk.getVyuziteMisto() == null) {
            if (pevnyDisk.getVyuziteMisto()==null) {
                System.err.println("Soubor nelze smazat, disk je prázdný.");
            }
            return;
        }
        if (druhyDisk.getVyuziteMisto() >= velikost) {
            druhyDisk.setVyuziteMisto(druhyDisk.getVyuziteMisto() - velikost);
        }else if (pevnyDisk.getVyuziteMisto() >= velikost) {
            pevnyDisk.setVyuziteMisto(pevnyDisk.getVyuziteMisto() - velikost);
        }else System.err.println("Soubor nelze smazat. Požadovaná velikost přesahuje využité místo na disku.");
    }

    @Override
    public String toString() {
        return "Pocitac{" +
                "jeZapnuty=" + jeZapnuty +
                ", cpu=" + cpu +
                ", ram=" + ram +
                ", pevnyDisk=" + pevnyDisk +
                ", druhyDisk=" + druhyDisk +
                '}';
    }
}

