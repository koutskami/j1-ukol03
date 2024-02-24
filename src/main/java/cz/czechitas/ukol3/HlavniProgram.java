package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        //CAST 1
        System.out.println("Program spuštěn.");
        Pocitac misinPocitac = new Pocitac();
        System.out.println(misinPocitac.toString());
        misinPocitac.zapniSe();                         //Vypíše chybu, protože ještě nemám počítač zkompletovaný.

        //pocitac
        //V metodě main(String... args) v HlavniProgram vytvořte model svého počítače
        //vyzkoušejte, že vám fungují správně metody toString() u všech tříd
        //počítač jde zapnout jen pokud je správně sestavený

        Procesor misinProcesor = new Procesor();
        misinProcesor.setRychlost(3_110_000_000L);
        misinProcesor.setVyrobce("Intel Core");

        Pamet misinaPamet = new Pamet();
        misinaPamet.setKapacita(14_800_000_000L);

        Disk misinDisk = new Disk();
        misinDisk.setKapacita(510_507_945_984L);

        misinPocitac.setCpu(misinProcesor);
        misinPocitac.setRam(misinaPamet);
        misinPocitac.setPevnyDisk(misinDisk);

        System.out.println(misinPocitac.toString());

        misinPocitac.zapniSe();
        misinPocitac.zapniSe();      // Vypíše chybu, protože počítač už běží
        System.out.println(misinPocitac.toString());
        misinPocitac.vypniSe();

        misinPocitac.vypniSe();      // Nevypíše chybu, ale nic neprovede, protože počítač už je vypnutý
    }

}
