package com.dvp.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Verordnungen", schema = "dvpdatabase", catalog = "")
public class VerordnungEntity {

    @EmbeddedId
    public VerordnungId id;

    private String KOSTENTRAEGER;
    private String VPNRV;
    private String ZUNAV;
    private Date VDATUM;

    @OneToMany
    private List<DiagnoseEntity> diagnosen;

    @OneToMany
    private List<LeistungEntity> leistungen;

    @OneToMany
    private List<BewilligungEntity>bewilligungen;

    @OneToMany(mappedBy = "Verordnungen")
    private List<LeistungserbringungEntity>leistungserbringungen;

    public VerordnungId getId() {
        return id;
    }

    public String getKOSTENTRAEGER() {
        return KOSTENTRAEGER;
    }

    public void setKOSTENTRAEGER(String KOSTENTRAEGER) {
        this.KOSTENTRAEGER = KOSTENTRAEGER;
    }

    public String getVPNRV() {
        return VPNRV;
    }

    public void setVPNRV(String VPNRV) {
        this.VPNRV = VPNRV;
    }

    public String getZUNAV() {
        return ZUNAV;
    }

    public void setZUNAV(String ZUNAV) {
        this.ZUNAV = ZUNAV;
    }

    public Date getVDATUM() {
        return VDATUM;
    }

    public void setVDATUM(Date VDATUM) {
        this.VDATUM = VDATUM;
    }

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
    }
}
