package kelas.model;

public class Penambahan {

    private final String kode;
    private final Produk produk;
    private final String gambarUri;

    public Penambahan(String kode, Produk produk, String gambarUri) {
        if (kode == null || kode.isBlank() || produk == null) {
            throw new IllegalArgumentException("Data pembelian tidak lengkap.");
        }
        this.kode = kode;
        this.produk = produk;
        this.gambarUri = gambarUri;
    }

    public String getKode() {
        return kode;
    }

    public Produk getProduk() {
        return produk;
    }

    public String getGambarUri() {
        return gambarUri;
    }

    public String getKategori() {
        return produk.getKategori();
    }

    public String getNamaPembeli() {
        return produk.getNamaPembeli();
    }

    public long getHarga() {
        return produk.getHarga();
    }
}
