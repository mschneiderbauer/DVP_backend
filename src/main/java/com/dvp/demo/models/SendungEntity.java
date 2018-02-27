package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Sendungen", schema = "dvpdatabase", catalog = "")
public class SendungEntity {
    @EmbeddedId
    SendungId id;

    private String periode;

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
}
