package web.config.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// This is the logic controller
@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login-page-template";
    }

}
