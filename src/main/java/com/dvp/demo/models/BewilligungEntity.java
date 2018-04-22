package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Bewilligungen", schema = "dvpdatabase")
public class BewilligungEntity {

    public long bewilligungs_id;

    private String bewnr;
    private Date bdat;
    private long vo_id;

    @Id
    @Column(name = "bewilligungs_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getBewilligungs_id() {
        return bewilligungs_id;
    }

    public BewilligungEntity() {
    }

    @Basic
    @Column(name = "BDAT")
    public Date getBdat() {
        return bdat;
    }

    @Basic
    @Column(name = "BEWNR")
    public String getBewnr() {
        return bewnr;
    }

    @Basic
    @Column(name = "VO_ID")
    public long getVo_id() {
        return vo_id;
    }

    public void setBdat(Date BDAT) {
        this.bdat = BDAT;
    }

    public void setBewnr(String BEWNR) {
        this.bewnr = BEWNR;
    }

    public void setVo_id(long VOID) {
        this.vo_id = VOID;
    }

    public void setBewilligungs_id(long bewilligungs_id) {
        this.bewilligungs_id = bewilligungs_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BewilligungEntity that = (BewilligungEntity) o;

        if (bewilligungs_id != that.bewilligungs_id) return false;
        if (vo_id != that.vo_id) return false;
        if (bdat != null ? !bdat.equals(that.bdat) : that.bdat != null) return false;
        return bewnr != null ? bewnr.equals(that.bewnr) : that.bewnr == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (bewilligungs_id ^ (bewilligungs_id >>> 32));
        result = 31 * result + (bdat != null ? bdat.hashCode() : 0);
        result = 31 * result + (bewnr != null ? bewnr.hashCode() : 0);
        result = 31 * result + (int) (vo_id ^ (vo_id >>> 32));
        return result;
    }
}
