package meciblock.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller 
@RequestMapping ("/doctor")
public class DoctorController {
    @GetMapping("/dashboard")
    public String getMethodName() {
        return "doctor/dashboard";
    }
    @GetMapping("/patients")
    public String getPatients() {
        return "doctor/patients";
    }
    @GetMapping("/create-prescription")
    public String getCreatePrescription() {
        return "doctor/create-prescription";
    }
    @GetMapping("/prescriptions")
    public String getPrescriptions() {
        return "doctor/prescriptions";
    }
    
    
}
