package web.config.servlet;

import AJAX.View;
import AJAX.json.request.LaneSearch;
import AJAX.json.respond.classes.LaneSearchRespond;
import com.fasterxml.jackson.annotation.JsonView;
import database.data.access.services.AJAXServices;
import database.data.access.services.PODService;
import database.data.access.services.TotalInfoService;
import database.data.tables.TotalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONController {

    @Autowired
    private AJAXServices ajaxServices;

    @Autowired
    private TotalInfoService totalInfoService;

    @Autowired
    private PODService podService;

    @JsonView({View.Public.class})
    @RequestMapping(value="/json/get-pod", consumes="application/json")
    public @ResponseBody // This convert the respond into JSON
    LaneSearchRespond AJAXSearchResultRespond(@RequestBody LaneSearch search) { // This annotation parse JSON into object

        LaneSearchRespond respond = null;

        if(search.getGetPod()!=null && search.getGetSourceHarbor() != null
                && search.getGetPod() && search.getGetSourceHarbor()) {

            respond = new LaneSearchRespond();
            respond.setHarborList(ajaxServices.retrieveAllHarbors());
            respond.setPODList(ajaxServices.retrieveAllPODs());

        }

        return respond;
    }

    @JsonView({View.Public.class})
    @RequestMapping(value="/json/update-total-info", consumes="application/json")
    public @ResponseBody
    TotalInfo AJAXUpdateTotalInfoRespond(@RequestBody String id) {

        int idOfTotalInfo = Integer.parseInt(id);
        TotalInfo totalInfo = totalInfoService.getTotalInfoById(idOfTotalInfo);

        return totalInfo;
    }

    @JsonView({View.Public.class})
    @RequestMapping(value="/json/delete-pod", consumes="application/json")
    public @ResponseBody
    String AJAXDeletePod(@RequestBody String podName) {

        System.out.println("____________________________");
        String podToDelete = podName.replace("_", " ").replace("\"", "");
        Boolean succeeded = podService.deletePodByName(podToDelete);
        System.out.println(podToDelete);
        String respond;
        if (succeeded)
            respond = "{\"succeeded\":\"true\"}";
        else
            respond = "{\"succeeded\":\"false\"}";
        return respond;
    }

}
