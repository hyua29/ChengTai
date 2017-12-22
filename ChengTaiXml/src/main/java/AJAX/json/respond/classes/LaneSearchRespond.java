package AJAX.json.respond.classes;

import AJAX.View;
import AJAX.json.respond.parents.AJAXRespond;
import com.fasterxml.jackson.annotation.JsonView;
import database.data.tables.POD;
import database.data.tables.SourceHarbor;

import java.util.List;


public class LaneSearchRespond {

    @JsonView(View.Public.class)
    private AJAXRespond<POD> podAJAXRespond = new AJAXRespond();

    @JsonView(View.Public.class)
    private AJAXRespond<SourceHarbor> sourceHarborAJAXRespond = new AJAXRespond();

    public void setPODList(List<POD> podList) {

        podAJAXRespond.setDataList(podList);
    }

    public void setHarborList(List<SourceHarbor> harborList) {

        sourceHarborAJAXRespond.setDataList(harborList);
    }


}
