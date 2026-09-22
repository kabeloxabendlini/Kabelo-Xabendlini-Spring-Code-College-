package webapp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles the customer order form.
 */
@Controller
public class OrderController {

    /**
     * Displays a new, empty order form.
     *
     * @param model the Spring MVC model
     * @return the Thymeleaf order page
     */
    @GetMapping("/order")
    public String showOrderForm(Model model) {
        // Create a new Order object for Thymeleaf to bind to.
        model.addAttribute("order", new Order());
        return "order";
    }

    /**
     * Processes the submitted order form.
     *
     * @param order the submitted order information
     * @param errors validation errors, if any
     * @return the order form again when validation fails,
     *         otherwise the confirmation page
     */
    @PostMapping("/order")
    public String processOrder(@Valid Order order, Errors errors) {
        // If validation fails, return to the form so that
        // Thymeleaf can display the validation messages.
        if (errors.hasErrors()) {
            return "order";
        }

        // Validation succeeded.
        return "orderConfirmation";
    }
}
