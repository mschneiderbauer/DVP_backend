package com.dvp.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PatientenId implements Serializable{

    @Column(name = "kundennummer")
    private long kundennummer;
    @Column(name = "VSNRP")
    private long VSNRP;

    public PatientenId(){
    }

    public PatientenId(long kundennummer, long VSNRP) {
        this.kundennummer = kundennummer;
        this.VSNRP = VSNRP;
    }

    public long getVSNRP() {
        return VSNRP;
    }

    public long getKundennummer() {
        return kundennummer;
    }

    public void setVSNRP(long VSNRP) {
        this.VSNRP = VSNRP;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientenId that = (PatientenId) o;

        if (kundennummer != that.kundennummer) return false;
        return VSNRP == that.VSNRP;
    }

    @Override
    public int hashCode() {
        int result = (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + (int) (VSNRP ^ (VSNRP >>> 32));
        return result;
    }
}
