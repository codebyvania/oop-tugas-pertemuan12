package Transaksi;

import Transaksi.PasienKecantikanEntity;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-11-09T14:49:26", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(DataTreatmentEntity.class)
public class DataTreatmentEntity_ { 

    public static volatile SingularAttribute<DataTreatmentEntity, String> dokter;
    public static volatile SingularAttribute<DataTreatmentEntity, String> idTreatment;
    public static volatile SingularAttribute<DataTreatmentEntity, BigDecimal> harga;
    public static volatile SingularAttribute<DataTreatmentEntity, PasienKecantikanEntity> pasien;
    public static volatile SingularAttribute<DataTreatmentEntity, String> tanggal;
    public static volatile SingularAttribute<DataTreatmentEntity, String> namaTreatment;

}