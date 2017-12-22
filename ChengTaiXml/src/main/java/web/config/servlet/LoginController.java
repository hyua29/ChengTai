package web.config.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// This is the logic controller
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLoginPage() {
        return "login-page-template";
    }

    @RequestMapping("/index")
    public String showIndexPage(){
        return "index";
    }

}
