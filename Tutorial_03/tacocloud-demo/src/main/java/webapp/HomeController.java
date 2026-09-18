package webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Returns a view NAME (not data) — Thymeleaf resolves this to
    // src/main/resources/templates/home.html
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
