package web.config.servlet;

import database.data.access.services.CarrierService;
import database.data.access.services.HarborService;
import database.data.access.services.PODService;
import database.data.access.services.TotalInfoService;
import database.data.tables.Carrier;
import database.data.tables.POD;
import database.data.tables.SourceHarbor;
import database.data.tables.TotalInfo;
import excel.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
// TODO: change directory to store files
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private TotalInfoService totalInfoService;
    @Autowired
    private PODService podService;
    @Autowired
    private HarborService harborService;
    @Autowired
    private CarrierService carrierService;

    // private final String FILE_DIRECTORY = "/home/ec2-user/uploads/"; // directory to which the file will be saved

    @PostMapping("/lane-info")
    public String handleLaneInfoUpload(@RequestParam("laneInfo") CommonsMultipartFile multipartFile, Model model, HttpSession session) {  // can  also obtain file with 'request.getFile('name')'
        if (multipartFile.isEmpty()) {
            model.addAttribute("status", "failed");
            return "upload-status";
        }

/*

        File file = null;
        try {
            multipartFile.transferTo(new File(FILE_DIRECTORY + multipartFile.getOriginalFilename())); // save multipart file to the server
            file = new File(FILE_DIRECTORY + multipartFile.getOriginalFilename());  // read file that just stored
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "upload-failed";
        }
*/
        InputStream is = null;
        try {
            is = multipartFile.getInputStream();
        } catch (IOException e) {
            model.addAttribute("status", "failed");
            return "upload-status";
        }
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.loadExcel(multipartFile.getOriginalFilename(), is);

        List<POD> pods = podService.getAllPODs();
        List<SourceHarbor> sourceHarbors = harborService.getAllHarbors();
        List<Carrier> carriers = carrierService.getAllCarriers();

        excelUtil.validateData(sourceHarbors, pods, carriers);

        List<TotalInfo> legitToInfo = excelUtil.getLegitToInfo();
        List<TotalInfo> invalidToInfo = excelUtil.getInvalidToInfo();

        model.addAttribute("legitToInfoList", legitToInfo);
        model.addAttribute("invalidToInfoList", invalidToInfo);

        session.setAttribute("tempToInfo", legitToInfo);

        return "upload-excel-confirm-page";
    }
    /*
    TODO: need to invalidate session attribute if the user decides not to upload
     */
    @GetMapping("/store")
    public String handleLaneInfoUpload(HttpSession session, Model model) {
        try{
            List<TotalInfo> totalInfos = (List<TotalInfo>) session.getAttribute("tempToInfo");
            //request.removeAttribute("tempToInfo");
            for(int i=0;i<totalInfos.size();i++)
                totalInfoService.saveTotalInfo(totalInfos.get(i));
            model.addAttribute("status", "succeeded");

        } catch (NullPointerException e) {  // no file has been uploaded
            model.addAttribute("status", "failed");
        }

        return "upload-status";


    }
}
