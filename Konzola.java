import java.io.*;
import java.util.*;

public class Konzola extends Gaming {
    public String podkategorija;
    public String tipKonzole;

    public Konzola(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String povezljivost,
        String tipKonzole) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, povezljivost);
            this.podkategorija = "Konzola";
            this.tipKonzole = tipKonzole;
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija + " " + this.povezljivost + " " + this.tipKonzole;
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

        str += " povezljivos: " + this.povezljivost;
        str += " tip konzole: " + this.tipKonzole;
        return str;
    }

    public static void novKonzola(ArrayList<Izdelek> izdelki, String imeIzdelka, String povezljivost) throws Exception{
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
        System.out.println("Vpisi tip konzole:");
        String tipKonzole = br.readLine();

        Konzola izdelek = new Konzola(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, povezljivost, tipKonzole);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }

}

