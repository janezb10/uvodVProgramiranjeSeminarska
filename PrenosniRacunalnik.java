public class PrenosniRacunalnik extends Racunalnik{
    public String podkategorija;

    public PrenosniRacunalnik(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {
            
            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.podkategorija = "PrenosniRacunalnik";
    }

    @Override
    public String toString() {
        return this.podkategorija + " " + this.imeIzdelka + " " + this.cena + " " + this.vAkciji + " " + this.akcijaProcentov + " " + this.zaloga + " " + this.kategorija;
    }
}
