package database.data.tables;

import javax.persistence.Column;
import javax.persistence.Id;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="CARRIERS")  // Table this entity goes to
public class Carrier {

    @Id
    @Column(name = "carriers")
    private String carrierName;

    public Carrier(){}

    public Carrier(String carrierName){this.carrierName = carrierName;}

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName.toUpperCase();
    }

    public String getCarrierWithoutSpace() {
        return carrierName.replace(" ", "_").replace("-", "_");
    }

    @Override
    public String toString() {
        return this.carrierName;
    }

}

