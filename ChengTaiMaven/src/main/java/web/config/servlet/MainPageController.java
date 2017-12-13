package web.config.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// This is the logic controller
@Controller
public class MainPageController {

    @GetMapping("/")
    public String showIndex() {
        System.out.println("Loading index page");
        return "index";
    }
}
