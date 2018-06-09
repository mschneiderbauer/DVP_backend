package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Diagnosen", schema = "dvpdatabase")
public class DiagnoseEntity {

    public int diagnose_id;

    private Date datd;
    private String diagn;
    private long vid;

    public DiagnoseEntity() {
    }

    @Id
    @Column(name = "diagnose_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDiagnose_id() {
        return diagnose_id;
    }

    @Basic
    @Column(name = "DATD")
    public Date getDatd() {
        return datd;
    }

    @Basic
    @Column(name = "DIAGN")
    public String getDiagn() {
        return diagn;
    }

    @Basic
    @Column(name = "VO_ID")
    public long getVid() {
        return vid;
    }

    public void setDatd(Date DATD) {
        this.datd = DATD;
    }

    public void setDiagn(String DIAGN) {
        this.diagn = DIAGN;
    }

    public void setVid(long VOID) {
        this.vid = VOID;
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
        if (vid != that.vid) return false;
        if (datd != null ? !datd.equals(that.datd) : that.datd != null) return false;
        return diagn != null ? diagn.equals(that.diagn) : that.diagn == null;
    }

    @Override
    public int hashCode() {
        int result = diagnose_id;
        result = 31 * result + (datd != null ? datd.hashCode() : 0);
        result = 31 * result + (diagn != null ? diagn.hashCode() : 0);
        result = 31 * result + (int) (vid ^ (vid >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DiagnoseEntity{" +
                "diagnose_id=" + diagnose_id +
                ", DATD=" + datd +
                ", DIAGN='" + diagn + '\'' +
                ", VO_ID=" + vid +
                '}';
    }
}
