package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Sendungen", schema = "dvpdatabase")
public class SendungEntity {

    public long id;
    private long kundennummer;

    private String periode;

    private int abgeschlossen;

    @Id
    @Column(name = "sendung_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "kundennummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    @Basic
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

        if (id != that.id) return false;
        if (kundennummer != that.kundennummer) return false;
        if (abgeschlossen != that.abgeschlossen) return false;
        return periode != null ? periode.equals(that.periode) : that.periode == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + (periode != null ? periode.hashCode() : 0);
        result = 31 * result + abgeschlossen;
        return result;
    }
}
