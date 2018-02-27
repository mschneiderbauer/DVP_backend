package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Leistungen", schema = "dvpdatabase", catalog = "")
public class LeistungEntity {

    @Id
    public long LID;

    private Date DATL;
    private int ANZ;
    private String POSNR;
    private int VOID;

    public long getLID() {
        return LID;
    }

    @Basic
    @Column(name="DATL")
    public Date getDATL() {
        return DATL;
    }

    @Basic
    @Column(name="ANZ")
    public int getANZ() {
        return ANZ;
    }

    @Basic
    @Column(name="POSNR")
    public String getPOSNR() {
        return POSNR;
    }

    @Basic //?
    @Column(name="VOID")
    public int getVOID() {
        return VOID;
    }

    public void setDATL(Date DATL) {
        this.DATL = DATL;
    }

    public void setANZ(int ANZ) {
        this.ANZ = ANZ;
    }

    public void setPOSNR(String POSNR) {
        this.POSNR = POSNR;
    }

    public void setVOID(int VOID) {
        this.VOID = VOID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungEntity that = (LeistungEntity) o;

        if (LID != that.LID) return false;
        if (ANZ != that.ANZ) return false;
        if (VOID != that.VOID) return false;
        if (DATL != null ? !DATL.equals(that.DATL) : that.DATL != null) return false;
        return POSNR != null ? POSNR.equals(that.POSNR) : that.POSNR == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (LID ^ (LID >>> 32));
        result = 31 * result + DATL.hashCode();
        result = 31 * result + ANZ;
        result = 31 * result + POSNR.hashCode();
        result = 31 * result + VOID;
        return result;
    }
}
