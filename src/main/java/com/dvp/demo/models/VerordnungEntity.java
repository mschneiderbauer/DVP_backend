package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Verordnungen", schema = "dvpdatabase")
public class VerordnungEntity {

    public VerordnungId id;

    private int KOSTENTRAEGER_ID;
    private long VPNRV;
    private String ZUNAV;
    private Date VDATUM;

    private long vsnrp;

    private long sendungid;


    public VerordnungEntity() {
    }

    public VerordnungEntity(VerordnungId id, long VPNRV, String ZUNAV, Date VDATUM) {
        this.id = id;
        this.VPNRV = VPNRV;
        this.ZUNAV = ZUNAV;
        this.VDATUM = VDATUM;
    }

    @EmbeddedId
    public VerordnungId getId() {
        return id;
    }

    public void setId(VerordnungId id) {
        this.id = id;
    }


    @Basic
    @Column(name = "vpnrv")
    public long getVPNRV() {
        return VPNRV;
    }

    public void setVPNRV(long VPNRV) {
        this.VPNRV = VPNRV;
    }

    @Basic
    @Column(name = "zunav")
    public String getZUNAV() {
        return ZUNAV;
    }

    public void setZUNAV(String ZUNAV) {
        this.ZUNAV = ZUNAV;
    }

    @Basic
    @Column(name = "vdatum")
    public Date getVDATUM() {
        return VDATUM;
    }

    public void setVDATUM(Date VDATUM) {
        this.VDATUM = VDATUM;
    }

    @Basic
    public int getKOSTENTRAEGER_ID() {
        return KOSTENTRAEGER_ID;
    }


    public void setKOSTENTRAEGER_ID(int KOSTENTRAEGER_ID) {
        this.KOSTENTRAEGER_ID = KOSTENTRAEGER_ID;
    }

    public long getVsnrp() {
        return vsnrp;
    }

    public void setVsnrp(long VSNRP) {
        this.vsnrp = VSNRP;
    }

    public long getSendungid() {
        return sendungid;
    }

    public void setSendungid(long sendung_id) {
        this.sendungid = sendung_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerordnungEntity that = (VerordnungEntity) o;

        if (KOSTENTRAEGER_ID != that.KOSTENTRAEGER_ID) return false;
        if (VPNRV != that.VPNRV) return false;
        if (vsnrp != that.vsnrp) return false;
        if (sendungid != that.sendungid) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ZUNAV != null ? !ZUNAV.equals(that.ZUNAV) : that.ZUNAV != null) return false;
        return VDATUM != null ? VDATUM.equals(that.VDATUM) : that.VDATUM == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + KOSTENTRAEGER_ID;
        result = 31 * result + (int) (VPNRV ^ (VPNRV >>> 32));
        result = 31 * result + (ZUNAV != null ? ZUNAV.hashCode() : 0);
        result = 31 * result + (VDATUM != null ? VDATUM.hashCode() : 0);
        result = 31 * result + (int) (vsnrp ^ (vsnrp >>> 32));
        result = 31 * result + (int) (sendungid ^ (sendungid >>> 32));
        return result;
    }
}
