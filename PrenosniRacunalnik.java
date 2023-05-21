import java.io.*;
import java.util.*;

public class PrenosniRacunalnik extends Racunalnik{
    public String podkategorija;
    public int diagonalaZaslona;

    public PrenosniRacunalnik(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String procesor,
        int diagonalaZaslona) {
            
            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, procesor);
            this.podkategorija = "PrenosniRacunalnik";
            this.diagonalaZaslona = diagonalaZaslona;
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija + " " + this.procesor + " " + this.diagonalaZaslona;
    }

    public static void novPrenosniRacunalnik(ArrayList<Izdelek> izdelki, String imeIzdelka, String procesor) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vnesi ceno: ");
        float cena = Float.parseFloat(br.readLine());
        System.out.println("Je izdelek v akciji?");
        boolean vAkciji = Boolean.parseBoolean(br.readLine());
        System.out.println("velikost akcije (od 0 do 1): ");
        float akcijaProcentov = Float.parseFloat(br.readLine());
        System.out.println("Vpiši zalogo");
        int zaloga = Integer.parseInt(br.readLine());
        if(zaloga < 0) {
            throw new Exception();
        }
        System.out.println("Vpisi diagonalo zaslona: ");
        int diagonalaZaslona = Integer.parseInt(br.readLine());

        PrenosniRacunalnik izdelek = new PrenosniRacunalnik(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga, procesor, diagonalaZaslona);
        izdelki.add(izdelek);
        HelperFunctions.writeInFile(izdelki);
        System.out.println("Izdelek vnešen");
    }
}

