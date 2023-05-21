import java.io.*;
import java.util.*;

public class Ovitek extends MobilnaOprema {
    // public String barva;
    public String podkategorija;

    public Ovitek(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.podkategorija = "Ovitek";
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija;
    }

    public static void novOvitek(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vnesi ceno: ");
        float cena = Float.parseFloat(br.readLine());
        System.out.println("Je izdelek v akciji?");
        boolean vAkciji = Boolean.parseBoolean(br.readLine());
        System.out.println("velikost akcije (od 0 do 1): ");
        float akcijaProcentov = Float.parseFloat(br.readLine());
        System.out.println("Vpiši zalogo");
        int zaloga = Integer.parseInt(br.readLine());

        Ovitek izdelek = new Ovitek(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }
}
