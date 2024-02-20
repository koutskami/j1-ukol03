package cz.czechitas.ukol3;

public class Pocitac {
    private Boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    @Override
    public String toString() {
        return super.toString();
    }

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
    public boolean jeZapnuty() {
        return jeZapnuty;
    }
    public boolean zapniSe() {
        if (jeZapnuty) {
            System.err.println("Počítač už je zapnutý.");
        }
        return true;
    }
    public boolean vypniSe() {
        return false;
    }
}

