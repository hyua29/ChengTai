package database.table.classes;


import database.table.classes.parents.DataClassInterface;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="CARRIERS")  // Table this entity goes to
public class Carrier implements DataClassInterface{

    @Id
    @Column(name = "carriers")
    private String carrierName;

    public Carrier(){}

    public Carrier(String carrierName){this.carrierName = carrierName;}

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    @Override
    public String toString() {
        return this.carrierName;
    }

    public String getClassName() {
        return "Carrier";
    }
}
