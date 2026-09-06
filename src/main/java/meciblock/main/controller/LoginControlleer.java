package meciblock.main.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginControlleer {
    @GetMapping("/login")
    public String getMethodName() {
        

        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        String password = "123";

        String encoded = encoder.encode(password);

        System.out.println(encoded);
 
        return "login";
    }
    
    
}
