package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Diagnosen", schema = "dvpdatabase", catalog = "")
public class DiagnoseEntity {

    @Id
    @GeneratedValue //vielleicht
    public int diagnoseId;

    private Date DATD;
    private String DIAGN;
    private int VOID;

    public DiagnoseEntity() {
    }

    public DiagnoseEntity(Date DATD, String DIAGN, int VOID) {
        this.DATD = DATD;
        this.DIAGN = DIAGN;
        this.VOID = VOID;
    }

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
    public int getVOID() {
        return VOID;
    }

    public void setDATD(Date DATD) {
        this.DATD = DATD;
    }

    public void setDIAGN(String DIAGN) {
        this.DIAGN = DIAGN;
    }

    public void setVOID(int VOID) {
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
        int result = diagnoseId;
        result = 31 * result + (DATD != null ? DATD.hashCode() : 0);
        result = 31 * result + (DIAGN != null ? DIAGN.hashCode() : 0);
        result = 31 * result + VOID;
        result = 31 * result + (verordnungEntities != null ? verordnungEntities.hashCode() : 0);
        return result;
    }
}
