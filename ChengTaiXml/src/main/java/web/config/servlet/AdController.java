package web.config.servlet;

import database.data.access.services.CarrierService;
import database.data.access.services.HarborService;
import database.data.access.services.PODService;
import database.data.tables.Carrier;
import database.data.tables.POD;
import database.data.tables.SourceHarbor;
import database.data.tables.TotalInfo;
import database.data.access.services.TotalInfoService;
import helpers.DateToChoose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import request.objects.SearchObject;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdController {

    @Autowired
    private TotalInfoService totalInfoService;
    @Autowired
    PODService podService;
    @Autowired
    HarborService harborService;
    @Autowired
    CarrierService carrierService;

    /*
     show a search page
     */
    @GetMapping("/search-result")
    public String searchData(Model model) {
        SearchObject searchObject = new SearchObject();  // pass an object in which inputs are stored
        model.addAttribute("searchObject", searchObject);

        model.addAttribute("resultTotalInfo", null);

        model.addAttribute("dateToChoose", new DateToChoose());

        TotalInfo totalInfoToAdd = new TotalInfo();  // pass an object in which inputs are stored
        model.addAttribute("totalInfoToAdd", totalInfoToAdd);
        return "search-result-page";
    }

    /*
    show the results based on info provided by the users
     */
    @PostMapping("/search-result")
    public String retrieveSearchResults(@ModelAttribute("searchObject") SearchObject searchObject,
                                  Model model
                                    ) {
        System.out.println(searchObject.getYearFrom());


        List<TotalInfo> resultTotalInfo = null;
        if(!searchObject.isEmpty()) {
            resultTotalInfo = totalInfoService.searchTotalInfo(
                    searchObject.getcOrPSelect(), searchObject.getCtyOrPod().toUpperCase(),
                    searchObject.getDateFrom(), searchObject.getDateTo(), searchObject.getSourceHb().toUpperCase());
        }

        System.out.println(searchObject);
        System.out.println("---------------------------");

        model.addAttribute("resultTotalInfo", resultTotalInfo);

        TotalInfo totalInfoToAdd = new TotalInfo();  // pass an object in which inputs are stored
        model.addAttribute("totalInfoToAdd", totalInfoToAdd);

        SearchObject searchOj = new SearchObject();  // pass an object in which inputs are stored
        model.addAttribute("searchObject", searchOj);

        return "search-result-page";
    }

    @PostMapping("/saveTotalInfo")
    public String saveNewTotalInfo(@ModelAttribute("totalInfoToAdd") TotalInfo totalInfo,  // get attribute
                                   Model model) {

        Boolean transactionSucceeded = totalInfoService.saveTotalInfo(totalInfo);

        model.addAttribute("transactionSucceeded", transactionSucceeded);

        return "update-transaction-confirm-page";
    }

    /*
    This controller catch update request and pre-populate existing TotalInfo
     */
    @GetMapping("/show-form-for-update")
    public String prePopulate(@RequestParam("totalInfoId") int id, Model model) {

        TotalInfo totalInfo = totalInfoService.getTotalInfoById(id);

        model.addAttribute("totalInfoToAdd", totalInfo);

        return "new-total-info-form-page";
    }
    
    @GetMapping("/delete")
    public String deleteRecord(@RequestParam("totalInfoId") int id,
                                    Model model) {

        Boolean transactionSucceeded = totalInfoService.deleteTotalInfo(id);
        model.addAttribute("transactionSucceeded", transactionSucceeded);

        return "delete-transaction-confirm-page";
    }

    @GetMapping("/data-batch")
    public String retrieveDataBatchGet(Model model) {
        model.addAttribute("PODBatches", podService.getAllPODs());
        model.addAttribute("sourceHbList", harborService.getAllHarbors());
        model.addAttribute("carrierList", carrierService.getAllCarriers());

        return "data-batch-page";
    }


    @PostMapping("/data-batch")
    public String retrieveDataBatchPost(Model model, HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getParameter("isPod")!=null && httpServletRequest.getParameter("isPod").equals("true")) {
            String pod = httpServletRequest.getParameter("pod");
            String country = httpServletRequest.getParameter("country");
            POD newPod = new POD();
            newPod.setCountry(country);
            newPod.setPODName(pod);
            podService.addPod(newPod);
        }

        if (httpServletRequest.getParameter("isCarrier")!=null && httpServletRequest.getParameter("isCarrier").equals("true")) {
            String carrier = httpServletRequest.getParameter("carrier");
            Carrier newCarrier = new Carrier();
            newCarrier.setCarrierName(carrier);
            carrierService.addCarrier(newCarrier);
        }

        if (httpServletRequest.getParameter("isHarbor")!=null && httpServletRequest.getParameter("isHarbor").equals("true")) {
            String harbor = httpServletRequest.getParameter("harbor");
            SourceHarbor newSourceHarbor = new SourceHarbor();
            newSourceHarbor.setSourceHarborName(harbor);
            harborService.addHarbor(newSourceHarbor);
        }

        model.addAttribute("PODBatches", podService.getAllPODs());
        model.addAttribute("sourceHbList", harborService.getAllHarbors());
        model.addAttribute("carrierList", carrierService.getAllCarriers());

        return "data-batch-page";
    }
}


