package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Sendungen", schema = "dvpdatabase")
public class SendungEntity {

    private String periode;
    private long kundennummer;

    private int status;

    private Timestamp datum;

    public SendungEntity() {
    }

    public SendungEntity(String periode, long kundennummer) {
        this.periode = periode;
        this.kundennummer = kundennummer;
        this.status = 0;
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
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "datum")
    public Timestamp getDatum() {
        return datum;
    }

    public void setDatum(Timestamp datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendungEntity that = (SendungEntity) o;

        if (kundennummer != that.kundennummer) return false;
        if (status != that.status) return false;
        if (periode != null ? !periode.equals(that.periode) : that.periode != null) return false;
        return datum != null ? datum.equals(that.datum) : that.datum == null;
    }

    @Override
    public int hashCode() {
        int result = periode != null ? periode.hashCode() : 0;
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + status;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        return result;
    }
}
