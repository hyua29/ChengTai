package web.config.servlet;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/download")
public class DownLoadController {
    //private final String FILE_DIRECTORY = "/home/cooper/Desktop/";

    @RequestMapping("/lane-template")
    public ResponseEntity<byte[]> downloadTemplate (@RequestParam("fileName") String filename) throws IOException {
        File template =  new File(getClass().getClassLoader().getResource("template.xlsx").getFile());
        // String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        String downloadFileName = "template.xlsx";  // default name of the file
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(template),
                headers, HttpStatus.CREATED);
    }
}
