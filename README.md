# 📦 Aplikasi Manajemen Penyimpanan Produk

Aplikasi *desktop* berbasis **JavaFX** untuk mengelola data inventaris atau penyimpanan produk. Aplikasi ini dirancang menggunakan arsitektur *Model-View-Controller* (MVC) dengan antarmuka yang rapi dan interaktif.

## ✨ Fitur Utama

Aplikasi ini memiliki sistem alur kerja yang terintegrasi penuh:

1. **📋 Daftar Seluruh Produk (Dashboard)**
   * Menampilkan seluruh data produk di dalam tabel.
   * Fitur pencarian data secara *real-time* berdasarkan nama atau kode produk.
   * Fitur penyaringan (*filtering*) data berdasarkan jenis kategori menggunakan *Combo Box*.
   * Mengurutkan data dan menampilkan indikator jumlah data yang aktif.

2. **➕ Sistem Tambah Produk**
   * Formulir penambahan data dengan validasi *input*.
   * Pemilihan kategori produk yang terintegrasi.
   * Pencegahan data kosong sebelum produk disimpan ke dalam memori aplikasi.

3. **🔍 Melihat Detail Produk**
   * Pengguna dapat memilih salah satu baris pada tabel, lalu membuka halaman detail khusus.
   * Menampilkan informasi produk secara lengkap berdasarkan data yang disorot (*selected item*).

4. **🗑️ Hapus Produk**
   * Fitur penghapusan produk yang dilengkapi dengan kotak dialog konfirmasi (*Alert Confirmation*) untuk mencegah penghapusan yang tidak disengaja.

## 🛠️ Teknologi dan Arsitektur

Proyek ini dibangun dengan standar pengembangan Java modern:
* **Bahasa Pemrograman:** Java (JDK 11+)
* **UI Framework:** JavaFX
* **Desain Antarmuka:** Gluon Scene Builder (`.fxml`)
* **Build Tool:** Apache Maven
* **Manajemen State (Data):** Menggunakan `ObservableList` untuk sinkronisasi otomatis antara memori dan tampilan tabel.
* **Sistem Navigasi:** Menggunakan *class* `Navigator` khusus dengan teknik *Dependency Injection* (`setKonteks`) agar data produk tidak hilang saat berpindah halaman.

## 🚀 Cara Menjalankan Aplikasi

Aplikasi ini menggunakan Maven, sehingga semua *library* sudah dikelola secara otomatis.

1. Buka proyek ini menggunakan IDE favorit Anda (NetBeans / IntelliJ IDEA).
2. Biarkan Maven mengunduh dependensi (*sync*) selama beberapa saat.
3. **Penting:** Lakukan **Clean and Build** pada proyek untuk memastikan semua *file* UI (`.fxml`) terbaru terhubung dengan *Controller*.
4. Jalankan aplikasi (Run).
   * *Jika Run biasa gagal, gunakan perintah Maven: `javafx:run`.*


## Lampiran
Tampilan form.fxml
<img width="1062" height="888" alt="image" src="https://github.com/user-attachments/assets/099b7d34-48ef-4dfe-8a08-99f0d5080909" />

Tampilan detail.fxml
<img width="1062" height="888" alt="image" src="https://github.com/user-attachments/assets/aa46c6fd-c15f-4b6f-8537-2615f5ec559d" />

Tampilan daftar.fxml
<img width="1062" height="888" alt="image" src="https://github.com/user-attachments/assets/557845f4-f574-479c-a3a5-4a295c234e1d" />
