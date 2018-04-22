package com.dvp.demo.models;
import javax.persistence.*;

@Entity
@Table(name = "Patienten", schema = "dvpdatabase")
public class PatientenEntity { //Serializable?


    public long vsnrp;

    private long kundennummer;

    private String vonap;
    private String zunap;
    private String stra;
    private int plzl;
    private String ort;
    private String land;
    private int kostentraeger_id;

    private long vsnra;
    private String vonvs;
    private String zunvs;


    public PatientenEntity() {
    }

    @Column(name = "kundennummer")
    public long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
    }

    @Id
    @Column(name = "VSNRP")
    public long getVsnrp() {
        return vsnrp;
    }

    public void setVsnrp(long VSNRP) {
        this.vsnrp = VSNRP;
    }

    @Basic
    @Column(name = "VONAP")
    public String getVonap() {
        return vonap;
    }

    public void setVonap(String VONAP) {
        this.vonap = VONAP;
    }

    //not null
    @Column(name = "ZUNAP")
    public String getZunap() {
        return zunap;
    }

    public void setZunap(String ZUNAP) {
        this.zunap = ZUNAP;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "STRA")
    public String getStra() {
        return stra;
    }

    public void setStra(String STRA) {
        this.stra = STRA;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "PLZL")
    public int getPlzl() {
        return plzl;
    }

    public void setPlzl(int PLZL) {
        this.plzl = PLZL;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "ORT")
    public String getOrt() {
        return ort;
    }

    public void setOrt(String ORT) {
        this.ort = ORT;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "LAND")
    public String getLand() {
        return land;
    }

    public void setLand(String LAND) {
        this.land = LAND;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "kostentraeger_id")
    public int getKostentraeger_id() {
        return kostentraeger_id;
    }

    public void setKostentraeger_id(int KOSTENTRAEGER) {
        this.kostentraeger_id = KOSTENTRAEGER;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "VSNRA")
    public long getVsnra() {
        return vsnra;
    }

    public void setVsnra(long VSNRA) {
        this.vsnra = VSNRA;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "VONVS")
    public String getVonvs() {
        return vonvs;
    }

    public void setVonvs(String VONVS) {
        this.vonvs = VONVS;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "ZUNVS")
    public String getZunvs() {
        return zunvs;
    }

    public void setZunvs(String ZUNVS) {
        this.zunvs = ZUNVS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientenEntity that = (PatientenEntity) o;

        if (vsnrp != that.vsnrp) return false;
        if (kundennummer != that.kundennummer) return false;
        if (plzl != that.plzl) return false;
        if (kostentraeger_id != that.kostentraeger_id) return false;
        if (vsnra != that.vsnra) return false;
        if (vonap != null ? !vonap.equals(that.vonap) : that.vonap != null) return false;
        if (zunap != null ? !zunap.equals(that.zunap) : that.zunap != null) return false;
        if (stra != null ? !stra.equals(that.stra) : that.stra != null) return false;
        if (ort != null ? !ort.equals(that.ort) : that.ort != null) return false;
        if (land != null ? !land.equals(that.land) : that.land != null) return false;
        if (vonvs != null ? !vonvs.equals(that.vonvs) : that.vonvs != null) return false;
        return zunvs != null ? zunvs.equals(that.zunvs) : that.zunvs == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (vsnrp ^ (vsnrp >>> 32));
        result = 31 * result + (int) (kundennummer ^ (kundennummer >>> 32));
        result = 31 * result + (vonap != null ? vonap.hashCode() : 0);
        result = 31 * result + (zunap != null ? zunap.hashCode() : 0);
        result = 31 * result + (stra != null ? stra.hashCode() : 0);
        result = 31 * result + plzl;
        result = 31 * result + (ort != null ? ort.hashCode() : 0);
        result = 31 * result + (land != null ? land.hashCode() : 0);
        result = 31 * result + kostentraeger_id;
        result = 31 * result + (int) (vsnra ^ (vsnra >>> 32));
        result = 31 * result + (vonvs != null ? vonvs.hashCode() : 0);
        result = 31 * result + (zunvs != null ? zunvs.hashCode() : 0);
        return result;
    }
}
