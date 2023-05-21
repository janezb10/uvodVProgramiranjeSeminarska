import java.io.*;
import java.util.*;

public class MobilnaOprema extends Izdelek {
    public String kategorija;

    public MobilnaOprema(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "MobilnaOprema";
        }

    
    public static void productEntry(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Izberi podkategorijo: ");
        System.out.println("1 -Mobilni Telefon");
        System.out.println("2 -Ovitek");
        System.out.println("3 -Slusalke");
        int podkategorija = Integer.parseInt(br.readLine());
        switch(podkategorija) {
            case 1:
                MobilniTelefon.novMobilniTelefon(izdelki, imeIzdelka);
                break;
            case 2:
                Ovitek.novOvitek(izdelki, imeIzdelka);
                break;
            case 3:
                Slusalke.novSlusalke(izdelki, imeIzdelka);
                break;
        }
    }
}
