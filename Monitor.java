import java.io.*;
import java.util.*;

public class Monitor extends VideoOprema {
    public String podkategorija;
    public String tehnologijaZaslona;

    public Monitor(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String locljivost,
        String tehnologijaZaslona) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, locljivost);
            this.podkategorija = "Monitor";
            this.tehnologijaZaslona = tehnologijaZaslona;
    }

    // public Monitor(
    //     String imeIzdelka,
    //     float cena,
    //     boolean vAkciji,
    //     float akcijaProcentov,
    //     int zaloga,
    //     String locljivost,
    //     String tehnologijaZaslona) {

    //         super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, locljivost);
    //         this.podkategorija = "Monitor";
    //         this.tehnologijaZaslona = tehnologijaZaslona;

        
    // }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija + " " + this.locljivost + " " + this.tehnologijaZaslona;
    }

    @Override
    public String izpisi() {
        String str = this.imeIzdelka;
        str += " cena: " + this.cena;
        str += " zaloga: " + this.zaloga;
        str += " akcija: " + this.vAkciji;
        str += " akcija Procentov: " + this.akcijaProcentov;
        str += " kategorija: " + this.kategorija;
        str += " podkategorija: " + this.podkategorija;

        str += " locljivost: " + this.locljivost;
        str += " tehnologija zaslona: " + this.tehnologijaZaslona;
        return str;
    }

    public static void novMonitor(ArrayList<Izdelek> izdelki, String imeIzdelka, String locljivost) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vnesi ceno: ");
        float cena = Float.parseFloat(br.readLine());
        System.out.println("Je izdelek v akciji?");
        boolean vAkciji = Boolean.parseBoolean(br.readLine());
        System.out.println("velikost akcije (od 0 do 1): ");
        float akcijaProcentov = Float.parseFloat(br.readLine());
        System.out.println("Vpisi zalogo:");
        int zaloga = Integer.parseInt(br.readLine());
        if(zaloga < 0) {
            throw new Exception();
        }
        System.out.println("Vpisi tehnologijo zaslona:");
        String tehnologijaZaslona = br.readLine();

        Monitor izdelek = new Monitor(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, locljivost, tehnologijaZaslona);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }

}

