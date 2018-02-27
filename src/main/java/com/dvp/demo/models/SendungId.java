package com.dvp.demo.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SendungId implements Serializable{
    @Column(name = "sendung_id")
    private long id;
    private long kundennummer;

    public SendungId(long id, long kundennummer) {
        this.id = id;
        this.kundennummer = kundennummer;
    }

    public SendungId() {
    }

    public long getId() {
        return id;
    }

    public long getKundennummer() {
        return kundennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendungId sendungId = (SendungId) o;

        if (id != sendungId.id) return false;
        return kundennummer == sendungId.kundennummer;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        return result;
    }
}
