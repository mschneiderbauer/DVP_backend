package com.dvp.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PatientenId implements Serializable{

    private long VSNRP;
    
    private long kundennummer;

    public PatientenId(){
    }

    public PatientenId(long VSNRP, long kundennummer) {  //hier von String umwandeln?
        this.VSNRP = VSNRP;
        this.kundennummer = kundennummer;
    }

    @Column(name = "VSNRP")
    public long getVSNRP() {
        return VSNRP;
    }

    @Column(name = "kundennummer")
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

        if (VSNRP != that.VSNRP) return false;
        return kundennummer == that.kundennummer;
    }

    @Override
    public int hashCode() {
        int result = (int) (VSNRP ^ (VSNRP >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        return result;
    }
}
