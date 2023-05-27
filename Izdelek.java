import java.io.*;
import java.util.*;

public class Izdelek {
    String imeIzdelka;
    float cena;
    boolean vAkciji;
    float akcijaProcentov;
    int zaloga;

    public Izdelek(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {

        this.imeIzdelka = imeIzdelka;
        this.cena = cena;
        this.vAkciji = vAkciji;
        this.akcijaProcentov = akcijaProcentov;
        this.zaloga = zaloga;
    }

    public void setImeIzdelka(String imeIzdelka) {
        this.imeIzdelka = imeIzdelka;
    }
    public void setCena(float cena) {
        this.cena = cena;
    }
    public void setVAkciji(boolean vAkciji) {
        this.vAkciji = vAkciji;
    }
    public void setAkcijaProcentov(float akcijaProcentov) {
        this.akcijaProcentov = akcijaProcentov;
    }
    public void setZaloga(int zaloga) {
        this.zaloga = zaloga;
    }

    public String getImeIzdelka() {
        return this.imeIzdelka;
    }
    public float getCena() {
        return this.cena;
    }
    public boolean getVAkciji() {
        return this.vAkciji;
    }
    public float getAkcijaProcentov() {
        return this.akcijaProcentov;
    }
    public int getZaloga() {
        return this.zaloga;
    }

    public String izpisi() {
        return "do not remove this method";
    }

    public static ArrayList<Izdelek> readIzdelki(String datoteka) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(datoteka));

