package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class BewilligungEntity {

    
    public long bewilligungs_id;

    private Date BDAT;
    private String BEWNR;
    private long VOID;

    @Id
    public long getBewilligungs_id() {
        return bewilligungs_id;
    }

    public BewilligungEntity() {
    }

    @Basic
    @Column(name="BDAT")
    @Temporal(TemporalType.DATE)
    public Date getBDAT() {
        return BDAT;
    }

    @Basic
    @Column(name="BEWNR")
    public String getBEWNR() {
        return BEWNR;
    }

    @Basic
    @Column(name="VOID")
    public long getVOID() {
        return VOID;
    }

    public void setBDAT(Date BDAT) {
        this.BDAT = BDAT;
    }

    public void setBEWNR(String BEWNR) {
        this.BEWNR = BEWNR;
    }

    public void setVOID(long VOID) {
        this.VOID = VOID;
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
        if (VOID != that.VOID) return false;
        if (BDAT != null ? !BDAT.equals(that.BDAT) : that.BDAT != null) return false;
        return BEWNR != null ? BEWNR.equals(that.BEWNR) : that.BEWNR == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (bewilligungs_id ^ (bewilligungs_id >>> 32));
        result = 31 * result + (BDAT != null ? BDAT.hashCode() : 0);
        result = 31 * result + (BEWNR != null ? BEWNR.hashCode() : 0);
        result = 31 * result + (int) (VOID ^ (VOID >>> 32));
        return result;
    }
}
