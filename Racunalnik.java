public class Racunalnik extends Izdelek{
    public String kategorija;

    public Racunalnik(        
        String imeIzdelka,
        float cena,
        boolean vAkciji,
        float akcijaProcentov,
        int zaloga) {
            
            super(imeIzdelka, cena, vAkciji, akcijaProcentov, zaloga);
            this.kategorija = "Računalniki";
        }
    
}
