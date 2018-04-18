package com.dvp.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class VerordnungId implements Serializable{

    private long vo_id;

    private long kundennummer;

    public VerordnungId() {
    }

    public VerordnungId(long vo_id, long kundennummer) {
        this.vo_id = vo_id;
        this.kundennummer = kundennummer;
    }

    @Column(name = "VOID")
    public long getVo_id() {
        return vo_id;
    }

    @Column(name = "kundennummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public void setVo_id(long VOID) {
        this.vo_id = VOID;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerordnungId that = (VerordnungId) o;

        if (vo_id != that.vo_id) return false;
        return kundennummer == that.kundennummer;
    }

    @Override
    public int hashCode() {
        int result = (int) (vo_id ^ (vo_id >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        return result;
    }
}
