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
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

    private final String FILE_DIRECTORY = "/home/cooper/Desktop/"; // directory to which the file will be saved

    @PostMapping("/lane-info")
    public String handleLaneInfoUpload(@RequestParam("laneInfo") CommonsMultipartFile multipartFile, Model model, HttpSession session) {  // can  also obtain file with 'request.getFile('name')'
        if (multipartFile.isEmpty())
            return "upload-failed";

        File file = null;
        try {
            multipartFile.transferTo(new File(FILE_DIRECTORY + multipartFile.getOriginalFilename())); // save multipart file to the server
            file = new File(FILE_DIRECTORY + multipartFile.getOriginalFilename());  // read file that just stored
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "index";
        }

        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.loadExcel(file);

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
    TODO: store value into database
     */
    @GetMapping("/store")
    public String handleLaneInfoUpload(HttpSession session) {
        try{
            List<TotalInfo> totalInfos = (List<TotalInfo>) session.getAttribute("tempToInfo");
            session.removeAttribute("tempToInfo");
            for(int i=0;i<totalInfos.size();i++)
                totalInfoService.saveTotalInfo(totalInfos.get(i));
            return "upload-succeeded";
        } catch (NullPointerException e) {
            return "upload-failed";
        }


    }
}
