package com.dvp.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LeistungserbringerId implements Serializable{
    @Column(name = "vpnr")
    private String VPNR;
    @Column(name = "kundennummer")
    private long kundennummer;

    public LeistungserbringerId(String VPNR, long kundennummer) {
        this.VPNR = VPNR;
        this.kundennummer = kundennummer;
    }

    public LeistungserbringerId() {
    }

    public String getVPNR() {
        return VPNR;
    }

    public long getKundennummer() {
        return kundennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungserbringerId that = (LeistungserbringerId) o;

        if (kundennummer != that.kundennummer) return false;
        return VPNR.equals(that.VPNR);
    }

    @Override
    public int hashCode() {
        int result = VPNR.hashCode();
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        return result;
    }
}
