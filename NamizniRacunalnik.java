import java.io.*;
import java.util.*;

public class NamizniRacunalnik extends Racunalnik{
    public String podkategorija;
    public boolean namescenOperacijskiSistem;

    public NamizniRacunalnik(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String procesor,
        boolean namescenOperacijskiSistem) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, procesor);
            this.podkategorija = "NamizniRacunalnik";
            this.namescenOperacijskiSistem = namescenOperacijskiSistem;
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija + " " + this.procesor + " " + this.namescenOperacijskiSistem;
    }

    public static void novNamizniRacunalnik(ArrayList<Izdelek> izdelki, String imeIzdelka, String procesor) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vnesi ceno: ");
        float cena = Float.parseFloat(br.readLine());
        System.out.println("Je izdelek v akciji?");
        boolean vAkciji = Boolean.parseBoolean(br.readLine());
        System.out.println("velikost akcije (od 0 do 1): ");
        float akcijaProcentov = Float.parseFloat(br.readLine());
        System.out.println("Vpiši zalogo");
        int zaloga = Integer.parseInt(br.readLine());
        System.out.println("Ima namescen operacijski sistem?");
        boolean namescenOperacijskiSistem = Boolean.parseBoolean(br.readLine());

        NamizniRacunalnik izdelek = new NamizniRacunalnik(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, procesor, namescenOperacijskiSistem);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }
}
