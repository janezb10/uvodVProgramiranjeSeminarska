import java.io.*;
import java.util.*;

public class Gaming extends Izdelek {
    public String kategorija;
    public String povezljivost;

    public Gaming(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        String povezljivost) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "Gaming";
            this.povezljivost = povezljivost;
        }


    @Override
    public String getKategorija() {
        return this.kategorija;
    }

    
    public static void productEntry(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Kaksno povezljivost ima? ");
        String povezljivost = br.readLine();

        System.out.println("Izberi podkategorijo: ");
        System.out.println("1 -Konzole");
        int podkategorija = Integer.parseInt(br.readLine());
        switch(podkategorija) {
            case 1:
                Konzola.novKonzola(izdelki, imeIzdelka, povezljivost);
                break;
        }
    }
}
