package Transaksi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * Entity untuk tabel data_pasien_kecantikan
 */
@Entity
@Table(name = "data_pasien_kecantikan")
public class PasienKecantikanEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 10)
    private String id;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(nullable = false, length = 100)
    private String alamat;

    @Column(name = "no_hp", nullable = false, length = 12)
    private String noHp;

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }


    // hashCode & equals
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PasienKecantikanEntity)) {
            return false;
        }
        PasienKecantikanEntity other = (PasienKecantikanEntity) object;
        return !((this.id == null && other.id != null)
                || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Transaksi.PasienKecantikanEntity[ id=" + id + " ]";
    }
}