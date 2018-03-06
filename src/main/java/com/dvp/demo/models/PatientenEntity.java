package com.dvp.demo.models;
import javax.persistence.*;

@Entity
@Table(name = "Patienten", schema = "dvpdatabase")
public class PatientenEntity { //Serializable?


    public PatientenId id;

    private String VONAP;
    private String ZUNAP;
    private String STRA;
    private int PLZL;
    private String ORT;
    private String LAND;
    private int KOSTENTRAEGER;

    private long VSNRA;
    private String VONVS;
    private String ZUNVS;

    @EmbeddedId
    public PatientenId getId() {
        return id;
    }

    public void setId(PatientenId id) {
        this.id = id;
    }

    @Basic
    @Column(name = "VONAP")
    public String getVONAP() {
        return VONAP;
    }

    public void setVONAP(String VONAP) {
        this.VONAP = VONAP;
    }

    //not null
    @Column(name = "ZUNAP")
    public String getZUNAP() {
        return ZUNAP;
    }

    public void setZUNAP(String ZUNAP) {
        this.ZUNAP = ZUNAP;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "STRA")
    public String getSTRA() {
        return STRA;
    }

    public void setSTRA(String STRA) {
        this.STRA = STRA;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "PLZL")
    public int getPLZL() {
        return PLZL;
    }

    public void setPLZL(int PLZL) {
        this.PLZL = PLZL;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "ORT")
    public String getORT() {
        return ORT;
    }

    public void setORT(String ORT) {
        this.ORT = ORT;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "LAND")
    public String getLAND() {
        return LAND;
    }

    public void setLAND(String LAND) {
        this.LAND = LAND;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "kostentraeger_id")
    public int getKOSTENTRAEGER() {
        return KOSTENTRAEGER;
    }

    public void setKOSTENTRAEGER(int KOSTENTRAEGER) {
        this.KOSTENTRAEGER = KOSTENTRAEGER;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "VSNRA")
    public long getVSNRA() {
        return VSNRA;
    }

    public void setVSNRA(long VSNRA) {
        this.VSNRA = VSNRA;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "VONVS")
    public String getVONVS() {
        return VONVS;
    }

    public void setVONVS(String VONVS) {
        this.VONVS = VONVS;
    }

    @Basic //Null oder nicht, so schon
    @Column(name = "ZUNVS")
    public String getZUNVS() {
        return ZUNVS;
    }

    public void setZUNVS(String ZUNVS) {
        this.ZUNVS = ZUNVS;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientenEntity that = (PatientenEntity) o;

        if (PLZL != that.PLZL) return false;
        if (KOSTENTRAEGER != that.KOSTENTRAEGER) return false;
        if (VSNRA != that.VSNRA) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (VONAP != null ? !VONAP.equals(that.VONAP) : that.VONAP != null) return false;
        if (ZUNAP != null ? !ZUNAP.equals(that.ZUNAP) : that.ZUNAP != null) return false;
        if (STRA != null ? !STRA.equals(that.STRA) : that.STRA != null) return false;
        if (ORT != null ? !ORT.equals(that.ORT) : that.ORT != null) return false;
        if (LAND != null ? !LAND.equals(that.LAND) : that.LAND != null) return false;
        if (VONVS != null ? !VONVS.equals(that.VONVS) : that.VONVS != null) return false;
        return ZUNVS != null ? ZUNVS.equals(that.ZUNVS) : that.ZUNVS == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (VONAP != null ? VONAP.hashCode() : 0);
        result = 31 * result + (ZUNAP != null ? ZUNAP.hashCode() : 0);
        result = 31 * result + (STRA != null ? STRA.hashCode() : 0);
        result = 31 * result + PLZL;
        result = 31 * result + (ORT != null ? ORT.hashCode() : 0);
        result = 31 * result + (LAND != null ? LAND.hashCode() : 0);
        result = 31 * result + KOSTENTRAEGER;
        result = 31 * result + (int) (VSNRA ^ (VSNRA >>> 32));
        result = 31 * result + (VONVS != null ? VONVS.hashCode() : 0);
        result = 31 * result + (ZUNVS != null ? ZUNVS.hashCode() : 0);
        return result;
    }
}
