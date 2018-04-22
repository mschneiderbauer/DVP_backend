package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Diagnosen", schema = "dvpdatabase")
public class DiagnoseEntity {

    public int diagnose_id;

    private long VO_ID;
    private Date DATD;
    private String DIAGN;


    public DiagnoseEntity() {
    }

    @Id
    @Column(name = "diagnose_id")
    public int getDiagnose_id() {
        return diagnose_id;
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
    @Column(name = "VO_ID")
    public long getVO_ID() {
        return VO_ID;
    }

    public void setDATD(Date DATD) {
        this.DATD = DATD;
    }

    public void setDIAGN(String DIAGN) {
        this.DIAGN = DIAGN;
    }

    public void setVO_ID(long VOID) {
        this.VO_ID = VOID;
    }


    public void setDiagnose_id(int diagnoseId) {
        this.diagnose_id = diagnoseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiagnoseEntity that = (DiagnoseEntity) o;

        if (diagnose_id != that.diagnose_id) return false;
        if (VO_ID != that.VO_ID) return false;
        if (DATD != null ? !DATD.equals(that.DATD) : that.DATD != null) return false;
        return DIAGN != null ? DIAGN.equals(that.DIAGN) : that.DIAGN == null;
    }

    @Override
    public int hashCode() {
        int result = diagnose_id;
        result = 31 * result + (DATD != null ? DATD.hashCode() : 0);
        result = 31 * result + (DIAGN != null ? DIAGN.hashCode() : 0);
        result = 31 * result + (int) (VO_ID ^ (VO_ID >>> 32));
        return result;
    }
}
