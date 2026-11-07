package kelas.controller;

import java.io.IOException;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Penambahan;

public class DaftarController {

    @FXML
    private TableView<Penambahan> tabel;
    @FXML
    private TableColumn<Penambahan, String> kodeCol;
    @FXML
    private TableColumn<Penambahan, String> namaCol;
    @FXML
    private TableColumn<Penambahan, String> jenisCol;
    @FXML
    private TableColumn<Penambahan, Long> totalCol;
    @FXML
    private TextField cariField;
    @FXML
    private ComboBox<String> filterJenisBox;
    
    @FXML
    private Label pesanLabel;
    private Navigator navigator;
    private DataProduk data;
    private final ObservableList<Penambahan> dataTampilan
            = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // KOLOM KODE
        PropertyValueFactory<Penambahan, String> sumberKode
                = new PropertyValueFactory<Penambahan, String>("kode");

        kodeCol.setCellValueFactory(sumberKode);

        // KOLOM NAMA PEMBELI
        PropertyValueFactory<Penambahan, String> sumberNama
                = new PropertyValueFactory<Penambahan, String>("namaPembeli");

        namaCol.setCellValueFactory(sumberNama);

        // KOLOM JENIS TIKET
        PropertyValueFactory<Penambahan, String> sumberJenis
                = new PropertyValueFactory<Penambahan, String>("kategori");

        jenisCol.setCellValueFactory(sumberJenis);

        // KOLOM TOTAL
        PropertyValueFactory<Penambahan, Long> sumberTotal
                = new PropertyValueFactory<Penambahan, Long>("harga");

        totalCol.setCellValueFactory(sumberTotal);

        filterJenisBox.getItems().add("Semua");
        filterJenisBox.getItems().add("Makanan");
        filterJenisBox.getItems().add("Minuman");
        filterJenisBox.setValue("Semua");

        tabel.setItems(dataTampilan);
        tabel.setPlaceholder(new Label("Belum ada data yang sesuai."));
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
        cari();
    }

    @FXML
    private void cari() {
        if (data == null) {
            return;
        }
        dataTampilan.clear();
        String kata = cariField.getText().trim().toLowerCase(Locale.ROOT);
        String jenisDipilih = filterJenisBox.getValue();

        for (Penambahan Penambahan : data.getDaftar()) {
            String kode = Penambahan.getKode().toLowerCase(Locale.ROOT);
            String nama = Penambahan.getNamaPembeli().toLowerCase(Locale.ROOT);
            boolean cocokKata = false;
            boolean cocokJenis = false;

            if (kode.contains(kata) || nama.contains(kata)) {
                cocokKata = true;
            }
            if ("Semua".equals(jenisDipilih)) {
                cocokJenis = true;
            } else if (Penambahan.getKategori().equals(jenisDipilih)) {
                cocokJenis = true;
            }
            if (cocokKata && cocokJenis) {
                dataTampilan.add(Penambahan);
            }
        }
        tabel.sort();
        pesanLabel.setText("Jumlah data yang tampil: " + dataTampilan.size());
    }

    @FXML
    private void resetPencarian() {
        cariField.clear();
        filterJenisBox.setValue("Semua");
        cari();
    }

    @FXML
    private void tambah() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Form gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void detail() {
        Penambahan p = tabel.getSelectionModel().getSelectedItem();
        if (p == null) {
            pesanLabel.setText("Pilih satu baris dahulu.");
            return;
        }
        try {
            navigator.bukaDetail(p);
        } catch (IOException e) {
            pesanLabel.setText("Detail gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void hapus() {
        Penambahan Penambahan = tabel.getSelectionModel().getSelectedItem();
        if (Penambahan == null) {
            pesanLabel.setText("Pilih satu baris dahulu.");
            return;
        }
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION,
                "Hapus " + Penambahan.getKode() + "?",
                ButtonType.YES, ButtonType.NO);
        dialog.initOwner(tabel.getScene().getWindow());
        ButtonType jawaban = dialog.showAndWait().orElse(ButtonType.NO);
        if (jawaban == ButtonType.YES) {
            data.hapus(Penambahan);
            cari();
        }
    }
}