        ArrayList<Izdelek> izdelki = new ArrayList<Izdelek>();
        String s;
        while((s=br.readLine()) != null) {
            String[] arr = s.split(" ");

            switch(arr[0]) {
                case "Ovitek":
                    izdelki.add(new Ovitek(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], arr[8] ));
                    break;
                case "MobilniTelefon":
                    izdelki.add(new MobilniTelefon(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Integer.parseInt(arr[8]) ));
                    break;
                case "Slusalke":
                    izdelki.add(new Slusalke(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Boolean.parseBoolean(arr[8]) ));
                    break;
                case "NamizniRacunalnik":
                    izdelki.add(new NamizniRacunalnik(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Boolean.parseBoolean(arr[8]) ));
                    break;
                case "PrenosniRacunalnik":
                    izdelki.add(new PrenosniRacunalnik(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Integer.parseInt(arr[8]) ));
                    break;
                case "Monitor":
                    izdelki.add(new Monitor(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], arr[8] ));
                    break;
                case "Projektor":
                    izdelki.add(new Projektor(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Integer.parseInt(arr[8]) ));
                    break;
                case "PomivalniStroj":
                    izdelki.add(new PomivalniStroj(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[7]), arr[8] ));
                    break;
                case "Konzola":
                    izdelki.add(new Konzola(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], arr[8] ));
                    break;
                case "Vrtalnik":
                    izdelki.add(new Vrtalnik(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), Boolean.parseBoolean(arr[7]), Integer.parseInt(arr[8]) ));
                    break;
                default:
                    continue;
            }
        }
        br.close();
        return izdelki;
    }


    public static void productEntry(ArrayList<Izdelek> izdelki) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vnesi ime izdelka: ");
        String imeIzdelka = br.readLine();
        Izdelek izdelek = null;
        for(int i=0; i<izdelki.size(); i++) {
            // System.out.println(izdelki.get(i).imeIzdelka);
            if(izdelki.get(i).imeIzdelka.equals(imeIzdelka)) {
                izdelek = izdelki.get(i);
                break;
            }
        }
        if(izdelek instanceof Izdelek) {
            System.out.println("Izdelek je ze v sistemu");
            System.out.println("Trenutno izdelkov na voljo: " + izdelek.zaloga);
            System.out.println("Koliko izdelkov zelite dodati?");
            int n = Integer.parseInt(br.readLine());
            if(n < 0) {
                System.out.println("Ne morete dodati manj kot 0 izdelkov");
                throw new Exception();
            }
            izdelek.zaloga += n;
            System.out.println("Nova zaloga izdelka " + izdelek.imeIzdelka + ": "+ izdelek.zaloga);
        }
        else {
            System.out.println("Tega izdelka še ni v sistemu");
            System.out.println("Izberi kategorijo: ");
            System.out.println("1 -Mobilna Oprema");
            System.out.println("2 -Računalniki");
            System.out.println("3 -Video oprema");
            System.out.println("4 -Gospodinjska oprema");
            System.out.println("5 -Gaming");
            System.out.println("6 -Elektricno orodje");

            int kategorija = Integer.parseInt(br.readLine());
            switch(kategorija) {
                case 1:
                    MobilnaOprema.productEntry(izdelki, imeIzdelka);
                    break;
                case 2:
                    Racunalnik.productEntry(izdelki, imeIzdelka);
                    break;
                case 3:
                    VideoOprema.productEntry(izdelki, imeIzdelka);
                    break;
                case 4:
                    GospodinjskaOprema.productEntry(izdelki, imeIzdelka);
                    break;
                case 5:
                    Gaming.productEntry(izdelki, imeIzdelka);
                    break;
                case 6:
                    ElektricnoOrodje.productEntry(izdelki, imeIzdelka);
                    break;
            }
        }
        HelperFunctions.writeInFile(izdelki);

    }

    public static void productRemove(ArrayList<Izdelek> izdelki) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Vnesi ime izdelka: ");
        String imeIzdelka = br.readLine();
        Izdelek izdelek = null;
        for(int i=0; i<izdelki.size(); i++) {
            if(izdelki.get(i).imeIzdelka.equals(imeIzdelka)) {
                izdelek = izdelki.get(i);
                break;
            }
        }
        if(izdelek instanceof Izdelek) {
            System.out.println("Izdelek je v sistemu");
            System.out.println("Trenutno izdelkov na voljo: " + izdelek.zaloga);
            System.out.println("Koliko izdelkov zelite odstraniti?");
            int n = Integer.parseInt(br.readLine());
            if(n < 0) {
                System.out.println("ne morete odstraniti manj kot 0 izdelkov");
            }
            izdelek.zaloga -= n;
            if(izdelek.zaloga < 0) {
                System.out.println("Ni dovolj izdelkov na zalogi");
                throw new Exception();
            }

            System.out.println("Nova zaloga izdelka " + izdelek.imeIzdelka + ": "+ izdelek.zaloga);
            HelperFunctions.writeInFile(izdelki);
        }
        else {
            System.out.println("Tega izdelka ni v sistemu");
        }
    }

    public static void prodaja(ArrayList<Izdelek> izdelki) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vnesi ime izdelka za prodajo: ");
        String imeIzdelka = br.readLine();
        Izdelek izdelek = null;
        for(int i=0; i<izdelki.size(); i++) {
            if(izdelki.get(i).imeIzdelka.equals(imeIzdelka)) {
                izdelek = izdelki.get(i);
                break;
            }
        }
        if(izdelek instanceof Izdelek) {
            System.out.println("Izdelek je v sistemu");
            System.out.println("Trenutno izdelkov na voljo: " + izdelek.zaloga);
            System.out.println("Koliko izdelkov zelite prodati");
            int n = Integer.parseInt(br.readLine());
            if(n < 1) {
                System.out.println("Ne morete prodati manj kot 1 izdelek");
                throw new Exception();
            }
            izdelek.zaloga -= n;
            if(izdelek.zaloga < 0) {
                System.out.println("Ni dovolj izdelkov na zalogi");
                throw new Exception();
            }
            System.out.println("Nova zaloga izdelka " + izdelek.imeIzdelka + ": "+ izdelek.zaloga);
            HelperFunctions.writeInFileSold(izdelek, n);
            
            BufferedReader brBlagajna = new BufferedReader(new FileReader("blagajna.txt"));
            float skupajZasluzek = Float.parseFloat(brBlagajna.readLine().split(" ")[1]);
            brBlagajna.close();
            skupajZasluzek += izdelek.vAkciji ? (n * izdelek.cena * izdelek.akcijaProcentov) : (n * izdelek.cena);
            BufferedWriter bwBlagajna = new BufferedWriter(new FileWriter("blagajna.txt"));
            String skupajZasluzekString = "SkupajZasluzek= " + skupajZasluzek;
            bwBlagajna.write(skupajZasluzekString);
            bwBlagajna.close();
            HelperFunctions.writeInFile(izdelki);
        }
        else {
            System.out.println("Tega izdelka ni v sistemu");
        }
    }

    public static void vracilo(ArrayList<Izdelek> izdelki) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Vpisite ime izdelka, ki ga zelite vrniti: ");
        String imeIzdelka = br.readLine();
        System.out.println("Vpisite koliko izdelkov zelite vrniti: ");
        int kolicina = Integer.parseInt(br.readLine());
        if(kolicina <= 0) {
            System.out.println("Ne morete vrniti manj kot 1 izdelek");
            throw new Exception();
        }

        Izdelek izdelek = null;
        for(int i=0; i<izdelki.size(); i++) {
            if(izdelki.get(i).imeIzdelka.equals(imeIzdelka)) {
                izdelek = izdelki.get(i);
                break;
            }
        }

        ArrayList<Izdelek> prodaniIzdelki = Izdelek.readIzdelki("prodaniIzdelki.txt");
        Izdelek prodaniIzdelek = null;
        for(int i=0; i<prodaniIzdelki.size(); i++) {
            if(prodaniIzdelki.get(i).imeIzdelka.equals(imeIzdelka)) {
                prodaniIzdelek = prodaniIzdelki.get(i);
                break;
            }
        }
        if(prodaniIzdelek == null || (prodaniIzdelek.zaloga - kolicina < 0)) {
            System.out.println("Nismo prodali toliko izdelkov kot jiz zelite vrniti");
            throw new Exception();
        }

        if(izdelek instanceof Izdelek) {
            System.out.println("Izdelek se lahko vrne");
            
            izdelek.zaloga += kolicina;
            prodaniIzdelek.zaloga -= kolicina;

            // izpisi v file
            BufferedWriter pwVrnjeniIzdelki = new BufferedWriter(new FileWriter("vrnjeniIzdelki.txt", true));
            pwVrnjeniIzdelki.write(" \n" + izdelek.imeIzdelka + " - " + kolicina );
            pwVrnjeniIzdelki.close();

            System.out.println("Nova zaloga izdelka " + izdelek.imeIzdelka + ": "+ izdelek.zaloga);
            HelperFunctions.writeInFileSold(prodaniIzdelek, -kolicina);
            

            BufferedReader brBlagajna = new BufferedReader(new FileReader("blagajna.txt"));
            float skupajZasluzek = Float.parseFloat(brBlagajna.readLine().split(" ")[1]);
            brBlagajna.close();
            skupajZasluzek -= izdelek.vAkciji ? (kolicina * izdelek.cena * izdelek.akcijaProcentov) : (kolicina * izdelek.cena);
            String skupajZasluzekString = "SkupajZasluzek= " + skupajZasluzek;
            BufferedWriter bwBlagajna = new BufferedWriter(new FileWriter("blagajna.txt"));
            bwBlagajna.write(skupajZasluzekString);
            bwBlagajna.close();
            HelperFunctions.writeInFile(izdelki);
        }
        else {
            System.out.println("Tega ne prodajamo");
        }
    }

    public static void stanjeBlagajne() throws Exception{
        BufferedReader brBlagajna = new BufferedReader(new FileReader("blagajna.txt"));
        float skupajZasluzek = Float.parseFloat(brBlagajna.readLine().split(" ")[1]);
        System.out.println();
        System.out.println("trenutno stanje blagajne: " + skupajZasluzek);
    }

    public static void izpisKupljenih() throws Exception {
        System.out.println();
        System.out.println("Prodani izdelki: ");
        ArrayList<Izdelek> prodaniIzdelki = Izdelek.readIzdelki("prodaniIzdelki.txt");

        for(int i=0; i<prodaniIzdelki.size(); i++) {
            System.out.println("- " + prodaniIzdelki.get(i).imeIzdelka + " kolicina: " + prodaniIzdelki.get(i).zaloga);
        }
        System.out.println();
    }
}
