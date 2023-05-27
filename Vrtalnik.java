import java.io.*;
import java.util.*;

public class Vrtalnik extends ElektricnoOrodje {
    public String podkategorija;
    public int nazivnaMoc;

    public Vrtalnik(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        boolean naBaterije,
        int nazivnaMoc) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, naBaterije);
            this.podkategorija = "Vrtalnik";
            this.nazivnaMoc = nazivnaMoc;
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija + " " + this.naBaterije + " " + this.nazivnaMoc;
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

        str += " naBaterije: " + this.naBaterije;
        str += " nazivna Moc: " + this.nazivnaMoc;
        return str;
    }

    public static void novVrtalnik(ArrayList<Izdelek> izdelki, String imeIzdelka, boolean naBaterije) throws Exception{
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
        System.out.println("Vpisi nazivno moc (250 - 3200 W):");
        int nazivnaMoc = Integer.parseInt(br.readLine());

        Vrtalnik izdelek = new Vrtalnik(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, naBaterije, nazivnaMoc);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }

}

