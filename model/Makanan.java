package model;

public class Makanan extends MenuResto{
    private boolean containsMeat;
    private int ukuranPorsi;

    public Makanan(String kode, String nama, int harga, boolean containsMeat, int ukuranPorsi) {
        super(kode, nama, harga);
        this.containsMeat = containsMeat;
        this.ukuranPorsi = ukuranPorsi;
    }
    public Makanan(String kode, String nama, int harga, int ukuranPorsi, boolean containsMeat, int i) {
        super(kode, nama, harga);
        this.containsMeat = containsMeat;
        this.ukuranPorsi = ukuranPorsi;
    }
    public boolean isContainsMeat() {
        return containsMeat;
    }
    public void setContainsMeat(boolean containsMeat) {
        this.containsMeat = containsMeat;
    }
    public int getUkuranPorsi() {
        return ukuranPorsi;
    }
    public void setUkuranPorsi(int ukuranPorsi) {
        this.ukuranPorsi = ukuranPorsi;
    }


}
