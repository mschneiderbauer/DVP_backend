package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Leistungserbringer", schema = "dvpdatabase", catalog = "")
public class LeistungserbringerEntity {
    @Id
    public String VPNRT;
    private String ZUNUT;

    public LeistungserbringerEntity() {
    }

    public LeistungserbringerEntity(String VPNRT, String ZUNUT) {
        this.VPNRT = VPNRT;
        this.ZUNUT = ZUNUT;
    }

    public String getVPNRT() {
        return VPNRT;
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

        if (VPNRT != null ? !VPNRT.equals(that.VPNRT) : that.VPNRT != null) return false;
        return ZUNUT != null ? ZUNUT.equals(that.ZUNUT) : that.ZUNUT == null;
    }

    @Override
    public int hashCode() {
        int result = VPNRT != null ? VPNRT.hashCode() : 0;
        result = 31 * result + (ZUNUT != null ? ZUNUT.hashCode() : 0);
        return result;
    }
}
