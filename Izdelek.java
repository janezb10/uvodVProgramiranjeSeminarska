public class Izdelek {
    String imeIzdelka;
    // String kategorija;
    // String podkategorija;
    float cena;
    boolean vAkciji;
    float akcijaProcentov;
    int zaloga;

    public Izdelek(
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {

        this.imeIzdelka = imeIzdelka;
        this.cena = cena;
        this.vAkciji = vAkciji;
        this.akcijaProcentov = akcijaProcentov;
        this.zaloga = zaloga;
    }

    public void setImeIzdelka(String imeIzdelka) {
        this.imeIzdelka = imeIzdelka;
    }
    public void setCena(float cena) {
        this.cena = cena;
    }
    public void setVAkciji(boolean vAkciji) {
        this.vAkciji = vAkciji;
    }
    public void setAkcijaProcentov(float akcijaProcentov) {
        this.akcijaProcentov = akcijaProcentov;
    }
    public void setZaloga(int zaloga) {
        this.zaloga = zaloga;
    }

    public String getImeIzdelka() {
        return this.imeIzdelka;
    }
    public float getCena() {
        return this.cena;
    }
    public boolean getVAkciji() {
        return this.vAkciji;
    }
    public float getAkcijaProcentov() {
        return this.akcijaProcentov;
    }
    public int getZaloga() {
        return this.zaloga;
    }

}
