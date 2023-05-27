import java.io.*;
import java.util.*;

public class PomivalniStroj extends GospodinjskaOprema {
    public String podkategorija;
    public String energijskiRazred;

    public PomivalniStroj(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        int garancijaMeseci,
        String energijskiRazred) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, garancijaMeseci);
            this.podkategorija = "PomivalniStroj";
            this.energijskiRazred = energijskiRazred;
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija + " " + this.garancijaMeseci + " " + this.energijskiRazred;
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

        str += " meseci garancije: " + this.garancijaMeseci;
        str += " energijski razred: " + this.energijskiRazred;
        return str;
    }

    public static void novPomivalniStroj(ArrayList<Izdelek> izdelki, String imeIzdelka, int garancijaMeseci) throws Exception{
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
        System.out.println("Vpisi energijski razred:");
        String energijskiRazred = br.readLine();

        PomivalniStroj izdelek = new PomivalniStroj(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, garancijaMeseci, energijskiRazred);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }

}

