package com.dvp.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class VerordnungId implements Serializable{

    @Column(name = "VOID")
    private int VOID;

    @Column(name = "kundennummer")
    private int kundennummer;

    public VerordnungId() {
    }

    public VerordnungId(int VOID, int kundennummer) {
        this.VOID = VOID;
        this.kundennummer = kundennummer;
    }

    public int getVOID() {
        return VOID;
    }

    public int getKundennummer() {
        return kundennummer;
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
        int result = VOID;
        result = 31 * result + kundennummer;
        return result;
    }
}
