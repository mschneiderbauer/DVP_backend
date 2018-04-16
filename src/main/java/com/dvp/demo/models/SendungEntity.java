package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Sendungen", schema = "dvpdatabase", catalog = "")
public class SendungEntity {
    
    SendungId id;

    private String periode;

    @EmbeddedId
    public SendungId getId() {
        return id;
    }

    public void setId(SendungId id) {
        this.id = id;
    }



    @Basic
    @Column(name = "periode")
    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendungEntity that = (SendungEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return periode != null ? periode.equals(that.periode) : that.periode == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (periode != null ? periode.hashCode() : 0);
        return result;
    }
}
