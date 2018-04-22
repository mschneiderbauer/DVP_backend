package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Leistungen", schema = "dvpdatabase")
public class LeistungEntity {

    public int LID;

    private Date DATL;
    private int ANZ;
    private String POSNR;
    private long VO_ID;

    @Id
    @Column(name="LID")
    public int getLID() {
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

    @Basic
    @Column(name="VO_ID")
    public long getVO_ID() {
        return VO_ID;
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

    public void setVO_ID(long VO_ID) {
        this.VO_ID = VO_ID;
    }

    public void setLID(int LID) {
        this.LID = LID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungEntity that = (LeistungEntity) o;

        if (LID != that.LID) return false;
        if (ANZ != that.ANZ) return false;
        if (VO_ID != that.VO_ID) return false;
        if (DATL != null ? !DATL.equals(that.DATL) : that.DATL != null) return false;
        return POSNR != null ? POSNR.equals(that.POSNR) : that.POSNR == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (LID ^ (LID >>> 32));
        result = 31 * result + (DATL != null ? DATL.hashCode() : 0);
        result = 31 * result + (int) (ANZ ^ (ANZ >>> 32));
        result = 31 * result + (POSNR != null ? POSNR.hashCode() : 0);
        result = 31 * result + (int) (VO_ID ^ (VO_ID >>> 32));
        return result;
    }
}
