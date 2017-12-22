package database.data.tables;


import javax.persistence.Column;

//@javax.persistence.Entity  //This is an entity that that can be mapped to database
//@javax.persistence.Table(name="COMPANY_INFO")  // Table this entity goes to
public class CompanyInfo  {

    @Column(name = "carriers")
    private String carrier;
    @Column(name = "source_harbor")
    private String sourceHarbor;
    @Column(name = "free_time")
    private String freeTime;
    @Column(name = "rent")
    private String rent;

    public CompanyInfo() {}

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getSourceHarbor() {
        return sourceHarbor;
    }

    public void setSourceHarbor(String sourceHarbor) {
        this.sourceHarbor = sourceHarbor;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }



    @Override
    public String toString() {
        return "CompanyInfo{" +
                "carrier='" + carrier + '\'' +
                ", sourceHarbor='" + sourceHarbor + '\'' +
                ", freeTime='" + freeTime + '\'' +
                ", rent='" + rent + '\'' +
                '}';
    }
}
