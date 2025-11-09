# 🧩 Aplikasi CRUD dengan Foreign Key – PBO

## 📘 Deskripsi Proyek

Proyek ini merupakan hasil **praktikum Pemrograman Berorientasi Objek (PBO)** yang bertujuan untuk menerapkan konsep **CRUD (Create, Read, Update, Delete)** pada aplikasi berbasis Java dengan relasi antar tabel menggunakan **foreign key**.
Aplikasi ini menampilkan penerapan prinsip PBO melalui penggunaan **class entity**, **JFrame**, dan **JDialog**, serta pengelolaan data yang terhubung antar tabel di basis data relasional.

---

## ⚙️ Fitur Utama

* ✨ **Create** – Menambahkan data baru ke tabel induk dan tabel anak.
* 🔍 **Read** – Menampilkan data dari dua tabel yang saling berelasi.
* 🖊️ **Update** – Memperbarui data berdasarkan ID atau foreign key yang terhubung.
* ❌ **Delete** – Menghapus data dengan memperhatikan integritas referensial (FK).
* 📦 **Upload** – Memasukkan data melalui file CSV.
* 🧾 **Cetak (Optional)** – Menampilkan laporan data menggunakan JasperReport.

---

## 🏗️ Struktur Aplikasi

```
├── src/
│   ├── Entity/
│   │   ├── PasienEntity.java
│   │   └── DataTreatmentEntity.java
│   ├── Transaksi/
│   │   ├── InsertDialog.java
│   │   ├── UpdateDialog.java
│   │   ├── DeleteDialog.java
│   │   └── MainFrame.java
│   └── Utils/
│       └── DBUtils.java
│
├── resources/
│   └── laporan/
│       └── report_template.jrxml (opsional)
│
└── README.md
```

---

## 🗄️ Struktur Database

### Tabel 1 – **Pasien**

| Kolom     | Tipe Data | Keterangan           |
| --------- | --------- | -------------------- |
| id_pasien | INT (PK)  | Primary Key          |
| nama      | VARCHAR   | Nama pasien          |
| alamat    | VARCHAR   | Alamat pasien        |
| no_hp     | VARCHAR   | Nomor telepon pasien |

### Tabel 2 – **DataTreatment**

| Kolom           | Tipe Data | Keterangan                  |
| --------------- | --------- | --------------------------- |
| id_treatment    | INT (PK)  | Primary Key                 |
| id_pasien       | INT (FK)  | Foreign key ke tabel Pasien |
| jenis_treatment | VARCHAR   | Jenis perawatan             |
| biaya           | DECIMAL   | Biaya perawatan             |

Relasi:
**Pasien (1) → (n) DataTreatment**
Satu pasien dapat memiliki banyak riwayat treatment.

---

## 🖥️ Teknologi yang Digunakan

* **Java (Swing & JPA)**
* **NetBeans IDE**
* **MySQL / MariaDB**
* **JasperReport** *(opsional, untuk cetak laporan)*

---

## 🚀 Cara Menjalankan Program

1. Import proyek ke **NetBeans**.
2. Pastikan database sudah dibuat sesuai struktur di atas.
3. Konfigurasikan koneksi database di file `persistence.xml` atau `DBUtils.java`.
4. Jalankan kelas utama (`MainFrame.java`).
5. Gunakan tombol:

   * ➕ **Tambah** untuk Insert
   * 📝 **Edit** untuk Update
   * 🗑️ **Hapus** untuk Delete
   * 🔄 **Refresh** untuk menampilkan data terkini

---

## 📚 Tujuan Pembelajaran

* Memahami konsep CRUD dalam aplikasi berorientasi objek.
* Menerapkan relasi antar tabel menggunakan **foreign key**.
* Menjaga **integritas referensial** dalam operasi database.
* Mengintegrasikan konsep **PBO** dengan sistem basis data relasional.


