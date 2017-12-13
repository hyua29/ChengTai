package database.table.classes;

import database.table.classes.parents.DataClassInterface;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="PODs")  // Table this entity goes to
public class POD implements DataClassInterface {

    @Id
    @Column(name = "pods")
    private String PODName;
    @Column(name = "countries")
    private String country;

    public POD() {}

    public POD(String newPOD) {this.PODName = newPOD;}


    public String getPODName() {
        return PODName;
    }

    public void setPODName(String PODName) {
        //this.PODName = PODName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country.toUpperCase();
    }

    @Override
    public String toString() {
        return this.PODName + "\n" + this.country;
    }

    public String getClassName() {
        return "POD";
    }
}
