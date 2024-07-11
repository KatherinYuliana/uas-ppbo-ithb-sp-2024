package model;

public class Minuman extends MenuResto{
    private EnumJenisMinuman jenis;

    public Minuman(String kode, String nama, int harga, EnumJenisMinuman jenis) {
        super(kode, nama, harga);
        this.jenis = jenis;
    }

    public EnumJenisMinuman getJenis() {
        return jenis;
    }

    public void setJenis(EnumJenisMinuman jenis) {
        this.jenis = jenis;
    }

}
