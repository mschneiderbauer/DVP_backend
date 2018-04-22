package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Verordnungen", schema = "dvpdatabase")
public class VerordnungEntity {

    public long vo_id;

    private long kundennummer;

    private int kostentraeger_id;
    private long VPNRV;
    private String ZUNAV;
    private Date VDATUM;

    private long vsnrp;

    private long sendungid;


    public VerordnungEntity() {
    }

    public VerordnungEntity(long vo_id, long kundennummer, int KOSTENTRAEGER_ID, long VPNRV, String ZUNAV, Date VDATUM, long vsnrp) {
        this.vo_id = vo_id;
        this.kundennummer = kundennummer;
        this.kostentraeger_id = KOSTENTRAEGER_ID;
        this.VPNRV = VPNRV;
        this.ZUNAV = ZUNAV;
        this.VDATUM = VDATUM;
        this.vsnrp = vsnrp;
    }

    @Id
    @Column(name = "VO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getVo_id() {
        return vo_id;
    }

    public void setVo_id(long vo_id) {
        this.vo_id = vo_id;
    }

    @Column(name = "kundennummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
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
    public int getKostentraeger_id() {
        return kostentraeger_id;
    }


    public void setKostentraeger_id(int KOSTENTRAEGER_ID) {
        this.kostentraeger_id = KOSTENTRAEGER_ID;
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

        if (vo_id != that.vo_id) return false;
        if (kundennummer != that.kundennummer) return false;
        if (kostentraeger_id != that.kostentraeger_id) return false;
        if (VPNRV != that.VPNRV) return false;
        if (vsnrp != that.vsnrp) return false;
        if (sendungid != that.sendungid) return false;
        if (ZUNAV != null ? !ZUNAV.equals(that.ZUNAV) : that.ZUNAV != null) return false;
        return VDATUM != null ? VDATUM.equals(that.VDATUM) : that.VDATUM == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (vo_id ^ (vo_id >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + kostentraeger_id;
        result = 31 * result + (int) (VPNRV ^ (VPNRV >>> 32));
        result = 31 * result + (ZUNAV != null ? ZUNAV.hashCode() : 0);
        result = 31 * result + (VDATUM != null ? VDATUM.hashCode() : 0);
        result = 31 * result + (int) (vsnrp ^ (vsnrp >>> 32));
        result = 31 * result + (int) (sendungid ^ (sendungid >>> 32));
        return result;
    }
}
