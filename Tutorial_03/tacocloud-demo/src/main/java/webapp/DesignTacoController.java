DesignTacoController.java: package webapp;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private static final Logger log = Logger.getLogger(DesignTacoController.class.getName());

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(Taco taco) {
        // Log the structural elements parsed out from the HTML form binding object
        log.info("Processing taco design name: " + taco.getTacoName());
        log.info("Selected ingredient codes: " + taco.getIngredients());

        // Redirect browser flow cleanly to your order delivery page mapping
        return "redirect:/order";
    }
}
