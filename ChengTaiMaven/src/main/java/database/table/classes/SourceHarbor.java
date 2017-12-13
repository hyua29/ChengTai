package database.table.classes;

import database.table.classes.parents.DataClassInterface;

import javax.persistence.Column;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="SOURCE_HARBOR")  // Table this entity goes to
public class SourceHarbor implements DataClassInterface {

    @Column(name="source_harbor")
    private String sourceHarborName;

    public SourceHarbor(){}

    public String getSourceHarborName() {
        return sourceHarborName;
    }

    public void setSourceHarborName(String sourceHarborName) {
        this.sourceHarborName = sourceHarborName;
    }



    @Override
    public String toString() {
        return "SourceHarbor{" +
                "sourceHarborName='" + sourceHarborName + '\'' +
                '}';
    }

    public String getClassName() {
        return "SourceHarbor";
    }
}
