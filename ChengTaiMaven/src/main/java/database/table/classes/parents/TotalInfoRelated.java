package database.table.classes.parents;

import database.table.classes.TotalInfo;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public abstract class TotalInfoRelated {

    //@OneToMany(mappedBy = "pod",
      //      cascade = CascadeType.ALL)   // Tell Hibernate this is mapped by the attribute with '@JoinColumn' annotation
    protected List<TotalInfo> totalInfos;     // This isn't the real column in the database.table
    // need setter and getter


    public List<TotalInfo> getTotalInfos() {
        return totalInfos;
    }

    public void setTotalInfos(List<TotalInfo> totalInfos) {
        this.totalInfos = totalInfos;
    }


    /* help setup the bi-directional relationship */
    public void add(TotalInfo newInfo){
        if(newInfo==null)
            this.totalInfos = new ArrayList<TotalInfo>();

        this.totalInfos.add(newInfo);

        setThis(newInfo);
    }

    protected abstract void setThis(TotalInfo t);

}
