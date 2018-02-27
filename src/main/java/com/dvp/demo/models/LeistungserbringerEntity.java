package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Leistungserbringer", schema = "dvpdatabase", catalog = "")
public class LeistungserbringerEntity {
    @EmbeddedId
    public LeistungserbringerId erbringer_id;

    private String ZUNUT;

    public LeistungserbringerEntity() {
    }

    public LeistungserbringerId getErbringer_id() {
        return erbringer_id;
    }

    public void setErbringer_id(LeistungserbringerId erbringer_id) {
        this.erbringer_id = erbringer_id;
    }

    @Basic
    @Column(name = "ZUNUT")
    public String getZUNUT() {
        return ZUNUT;
    }

    public void setZUNUT(String ZUNUT) {
        this.ZUNUT = ZUNUT;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungserbringerEntity that = (LeistungserbringerEntity) o;

        if (!erbringer_id.equals(that.erbringer_id)) return false;
        return ZUNUT.equals(that.ZUNUT);
    }

    @Override
    public int hashCode() {
        int result = erbringer_id.hashCode();
        result = 31 * result + ZUNUT.hashCode();
        return result;
    }
}
