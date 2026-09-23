HomeController.java: package webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Maps http://localhost:8081/
    public String home() {
        return "home"; // Looks for src/main/resources/templates/home.html
    }
}
