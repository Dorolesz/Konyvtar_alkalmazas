package com.example.konyvtar_alkalmazas;

public class Konyv {
    private String konyvCime;
    private String szerzoNeve;
    private int oldalakSzama;

    public Konyv(String konyvCime,String szerzoNeve, int oldalakszama) {
        this.konyvCime = konyvCime;
        this.szerzoNeve = szerzoNeve;
        this.oldalakSzama = oldalakszama;
    }

    public String getKonyvCime() {
        return konyvCime;
    }
    public String getSzerzoNeve() {
        return szerzoNeve;
    }
    public int getOldalakSzama() {
        return oldalakSzama;
    }

}
