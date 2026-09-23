package webapp;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private static final Logger log = Logger.getLogger(DesignTacoController.class.getName());

    /**
     * Prepares the model and displays the ingredient builder view.
     */
    @GetMapping
    public String showDesignForm(Model model) {
        // FIX: Inject a blank Taco object matching th:object="${taco}" in your HTML
        model.addAttribute("taco", new Taco());
        
        return "design";
    }

    /**
     * Processes form data submitted via POST request.
     */
    @PostMapping
    public String processTaco(Taco taco) {
        // Log the structural elements captured from your checkboxes
        log.info("Processing taco design name: " + taco.getTacoName());
        log.info("Selected ingredient codes: " + taco.getIngredients());

        // Redirects smoothly to the customer shipping form view
        return "redirect:/order";
    }
}
