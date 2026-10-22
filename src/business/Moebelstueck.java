package business;

public class Moebelstueck {
    
    // Name des Möbelstücks
    private String name;
    // Wohnraum (z. B. Wohnzimmer, Schlafzimmer)
    private String wohnraum;
    // Stil des Möbelstücks
    private String stil;
    // Preis des Möbelstücks
    private float preis;
    // Materialien des Möbelstücks
    private String[] materialien;

    public Moebelstueck(String name, String wohnraum, String stil,
        float preis, String[] materialien){
        this.name = name;
        this.wohnraum = wohnraum;
        this.stil = stil;
        this.preis = preis;
        this.materialien = materialien;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWohnraum() {
        return wohnraum;
    }

    public void setWohnraum(String wohnraum) {
        this.wohnraum = wohnraum;
    }

    public String getStil() {
        return stil;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public String[] getMaterialien() {
        return materialien;
    }

    public void setMaterialien(String[] materialien) {
        this.materialien = materialien;
    }
    
    public String getMaterialienAlsString(char trenner) {
        String ergebnis = "";
        int i = 0;
        for(i = 0; i < this.getMaterialien().length - 1; i++) {
            ergebnis = ergebnis + this.getMaterialien()[i] + trenner; 
        }
        return ergebnis + this.getMaterialien()[i];
    }
    
    public String gibMoebelstueckZurueck(char trenner){
        return this.getName() + trenner 
            + this.getWohnraum() + trenner
            + this.getStil() + trenner
            + this.getPreis() + trenner + "\n"
            + this.getMaterialienAlsString(trenner) + "\n";
    }
}