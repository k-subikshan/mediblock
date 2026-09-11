package meciblock.main.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller 
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/dashboard")
    public String getMethodName(Authentication authenticator,Model model) {
        model.addAttribute("username", authenticator.getName());
        return "admin/dashboard";
    }
    @GetMapping("/blockchain")
    public String getBlockChain(Authentication authenticator,Model model) {
        return "admin/blockchain";
    }
    @GetMapping("/audit")
    public String getAudit(Authentication authenticator,Model model) {
        return "admin/audit";

    }
    @GetMapping("/users")
    public String getUsers(Authentication authenticator,Model model) {
        return "admin/users";
    }
    
    
    
    
}
