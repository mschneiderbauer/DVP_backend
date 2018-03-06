package com.dvp.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LeistungserbringerId implements Serializable{
  
    private long VPNR;
    
    private long kundennummer;

    public LeistungserbringerId(long VPNR, long kundennummer) {
        this.VPNR = VPNR;
        this.kundennummer = kundennummer;
    }

    public LeistungserbringerId() {
    }

@Column(name = "vpnr")
    public long getVPNR() {
        return VPNR;
    }
@Column(name = "kundennummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public void setVPNR(long VPNR) {
        this.VPNR = VPNR;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungserbringerId that = (LeistungserbringerId) o;

        if (VPNR != that.VPNR) return false;
        return kundennummer == that.kundennummer;
    }

    @Override
    public int hashCode() {
        int result = (int) (VPNR ^ (VPNR >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        return result;
    }
}
