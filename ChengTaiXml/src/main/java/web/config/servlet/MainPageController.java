package web.config.servlet;

import database.data.access.implementations.PODIpm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import request.objects.SearchObject;

// This is the logic controller
@Controller
public class MainPageController {

    @Autowired
    PODIpm podIpm;

    @GetMapping("/")
    public String showIndex(Model model) {

        SearchObject searchObject = new SearchObject();  // pass an object in which inputs are stored
        model.addAttribute("searchObject", searchObject);

        return "index";
    }

    @GetMapping("/t")
    public String test(Model model) {

        SearchObject searchObject = new SearchObject();  // pass an object in which inputs are stored
        model.addAttribute("searchObject", searchObject);

        return "index";
    }



}
