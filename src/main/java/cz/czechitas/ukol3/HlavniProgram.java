package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
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
        Disk misinDisk2 = new Disk();
        misinDisk2.setKapacita(550_507_945_984L);

        misinPocitac.setCpu(misinProcesor);
        misinPocitac.setRam(misinaPamet);
        misinPocitac.setPevnyDisk(misinDisk);
        misinPocitac.setDruhyDisk(misinDisk2);

        System.out.println(misinPocitac.toString());

        misinPocitac.zapniSe();
        misinPocitac.zapniSe();      // Vypíše chybu, protože počítač už běží
        System.out.println(misinPocitac.toString());
        misinPocitac.vypniSe();

        misinPocitac.vypniSe();      // Nevypíše chybu, ale nic neprovede, protože počítač už je vypnutý

        //CAST 2

        //testování metody pro vložení souboru
        //nelze vložit, když je vypnuto
        misinPocitac.vytvorSouborOVelikosti(11_507_945_984L);
        System.out.println(misinPocitac.toString());
        //nelze vložit soubor přesahující kapacitu prvniho i druheho disku
        misinPocitac.zapniSe();
        misinPocitac.vytvorSouborOVelikosti(630_507_945_984L);
        System.out.println(misinPocitac.toString());
        //přesahuje první disk, ale do druhého se vleze
        misinPocitac.vytvorSouborOVelikosti(530_507_945_984L);
        System.out.println(misinPocitac.toString());
        //malý soubor vložím do prvního disku
        misinPocitac.vytvorSouborOVelikosti(11_507_945_984L);
        System.out.println(misinPocitac.toString());
        //soubory se sčítají
        misinPocitac.vytvorSouborOVelikosti(11_507_945_984L);
        System.out.println(misinPocitac.toString());
        //do využitého prostoru nelze vložit soubor, kvůli kterému by byla přesáhnuta kapacita
        misinPocitac.vytvorSouborOVelikosti(500_507_945_984L);
        System.out.println(misinPocitac.toString());
        //chci zaplnit prvni disk
        misinPocitac.vytvorSouborOVelikosti(480_507_945_984L);
        System.out.println(misinPocitac.toString());
        //kontrola, že se to přidá do druhého
        misinPocitac.vytvorSouborOVelikosti(11_507_945_984L);
        System.out.println(misinPocitac.toString());
        //máme plno
        misinPocitac.vytvorSouborOVelikosti(11_507_945_984L);
        System.out.println(misinPocitac.toString());


//        //testování metody pro mazání souborů
//        //nelze mazat, když je vypnuto
//        misinPocitac.vypniSe();
//        misinPocitac.vymazSouboryOVelikosti(11_507_945_984L);
//        System.out.println(misinPocitac.toString());
//        //nelze vložit větší soubor než je využité místo
//        misinPocitac.zapniSe();
//        misinPocitac.vymazSouboryOVelikosti(50_507_945_984L);
//        System.out.println(misinPocitac.toString());
//        //mazání
//        misinPocitac.vymazSouboryOVelikosti(11_507_945_984L);
//        System.out.println(misinPocitac.toString());
//        misinPocitac.vymazSouboryOVelikosti(11_507_945_984L);
//        System.out.println(misinPocitac.toString());
//        //opakování mazání většího souboru než je využité místo
//        misinPocitac.vymazSouboryOVelikosti(30_507_945_984L);
//        System.out.println(misinPocitac.toString());

        //CAST 3

    }

}
