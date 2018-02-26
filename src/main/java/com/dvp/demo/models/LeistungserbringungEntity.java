package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Leistungserbringung", schema = "dvpdatabase", catalog = "")
public class LeistungserbringungEntity {

    @EmbeddedId
    public LeistungserbringungId leistungserbringungId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("VOID")
    VerordnungEntity verordnung;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("VPNRT")
    LeistungserbringerEntity leistungserbringer;

    private Date DAT;

    public LeistungserbringungEntity(LeistungserbringerEntity leistungserbringer, VerordnungEntity verordnung, Date DAT) {
        this.leistungserbringer = leistungserbringer;
        this.verordnung = verordnung;
        this.DAT = DAT;
        this.leistungserbringungId = new LeistungserbringungId(verordnung.getId().getVOID(), leistungserbringer.getVPNRT());
    }

    public LeistungserbringungEntity() {
    }

    public LeistungserbringungId getLeistungserbringungId() {
        return leistungserbringungId;
    }

    @Basic
    @Column(name="DAT")
    public Date getDAT() {
        return DAT;
    }

    public void setDAT(Date DAT) {
        this.DAT = DAT;
    }

    public VerordnungEntity getVerordnung() {
        return verordnung;
    }

    public void setVerordnung(VerordnungEntity verordnung) {
        this.verordnung = verordnung;
    }

    public LeistungserbringerEntity getLeistungserbringer() {
        return leistungserbringer;
    }

    public void setLeistungserbringer(LeistungserbringerEntity leistungserbringer) {
        this.leistungserbringer = leistungserbringer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeistungserbringungEntity that = (LeistungserbringungEntity) o;

        if (leistungserbringungId != null ? !leistungserbringungId.equals(that.leistungserbringungId) : that.leistungserbringungId != null)
            return false;
        if (verordnung != null ? !verordnung.equals(that.verordnung) : that.verordnung != null) return false;
        if (leistungserbringer != null ? !leistungserbringer.equals(that.leistungserbringer) : that.leistungserbringer != null)
            return false;
        return DAT != null ? DAT.equals(that.DAT) : that.DAT == null;
    }

    @Override
    public int hashCode() {
        int result = leistungserbringungId != null ? leistungserbringungId.hashCode() : 0;
        result = 31 * result + (verordnung != null ? verordnung.hashCode() : 0);
        result = 31 * result + (leistungserbringer != null ? leistungserbringer.hashCode() : 0);
        result = 31 * result + (DAT != null ? DAT.hashCode() : 0);
        return result;
    }
}
