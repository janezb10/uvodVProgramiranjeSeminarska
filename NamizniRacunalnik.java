public class NamizniRacunalnik extends Racunalnik{
    public String podkategorija;

    public NamizniRacunalnik(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {

            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.podkategorija = "NamizniRacunalnik";
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija;
    }
}
