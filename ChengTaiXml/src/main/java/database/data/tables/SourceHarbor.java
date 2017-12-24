package database.data.tables;

import AJAX.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.mysql.management.util.Str;

import javax.persistence.Column;
import javax.persistence.Id;

@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="SOURCE_HARBORs")  // Table this entity goes to
public class SourceHarbor{

    @Id
    @Column(name="source_harbors")
    @JsonView(View.Public.class)
    private String sourceHarborName;

    public SourceHarbor(){}

    public String getSourceHarborName() {
        return sourceHarborName;
    }

    public void setSourceHarborName(String sourceHarborName) {
        this.sourceHarborName = sourceHarborName;
    }

    public String getSourceHbWithoutSpace() {
        return sourceHarborName.replace(" ", "_");
    }

    @Override
    public String toString() {
        return "SourceHarbor{" +
                "sourceHarborName='" + sourceHarborName + '\'' +
                '}';
    }

}