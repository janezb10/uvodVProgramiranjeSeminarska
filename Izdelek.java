import java.io.*;
import java.util.*;

public class Izdelek {
    String imeIzdelka;
    // String kategorija;
    // String podkategorija;
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

    public static ArrayList<Izdelek> readIzdelki() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("zaloga.txt"));

        ArrayList<Izdelek> izdelki = new ArrayList<Izdelek>();
        String s;
        while((s=br.readLine()) != null) {
            String[] arr = s.split(" ");

            switch(arr[0]) {
                case "Ovitek":
                    izdelki.add(new Ovitek(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5])));
                    break;
                case "MobilniTelefon":
                    izdelki.add(new MobilniTelefon(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5])));
                    break;
                case "Slusalke":
                    izdelki.add(new Slusalke(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5])));
                    break;
                case "NamizniRacunalnik":
                    izdelki.add(new NamizniRacunalnik(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5])));
                    break;
                case "PrenosniRacunalnik":
                    izdelki.add(new PrenosniRacunalnik(arr[1], Float.parseFloat(arr[2]), Boolean.parseBoolean(arr[3]), Float.parseFloat(arr[4]), Integer.parseInt(arr[5])));
                    break;
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
            System.out.println(izdelki.get(i).imeIzdelka);
            if(izdelki.get(i).imeIzdelka.equals(imeIzdelka)) {
                izdelek = izdelki.get(i);
                break;
            }
        }
        if(izdelek instanceof Izdelek) {
            System.out.println("Izdelek je ze v sistemu");
            System.out.println("Koliko izdelkov zelite dodati?");
            int n = Integer.parseInt(br.readLine());
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

}
