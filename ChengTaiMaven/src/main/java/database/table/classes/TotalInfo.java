package database.table.classes;

import database.table.classes.parents.DataClassInterface;

import javax.persistence.*;
import java.util.Date;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="TOTAL_INFO")  // Table this entity goes to
public class TotalInfo implements DataClassInterface {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pods")  // This is the column name of this database.table, meaning that this is the column used to join
    private String pod;
    @Column(name = "source_harbors")
    private String sourceHarbor;
    @Column(name = "carriers")
    private String carrier;
    @Column(name = "countries")
    private String country;
    @Column(name = "IMP_info")
    private String impInfo;
    @Column(name = "20GQ")
    private int gq20;
    @Column(name = "40GQ")
    private int gq40;
    @Column(name = "40HQ")
    private int hq40;
    @Column(name = "remark")
    private String remark;
    @Column(name = "feeder")
    private String feeder;
    @Column(name = "HK_CLS")
    private String HKCLS;
    @Column(name = "ETP_HK")
    private String ETPHK;
    @Column(name = "TT")
    private String TT;
    @Column(name = "extra_info")
    private String extraInfo;
    @Column(name = "created_at")
    private Date createdAt=null;
    @Column(name = "last_modified")
    private Date lastModified=null;

    public TotalInfo() {
    }

    public TotalInfo(String impInfo, int gq20, int gq40, int hq40, String remark,
                     String feeder, String HKCLS, String ETPHK, String TT, String extraInfo) {
        this.carrier = carrier;
        this.impInfo = impInfo;
        this.gq20 = gq20;
        this.gq40 = gq40;
        this.hq40 = hq40;
        this.remark = remark;
        this.feeder = feeder;
        this.HKCLS = HKCLS;
        this.ETPHK = ETPHK;
        this.TT = TT;
        this.extraInfo = extraInfo;
    }

    /*
    setters and getters are used to retrieve/push data from/to jsp page(not hibernate   )
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod.toUpperCase();
    }

    public String getSourceHarbor() {
        return sourceHarbor;
    }

    public void setSourceHarbor(String sourceHarbor) {
        this.sourceHarbor = sourceHarbor.toUpperCase();
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier.toUpperCase();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country.toUpperCase();
    }

    public String getImpInfo() {
        return impInfo;
    }

    public void setImpInfo(String impInfo) {
        this.impInfo = impInfo;
    }

    public int getGq20() {
        return gq20;
    }

    public void setGq20(int gq20) {
        this.gq20 = gq20;
    }

    public int getGq40() {
        return gq40;
    }

    public void setGq40(int gq40) {
        this.gq40 = gq40;
    }

    public int getHq40() {
        return hq40;
    }

    public void setHq40(int hq40) {
        this.hq40 = hq40;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFeeder() {
        return feeder;
    }

    public void setFeeder(String feeder) {
        this.feeder = feeder;
    }

    public String getHKCLS() {
        return HKCLS;
    }

    public void setHKCLS(String HKCLS) {
        this.HKCLS = HKCLS;
    }

    public String getETPHK() {
        return ETPHK;
    }

    public void setETPHK(String ETPHK) {
        this.ETPHK = ETPHK;
    }

    public String getTT() {
        return TT;
    }

    public void setTT(String TT) {
        this.TT = TT;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    /*
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    */

    /*
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    */
    @Override
    public String toString() {
        return "TotalInfo{" + "\n" +
                "pod='" + pod + '\'' +
                ", \nsourceHarbor='" + sourceHarbor + '\'' +
                ", \ncarrier='" + carrier + '\'' +
                ", \ncountry='" + country + '\'' +
                ", \nimpInfo='" + impInfo + '\'' +
                ", \ngq20=" + gq20 +
                ", \ngq40=" + gq40 +
                ", \nhq40=" + hq40 +
                ", \nremark='" + remark + '\'' +
                ", \nfeeder='" + feeder + '\'' +
                ", \nHKCLS='" + HKCLS + '\'' +
                ", \nETPHK='" + ETPHK + '\'' +
                ", \nTT='" + TT + '\'' +
                ", \nextraInfo='" + extraInfo + '\'' +
                ", \ncreated at ='" + createdAt + '\'' +
                ", \nlast modified='" + lastModified + '\'' +
                ", \nID='" + id + '\'' +
                '}' + "\n----------------------------------";
    }

    public String getClassName() {
        return "TotalInfo";
    }
}
