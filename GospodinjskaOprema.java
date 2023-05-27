import java.io.*;
import java.util.*;

public class GospodinjskaOprema extends Izdelek {
    public String kategorija;
    public int garancijaMeseci;

    public GospodinjskaOprema(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        int garancijaMeseci) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "GospodinjskaOprema";
            this.garancijaMeseci = garancijaMeseci;
        }

    
    public static void productEntry(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vpisi mesece garancije: ");
        int garancijaMeseci = Integer.parseInt(br.readLine());

        System.out.println("Izberi podkategorijo: ");
        System.out.println("1 -Pomivalni Stroji");
        int podkategorija = Integer.parseInt(br.readLine());
        switch(podkategorija) {
            case 1:
                PomivalniStroj.novPomivalniStroj(izdelki, imeIzdelka, garancijaMeseci);
                break;
        }
    }
}
