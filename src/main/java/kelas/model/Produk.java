package kelas.model;

public class Produk {
    private final String namaPembeli; 
    private final int harga;
    private final String kategori;
    
    public Produk(String nama, int harga, String kategori) {
        if(nama == null || nama.isBlank()) throw new IllegalArgumentException("Nama produk wajib diisi.");
        if(harga <= 0) throw new IllegalArgumentException("harga harus lebih dari nol.");
        
        this.namaPembeli=nama.trim(); 
        this.harga=harga;
        this.kategori = kategori;
    }
    
    public String getNamaPembeli(){
        return namaPembeli;
    }
    
    public int getHarga(){
        return harga;
    }

    public String getKategori() {
        return kategori;
    }
    
    
}
