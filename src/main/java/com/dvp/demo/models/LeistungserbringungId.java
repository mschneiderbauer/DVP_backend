package com.dvp.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class LeistungserbringungId implements Serializable {
    @Column(name = "post_id")
    private int VOID;

    @Column(name = "tag_id")
    private String VPNRT;

    public LeistungserbringungId() {
    }

    public LeistungserbringungId(int VOID, String VPNRT) {
        this.VOID = VOID;
        this.VPNRT = VPNRT;
    }

    public int getVOID() {
        return VOID;
    }

    public String getVPNRT() {
        return VPNRT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungserbringungId that = (LeistungserbringungId) o;

        if (VOID != that.VOID) return false;
        return VPNRT != null ? VPNRT.equals(that.VPNRT) : that.VPNRT == null;
    }

    @Override
    public int hashCode() {
        int result = VOID;
        result = 31 * result + (VPNRT != null ? VPNRT.hashCode() : 0);
        return result;
    }
}
