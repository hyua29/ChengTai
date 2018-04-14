package web.config.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// This is the logic controller
import org.springframework.util.CollectionUtils.*;
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
