package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Verordnungen", schema = "dvpdatabase")
public class VerordnungEntity {

    public long vid;

    private long kundennummer;

    private int kostentraeger_id;
    private long vpnrv;
    private String zunav;
    private Date vdatum;

    private long vsnrp;

    private String periode;

    private int status;


    public VerordnungEntity() {
    }

    public VerordnungEntity(long vid, long kundennummer, int KOSTENTRAEGER_ID, long VPNRV, String ZUNAV, Date VDATUM, long vsnrp) {
        this.vid = vid;
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
    public long getVid() {
        return vid;
    }

    public void setVid(long vo_id) {
        this.vid = vo_id;
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
    @Column(name = "kostentraeger_id")
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

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerordnungEntity that = (VerordnungEntity) o;

        if (vid != that.vid) return false;
        if (kundennummer != that.kundennummer) return false;
        if (kostentraeger_id != that.kostentraeger_id) return false;
        if (vpnrv != that.vpnrv) return false;
        if (vsnrp != that.vsnrp) return false;
        if (status != that.status) return false;
        if (zunav != null ? !zunav.equals(that.zunav) : that.zunav != null) return false;
        if (vdatum != null ? !vdatum.equals(that.vdatum) : that.vdatum != null) return false;
        return periode != null ? periode.equals(that.periode) : that.periode == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (vid ^ (vid >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + kostentraeger_id;
        result = 31 * result + (int) (vpnrv ^ (vpnrv >>> 32));
        result = 31 * result + (zunav != null ? zunav.hashCode() : 0);
        result = 31 * result + (vdatum != null ? vdatum.hashCode() : 0);
        result = 31 * result + (int) (vsnrp ^ (vsnrp >>> 32));
        result = 31 * result + (periode != null ? periode.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
