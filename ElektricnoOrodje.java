import java.io.*;
import java.util.*;

public class ElektricnoOrodje extends Izdelek {
    public String kategorija;
    public boolean naBaterije;

    public ElektricnoOrodje(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga,
        boolean naBaterije) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "ElektricnoOrodje";
            this.naBaterije = naBaterije;
        }

    @Override
    public String getKategorija() {
        return this.kategorija;
    }
    
    
    public static void productEntry(ArrayList<Izdelek> izdelki, String imeIzdelka) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Uporablja baterije? ");
        boolean naBaterije = Boolean.parseBoolean(br.readLine());

        System.out.println("Izberi podkategorijo: ");
        System.out.println("1 -Vrtalniki");
        int podkategorija = Integer.parseInt(br.readLine());
        switch(podkategorija) {
            case 1:
                Vrtalnik.novVrtalnik(izdelki, imeIzdelka, naBaterije);
                break;
        }
    }
}
