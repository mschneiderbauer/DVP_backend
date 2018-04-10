package com.dvp.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Diagnosen", schema = "dvpdatabase")
public class DiagnoseEntity {

    public int diagnoseId;

    private Date DATD;
    private String DIAGN;
    private long VOID;

    public DiagnoseEntity() {
    }

    @Id
    public int getDiagnoseId() {
        return diagnoseId;
    }

    @Basic
    @Column(name = "DATD")
    @Temporal(TemporalType.DATE)
    public Date getDATD() {
        return DATD;
    }

    @Basic
    @Column(name = "DIAGN")
    public String getDIAGN() {
        return DIAGN;
    }

    @Basic
    @Column(name = "VOID")
    public long getVOID() {
        return VOID;
    }

    public void setDATD(Date DATD) {
        this.DATD = DATD;
    }

    public void setDIAGN(String DIAGN) {
        this.DIAGN = DIAGN;
    }

    public void setVOID(long VOID) {
        this.VOID = VOID;
    }


    public void setDiagnoseId(int diagnoseId) {
        this.diagnoseId = diagnoseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiagnoseEntity that = (DiagnoseEntity) o;

        if (diagnoseId != that.diagnoseId) return false;
        if (VOID != that.VOID) return false;
        if (DATD != null ? !DATD.equals(that.DATD) : that.DATD != null) return false;
        return DIAGN != null ? DIAGN.equals(that.DIAGN) : that.DIAGN == null;
    }

    @Override
    public int hashCode() {
        int result = diagnoseId;
        result = 31 * result + (DATD != null ? DATD.hashCode() : 0);
        result = 31 * result + (DIAGN != null ? DIAGN.hashCode() : 0);
        result = 31 * result + (int) (VOID ^ (VOID >>> 32));
        return result;
    }
}
