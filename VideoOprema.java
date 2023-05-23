import java.io.*;
import java.util.*;

public class VideoOprema extends Izdelek{
    public String kategorija;
    public String locljivost;

    public VideoOprema(        
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String locljivost) {
            
            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "VideoOprema";
            this.locljivost = locljivost;
    }

    public static void productEntry(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Vpisi locljivost");
        String locljivost = br.readLine();

        System.out.println("Izberi podkategorijo: ");
        System.out.println("1 -Monitor");
        System.out.println("2 -Projektor");
        int podkategorija = Integer.parseInt(br.readLine());
        switch(podkategorija) {
            case 1:
                Monitor.novMonitor(izdelki, imeIzdelka, locljivost);
                break;
            case 2:
                Projektor.novProjektor(izdelki, imeIzdelka, locljivost);
                break;
        }
    }
}
