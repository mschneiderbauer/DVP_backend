package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Leistungserbringer", schema = "dvpdatabase")
public class LeistungserbringerEntity {

    public long leid;

    private long vpnrt;

    private String ZUNUT;

    private long vid;

    public LeistungserbringerEntity() {
    }

    @Id
    @Column(name = "LEID")
    public long getLeid() {
        return leid;
    }

    public void setLeid(long lid) {
        this.leid = lid;
    }

    @Column(name = "vo_id")
    public long getVid() {
        return vid;
    }

    public void setVid(long vid) {
        this.vid = vid;
    }

    @Column(name = "vpnrt")
    public long getVpnrt() {
        return vpnrt;
    }

    public void setVpnrt(long vpnrt) {
        this.vpnrt = vpnrt;
    }


    @Basic
    @Column(name = "ZUNUT")
    public String getZUNUT() {
        return ZUNUT;
    }

    public void setZUNUT(String ZUNUT) {
        this.ZUNUT = ZUNUT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungserbringerEntity that = (LeistungserbringerEntity) o;

        if (leid != that.leid) return false;
        if (vpnrt != that.vpnrt) return false;
        if (vid != that.vid) return false;
        return ZUNUT != null ? ZUNUT.equals(that.ZUNUT) : that.ZUNUT == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (leid ^ (leid >>> 32));
        result = 31 * result + (int) (vpnrt ^ (vpnrt >>> 32));
        result = 31 * result + (ZUNUT != null ? ZUNUT.hashCode() : 0);
        result = 31 * result + (int) (vid ^ (vid >>> 32));
        return result;
    }
}
