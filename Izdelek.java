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

    public static ArrayList<Izdelek> readIzdelki(String datoteka) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(datoteka));

        ArrayList<Izdelek> izdelkii = new ArrayList<Izdelek>();
        String s;
        while((s=br.readLine()) != null) {
            String[] arr = s.split(" ");

            switch(arr[0]) {
                case "Ovitek":
                    izdelkii.add(new Ovitek(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], arr[8] ));
                    break;
                case "MobilniTelefon":
                    izdelkii.add(new MobilniTelefon(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Integer.parseInt(arr[8]) ));
                    break;
                case "Slusalke":
                    izdelkii.add(new Slusalke(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Boolean.parseBoolean(arr[8]) ));
                    break;
                case "NamizniRacunalnik":
                    izdelkii.add(new NamizniRacunalnik(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Boolean.parseBoolean(arr[8]) ));
                    break;
                case "PrenosniRacunalnik":
                    izdelkii.add(new PrenosniRacunalnik(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5]), arr[7], Integer.parseInt(arr[8]) ));
                    break;
            }
        }
        br.close();
        return izdelkii;
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
            int kategorija = Integer.parseInt(br.readLine());
            switch(kategorija) {
                case 1:
                    MobilnaOprema.productEntry(izdelki, imeIzdelka);
                    break;
                case 2:
                    Racunalnik.productEntry(izdelki, imeIzdelka);
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
            // System.out.println(izdelki.get(i).imeIzdelka);
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
            skupajZasluzek += (n * izdelek.cena);
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
}
