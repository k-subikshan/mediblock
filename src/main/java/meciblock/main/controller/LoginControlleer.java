package meciblock.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginControlleer {
    @GetMapping("/login")
    public String getMethodName() {
        return "login";
    }
    
    
}
