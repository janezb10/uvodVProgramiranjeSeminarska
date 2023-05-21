import java.io.*;
import java.util.*;

public class Racunalnik extends Izdelek{
    public String kategorija;

    public Racunalnik(        
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {
            
            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "Računalniki";
    }

    public static void productEntry(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Izberi podkategorijo: ");
        System.out.println("1 -Namizni Racunalnik");
        System.out.println("2 -Prenosni Racunalnik");
        int podkategorija = Integer.parseInt(br.readLine());
        switch(podkategorija) {
            case 1:
                NamizniRacunalnik.novNamizniRacunalnik(izdelki, imeIzdelka);
                break;
            case 2:
                PrenosniRacunalnik.novPrenosniRacunalnik(izdelki, imeIzdelka);
                break;
        }
    }
}
