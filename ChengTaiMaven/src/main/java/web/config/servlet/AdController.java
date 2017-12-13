package web.config.servlet;

import database.table.classes.TotalInfo;
import database.table.data.access.services.TotalInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/amt")
public class AdController {

    private TotalInfoService totalInfoService = new TotalInfoService();

    /*
    @GetMapping("/show/data")
    public String showFormDataForAdmin(Model model) {

        model.addAttribute("totalInfoList", totalInfoService.getTotalInfoIpm().getTList());

        return "admin-data";
    }
    */

    @GetMapping("/add-to-total-info")
    public String showAddForAdmin(Model model) {    // create a new model to hold new 'TotalInfo'
        // jsp can put inputs into this model and pass it
        // to 'saveTotalInfo'
        TotalInfo totalInfoToAdd = new TotalInfo();
        model.addAttribute("totalInfoToAdd", totalInfoToAdd);

        return "new-total-info-form-page";
    }

    /*
     show a search page
     */
    @GetMapping("/search")
    public String searchData() {
        return "search-on-total-info";
    }

    /*
    show the results based on info provided by the users
     */
    @GetMapping("/search-result")
    public String retrieveResults(@RequestParam("sourceHarbor") String sourceHarbor,
                                  @RequestParam("cOrPSelect") String cOrPSelect,
                                  @RequestParam("ctyOrPod") String ctyOrPod,
                                  @RequestParam("time") String date,
                                  Model model
                                    ) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date dateObject = null;
        try {
            dateObject = format.parse(date + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        List<TotalInfo> resultTotalInfo = totalInfoService.searchTotalInfo(
                cOrPSelect, ctyOrPod.toUpperCase(), dateObject, sourceHarbor.toUpperCase());

        model.addAttribute("resultTotalInfo", resultTotalInfo);

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
    public String pre(@RequestParam("totalInfoId") int id,
                                    Model model) {

        Boolean transactionSucceeded = totalInfoService.deleteTotalInfo(id);
        model.addAttribute("transactionSucceeded", transactionSucceeded);

        return "delete-transaction-confirm-page";
    }

}


