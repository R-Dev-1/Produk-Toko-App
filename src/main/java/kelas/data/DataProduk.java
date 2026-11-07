package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Penambahan;
import kelas.model.Produk;

public class DataProduk {

    private final ObservableList<Penambahan> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<Penambahan> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public Penambahan tambah(Produk prod, String uri) {
        //TR%03d  Bagian ini digunakan untuk membuat kode pembelian, misalnya TR001, TR002, dan seterusnya.
        Penambahan p = new Penambahan(String.format("P%03d", urutan), prod, uri);
        daftar.add(p);
        urutan++;
        return p;
    }

    public void hapus(Penambahan p) {
        daftar.remove(p);
    }
}
