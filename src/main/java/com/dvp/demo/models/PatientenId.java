package com.dvp.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PatientenId implements Serializable{

    @Column(name = "VSNRP")
    private long VSNRP;

    @Column(name = "kundennummer")
    private long kundennummer;

    public PatientenId(){
    }

    public PatientenId(long VSNRP, long kundennummer) {  //hier von String umwandeln?
        this.VSNRP = VSNRP;
        this.kundennummer = kundennummer;
    }

    public long getVSNRP() {
        return VSNRP;
    }

    public long getKundennummer() {
        return kundennummer;
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
