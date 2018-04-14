package database.data.tables;

import AJAX.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="TOTAL_INFO")  // Table this entity goes to
public class TotalInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private int id;

    @Column(name = "pods")  // This is the column name of this database.table, meaning that this is the column used to join
    @JsonView(View.Public.class)
    private String pod;
    @Column(name = "source_harbors")
    @JsonView(View.Public.class)
    private String sourceHarbor;
    @Column(name = "carriers")
    @JsonView(View.Public.class)
    private String carrier;
    @Column(name = "countries")
    @JsonView(View.Public.class)
    private String country;
    @Column(name = "IMP_info")
    @JsonView(View.Public.class)
    private String impInfo;
    @Column(name = "20GQ")
    @JsonView(View.Public.class)
    private int gq20;
    @Column(name = "40GQ")
    @JsonView(View.Public.class)
    private int gq40;
    @Column(name = "40HQ")
    @JsonView(View.Public.class)
    private int hq40;
    @Column(name = "remark")
    @JsonView(View.Public.class)
    private String remark;
    @Column(name = "feeder")
    @JsonView(View.Public.class)
    private String feeder;
    @Column(name = "HK_CLS")
    @JsonView(View.Public.class)
    private String HKCLS;
    @Column(name = "ETP_HK")
    @JsonView(View.Public.class)
    private String ETPHK;
    @Column(name = "TT")
    @JsonView(View.Public.class)
    private String TT;
    @Column(name = "extra_info")
    @JsonView(View.Public.class)
    private String extraInfo;
    @Column(name = "created_at")
    @JsonView(View.Public.class)
    private Date createdAt;
    @Column(name = "last_modified")
    @JsonView(View.Public.class)
    private Date lastModified;
    @Column(name = "excel_row")
    @JsonView(View.Public.class)
    private int rowNumber;

    public TotalInfo() {
        this.pod = "";
        this.sourceHarbor = "";
        this.carrier = "";
        this.country = "";
        this.createdAt = new Date();
        this.lastModified = new Date();
    }

    public TotalInfo(String pod, String harbor, String carrier, String country) {
        this.pod = pod;
        this.sourceHarbor = harbor;
        this.carrier = carrier;
        this.country = country;
    }

    /*
    setters and getters are used to retrieve/push data from/to jsp page(not hibernate   )
     */

    public int getId() {
        return id;
    }

    public String getPod() {
        return pod.toUpperCase();
    }

    public void setPod(String pod) {
        this.pod = pod.toUpperCase();
    }

    public String getSourceHarbor() {
        return sourceHarbor.toUpperCase();
    }

    public void setSourceHarbor(String sourceHarbor) {
        this.sourceHarbor = sourceHarbor.toUpperCase();
    }

    public String getCarrier() {
        return carrier.toUpperCase();
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier.toUpperCase();
    }

    public String getCountry() {
        return country.toUpperCase();
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

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

}
