package database.data.tables;

import AJAX.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Column;
import javax.persistence.Id;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="PODs")  // Table this entity goes to
public class POD {

    @Id
    @Column(name = "pods")
    @JsonView(View.Public.class)
    private String PODName;
    @Column(name = "countries")
    @JsonView(View.Public.class)
    private String country;

    public POD() {}

    public POD(String newPOD) {this.PODName = newPOD;}


    public String getPODName() {
        return PODName;
    }

    public void setPODName(String PODName) {
        this.PODName = PODName.toUpperCase();;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country.toUpperCase();
    }

    public String getPodNameWithoutSpace() {
        return this.getPODName().replace(" ", "_");
    }

    @Override
    public String toString() {
        return this.PODName + "\n" + this.country;
    }

}
