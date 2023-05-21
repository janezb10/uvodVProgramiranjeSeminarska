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

    
    
}
