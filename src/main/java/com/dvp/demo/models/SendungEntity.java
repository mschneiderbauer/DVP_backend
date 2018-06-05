package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Sendungen", schema = "dvpdatabase")
public class SendungEntity {

    private String periode;
    private long kundennummer;

    private int abgeschlossen;

    public SendungEntity() {
    }

    public SendungEntity(String periode, long kundennummer) {
        this.periode = periode;
        this.kundennummer = kundennummer;
        this.abgeschlossen = 0;
    }

    @Column(name = "kundennummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    @Id
    @Column(name = "periode")
    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    @Basic
    @Column(name = "abgeschlossen")
    public int getAbgeschlossen() {
        return abgeschlossen;
    }

    public void setAbgeschlossen(int abgeschlossen) {
        this.abgeschlossen = abgeschlossen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendungEntity that = (SendungEntity) o;

        if (kundennummer != that.kundennummer) return false;
        if (abgeschlossen != that.abgeschlossen) return false;
        return periode != null ? periode.equals(that.periode) : that.periode == null;
    }

    @Override
    public int hashCode() {
        int result = periode != null ? periode.hashCode() : 0;
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + abgeschlossen;
        return result;
    }
}
