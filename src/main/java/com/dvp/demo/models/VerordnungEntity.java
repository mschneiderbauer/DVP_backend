package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Verordnungen", schema = "dvpdatabase")
public class VerordnungEntity {

    public long vo_id;

    private long kundennummer;

    private int kostentraeger_id;
    private long vpnrv;
    private String zunav;
    private Date vdatum;

    private long vsnrp;

    private long sendungid;


    public VerordnungEntity() {
    }

    public VerordnungEntity(long vo_id, long kundennummer, int KOSTENTRAEGER_ID, long VPNRV, String ZUNAV, Date VDATUM, long vsnrp) {
        this.vo_id = vo_id;
        this.kundennummer = kundennummer;
        this.kostentraeger_id = KOSTENTRAEGER_ID;
        this.vpnrv = VPNRV;
        this.zunav = ZUNAV;
        this.vdatum = VDATUM;
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
    public long getVpnrv() {
        return vpnrv;
    }

    public void setVpnrv(long VPNRV) {
        this.vpnrv = VPNRV;
    }

    @Basic
    @Column(name = "zunav")
    public String getZunav() {
        return zunav;
    }

    public void setZunav(String ZUNAV) {
        this.zunav = ZUNAV;
    }

    @Basic
    @Column(name = "vdatum")
    public Date getVdatum() {
        return vdatum;
    }

    public void setVdatum(Date VDATUM) {
        this.vdatum = VDATUM;
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
        if (vpnrv != that.vpnrv) return false;
        if (vsnrp != that.vsnrp) return false;
        if (sendungid != that.sendungid) return false;
        if (zunav != null ? !zunav.equals(that.zunav) : that.zunav != null) return false;
        return vdatum != null ? vdatum.equals(that.vdatum) : that.vdatum == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (vo_id ^ (vo_id >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + kostentraeger_id;
        result = 31 * result + (int) (vpnrv ^ (vpnrv >>> 32));
        result = 31 * result + (zunav != null ? zunav.hashCode() : 0);
        result = 31 * result + (vdatum != null ? vdatum.hashCode() : 0);
        result = 31 * result + (int) (vsnrp ^ (vsnrp >>> 32));
        result = 31 * result + (int) (sendungid ^ (sendungid >>> 32));
        return result;
    }
}
