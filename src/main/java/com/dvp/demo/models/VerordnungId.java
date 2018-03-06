package com.dvp.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class VerordnungId implements Serializable{


    private long VOID;


    private long kundennummer;

    public VerordnungId() {
    }

    public VerordnungId(long VOID, long kundennummer) {
        this.VOID = VOID;
        this.kundennummer = kundennummer;
    }

    @Column(name = "VOID")
    public long getVOID() {
        return VOID;
    }

    @Column(name = "kundennummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public void setVOID(long VOID) {
        this.VOID = VOID;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerordnungId that = (VerordnungId) o;

        if (VOID != that.VOID) return false;
        return kundennummer == that.kundennummer;
    }

    @Override
    public int hashCode() {
        int result = (int) (VOID ^ (VOID >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        return result;
    }
}
