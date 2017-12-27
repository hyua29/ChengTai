package web.config.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private final String FILE_DIRECTORY = "/home/cooper/Desktop/";

    @PostMapping("/lane-info")
    public String handleLaneInfoUpload(@RequestParam("laneInfo") CommonsMultipartFile multipartFile) {  // can  also obtain file with 'request.getFile('name')'
        if (multipartFile.isEmpty())
            return "index";

        System.out.println("File: " + multipartFile.getOriginalFilename() + " has been uploaded!!!!");

        File file = null;
        try {
            multipartFile.transferTo(new File(FILE_DIRECTORY + multipartFile.getOriginalFilename())); // save multipart file to the server
            file = new File(FILE_DIRECTORY + multipartFile.getOriginalFilename());  // read file that just stored
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = null;
        if (file != null) {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        if (scanner != null) {
            while (scanner.hasNext())
                System.out.println(scanner.next());
        }

        return "index";
    }
}
