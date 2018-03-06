package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

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

    @ManyToOne(optional = false)
    private VerordnungEntity verordnungEntities;

    public VerordnungEntity getVerordnungEntities() {
        return verordnungEntities;
    }

    public void setVerordnungEntities(VerordnungEntity verordnungEntities) {
        this.verordnungEntities = verordnungEntities;
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
        if (DIAGN != null ? !DIAGN.equals(that.DIAGN) : that.DIAGN != null) return false;
        return verordnungEntities != null ? verordnungEntities.equals(that.verordnungEntities) : that.verordnungEntities == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (diagnoseId ^ (diagnoseId >>> 32));
        result = 31 * result + (DATD != null ? DATD.hashCode() : 0);
        result = 31 * result + (DIAGN != null ? DIAGN.hashCode() : 0);
        result = 31 * result + (int) (VOID ^ (VOID >>> 32));
        result = 31 * result + (verordnungEntities != null ? verordnungEntities.hashCode() : 0);
        return result;
    }
}
