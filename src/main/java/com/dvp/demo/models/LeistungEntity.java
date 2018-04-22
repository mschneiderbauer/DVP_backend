package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Leistungen", schema = "dvpdatabase")
public class LeistungEntity {

    public int lid;

    private Date datl;
    private int anz;
    private String posnr;
    private long vo_id;

    @Id
    @Column(name="LID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLid() {
        return lid;
    }

    @Basic
    @Column(name="DATL")
    public Date getDatl() {
        return datl;
    }

    @Basic
    @Column(name="ANZ")
    public int getAnz() {
        return anz;
    }

    @Basic
    @Column(name="POSNR")
    public String getPosnr() {
        return posnr;
    }

    @Basic
    @Column(name="VO_ID")
    public long getVo_id() {
        return vo_id;
    }

    public void setDatl(Date DATL) {
        this.datl = DATL;
    }

    public void setAnz(int ANZ) {
        this.anz = ANZ;
    }

    public void setPosnr(String POSNR) {
        this.posnr = POSNR;
    }

    public void setVo_id(long VO_ID) {
        this.vo_id = VO_ID;
    }

    public void setLid(int LID) {
        this.lid = LID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungEntity that = (LeistungEntity) o;

        if (lid != that.lid) return false;
        if (anz != that.anz) return false;
        if (vo_id != that.vo_id) return false;
        if (datl != null ? !datl.equals(that.datl) : that.datl != null) return false;
        return posnr != null ? posnr.equals(that.posnr) : that.posnr == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (lid ^ (lid >>> 32));
        result = 31 * result + (datl != null ? datl.hashCode() : 0);
        result = 31 * result + (int) (anz ^ (anz >>> 32));
        result = 31 * result + (posnr != null ? posnr.hashCode() : 0);
        result = 31 * result + (int) (vo_id ^ (vo_id >>> 32));
        return result;
    }
}
