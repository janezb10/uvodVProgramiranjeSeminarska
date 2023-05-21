public class Ovitek extends MobilnaOprema {
    // public String barva;
    public String podkategorija;

    public Ovitek(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.podkategorija = "Ovitek";
    }

    // public static novOvitek()

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija;
    }
}
