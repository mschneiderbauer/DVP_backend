package com.dvp.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "kostentraeger", schema = "dvpdatabase")
public class KostentraegerEntity {

    private int kostentraeger_id;
    private String kostentraeger_name;

    public KostentraegerEntity() {
    }

    public KostentraegerEntity(int kostentraeger_id, String kostentraeger_name) {
        this.kostentraeger_id = kostentraeger_id;
        this.kostentraeger_name = kostentraeger_name;
    }

    @Id
    public int getKostentraeger_id() {
        return kostentraeger_id;
    }

    public void setKostentraeger_id(int kostentraeger_id) {
        this.kostentraeger_id = kostentraeger_id;
    }

    public String getKostentraeger_name() {
        return kostentraeger_name;
    }

    public void setKostentraeger_name(String kostentraeger_name) {
        this.kostentraeger_name = kostentraeger_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KostentraegerEntity that = (KostentraegerEntity) o;

        if (kostentraeger_id != that.kostentraeger_id) return false;
        return kostentraeger_name != null ? kostentraeger_name.equals(that.kostentraeger_name) : that.kostentraeger_name == null;
    }

    @Override
    public int hashCode() {
        int result = kostentraeger_id;
        result = 31 * result + (kostentraeger_name != null ? kostentraeger_name.hashCode() : 0);
        return result;
    }
}
