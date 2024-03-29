import java.io.*;
import java.util.*;

public class Slusalke extends MobilnaOprema {
    public String podkategorija;
    public boolean noiseCancelling;

    public Slusalke(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String proizvajalec,
        boolean noiseCancelling) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, proizvajalec);
            this.podkategorija = "Slusalke";
            this.noiseCancelling = noiseCancelling;
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija + " " + this.proizvajalec + " " + this.noiseCancelling;
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

        str += " proizvajalec: " + this.proizvajalec;
        str += " noise cancellation " + this.noiseCancelling;
        return str;
    }

    public static void novSlusalke(ArrayList<Izdelek> izdelki, String imeIzdelka, String proizvajalec) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vnesi ceno: ");
        float cena = Float.parseFloat(br.readLine());
        System.out.println("Je izdelek v akciji?");
        boolean vAkciji = Boolean.parseBoolean(br.readLine());
        System.out.println("velikost akcije (od 0 do 1): ");
        float akcijaProcentov = Float.parseFloat(br.readLine());
        System.out.println("Vpisi zalogo");
        int zaloga = Integer.parseInt(br.readLine());
        if(zaloga < 0) {
            throw new Exception();
        }
        System.out.println("Imajo slusalke noise cancelling?");
        boolean noiseCancelling = Boolean.parseBoolean(br.readLine());

        Slusalke izdelek = new Slusalke(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, proizvajalec, noiseCancelling);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }

}

