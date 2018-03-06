package com.dvp.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Verordnungen", schema = "dvpdatabase")
public class VerordnungEntity {

    public VerordnungId id;

    //private String KOSTENTRAEGER;
    private long VPNRV;
    private String ZUNAV;
    private Date VDATUM;

   /* @OneToMany
    private List<DiagnoseEntity> diagnosen;

    @OneToMany
    private List<LeistungEntity> leistungen;

    @OneToMany
    private List<BewilligungEntity>bewilligungen;

    @OneToMany(mappedBy = "Verordnungen")
    private List<LeistungserbringungEntity>leistungserbringungen;*/

    public VerordnungEntity() {
    }

    public VerordnungEntity(VerordnungId id, long VPNRV, String ZUNAV, Date VDATUM) {
        this.id = id;
        this.VPNRV = VPNRV;
        this.ZUNAV = ZUNAV;
        this.VDATUM = VDATUM;
    }

    @EmbeddedId
    public VerordnungId getId() {
        return id;
    }

    public void setId(VerordnungId id) {
        this.id = id;
    }

    /*public String getKOSTENTRAEGER() {
        return KOSTENTRAEGER;
    }

    public void setKOSTENTRAEGER(String KOSTENTRAEGER) {
        this.KOSTENTRAEGER = KOSTENTRAEGER;
    }*/

    @Basic
    @Column(name = "vpnrv")
    public long getVPNRV() {
        return VPNRV;
    }

    public void setVPNRV(long VPNRV) {
        this.VPNRV = VPNRV;
    }

    @Basic
    @Column(name = "zunav")
    public String getZUNAV() {
        return ZUNAV;
    }

    public void setZUNAV(String ZUNAV) {
        this.ZUNAV = ZUNAV;
    }

    @Basic
    @Column(name = "vdatum")
    @Temporal(TemporalType.DATE)
    public Date getVDATUM() {
        return VDATUM;
    }

    public void setVDATUM(Date VDATUM) {
        this.VDATUM = VDATUM;
    }


    /*

    public List<DiagnoseEntity> getDiagnosen() {
        return diagnosen;
    }

    public void setDiagnosen(List<DiagnoseEntity> diagnosen) {
        this.diagnosen = diagnosen;
    }

    public List<LeistungEntity> getLeistungen() {
        return leistungen;
    }

    public void setLeistungen(List<LeistungEntity> leistungen) {
        this.leistungen = leistungen;
    }

    public List<BewilligungEntity> getBewilligungen() {
        return bewilligungen;
    }

    public void setBewilligungen(List<BewilligungEntity> bewilligungen) {
        this.bewilligungen = bewilligungen;
    }

    public List<LeistungserbringungEntity> getLeistungserbringungen() {
        return leistungserbringungen;
    }

    public void setLeistungserbringungen(List<LeistungserbringungEntity> leistungserbringungen) {
        this.leistungserbringungen = leistungserbringungen;
    } */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerordnungEntity that = (VerordnungEntity) o;

        if (VPNRV != that.VPNRV) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ZUNAV != null ? !ZUNAV.equals(that.ZUNAV) : that.ZUNAV != null) return false;
        return VDATUM != null ? VDATUM.equals(that.VDATUM) : that.VDATUM == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int) (VPNRV ^ (VPNRV >>> 32));
        result = 31 * result + (ZUNAV != null ? ZUNAV.hashCode() : 0);
        result = 31 * result + (VDATUM != null ? VDATUM.hashCode() : 0);
        return result;
    }



}
