import java.io.*;
import java.util.*;

public class Racunalnik extends Izdelek{
    public String kategorija;
    public String procesor;

    public Racunalnik(        
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String procesor) {
            
            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "Racunalniki";
            this.procesor = procesor;
    }

    @Override
    public String getKategorija() {
        return this.kategorija;
    }

    public static void productEntry(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vpisi procesor");
        String procesor = br.readLine();

        System.out.println("Izberi podkategorijo: ");
        System.out.println("1 -Namizni Racunalnik");
        System.out.println("2 -Prenosni Racunalnik");
        int podkategorija = Integer.parseInt(br.readLine());
        switch(podkategorija) {
            case 1:
                NamizniRacunalnik.novNamizniRacunalnik(izdelki, imeIzdelka, procesor);
                break;
            case 2:
                PrenosniRacunalnik.novPrenosniRacunalnik(izdelki, imeIzdelka, procesor);
                break;
        }
    }
}
