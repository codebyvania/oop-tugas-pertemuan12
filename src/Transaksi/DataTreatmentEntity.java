package Transaksi;

import Transaksi.PasienKecantikanEntity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date; // Gunakan java.util.Date untuk kompatibilitas yang lebih luas

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entitas JPA untuk tabel data_treatment
 * Relasi ManyToOne ke PasienKecantikanEntity sudah benar.
 * * @author User
 */

@Entity
@Table(name = "data_treatment")
public class DataTreatmentEntity implements Serializable { // <--- PERBAIKAN 1: Implement Serializable

    private static final long serialVersionUID = 1L; // Direkomendasikan untuk Serializable

    @Id
    @Column(name = "id_treatment", length = 10)
    private String idTreatment;

    // Relasi ke PasienKecantikanEntity (Foreign Key 'id')
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private PasienKecantikanEntity pasien;

    @Column(name = "nama_treatment", nullable = false, length = 100)
    private String namaTreatment;

    @Column(name = "dokter", nullable = false, length = 100)
    private String dokter;

    @Column(name = "harga", nullable = false)
    private BigDecimal harga;

    // Gunakan java.util.Date dan anotasi @Temporal
    @Column(name = "tanggal", nullable = false)
    private String tanggal; // <--- PERBAIKAN 5: Menggunakan java.util.Date

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    // ====== Getter & Setter ======
    public String getIdTreatment() {
        return idTreatment;
    }

    public void setIdTreatment(String idTreatment) {
        this.idTreatment = idTreatment;
    }

    public PasienKecantikanEntity getPasien() {
        return pasien;
    }

    public void setPasien(PasienKecantikanEntity pasien) {
        this.pasien = pasien;
    }


    public String getNamaTreatment() {
        return namaTreatment;
    }

    public void setNamaTreatment(String namaTreatment) {
        this.namaTreatment = namaTreatment;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }


    // ====== hashCode, equals, toString ======
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTreatment != null ? idTreatment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DataTreatmentEntity)) {
            return false;
        }
        DataTreatmentEntity other = (DataTreatmentEntity) object;
        // <--- PERBAIKAN 4: Menambahkan this.idTreatment yang hilang
        if ((this.idTreatment == null && other.idTreatment != null) ||
            (this.idTreatment != null && !this.idTreatment.equals(other.idTreatment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaksi.DataTreatmentEntity[ idTreatment=" + idTreatment + " ]";
    }
}