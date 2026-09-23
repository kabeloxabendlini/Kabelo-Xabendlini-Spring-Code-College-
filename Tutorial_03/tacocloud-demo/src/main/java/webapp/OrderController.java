OrderController.java: package webapp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles the delivery-address portion of the Taco Cloud ordering process.
 *
 * <p>The customer first enters their delivery information on the
 * /order page. Once the information passes validation, the customer
 * is taken to the taco designer at /design.</p>
 */
@Controller
public class OrderController {

    /**
     * Displays the delivery-address form.
     *
     * @param model the Spring MVC model used to provide the Order object
     * @return the order.html template
     */
    @GetMapping("/order")
    public String showOrderForm(Model model) {
        // Create a new Order object for the form to bind to.
        model.addAttribute("order", new Order());
        return "order";
    }

    /**
     * Processes the submitted delivery information.
     *
     * <p>If validation fails, the customer remains on the order page
     * so that the validation messages can be displayed.</p>
     *
     * <p>If validation succeeds, the customer moves on to the taco
     * designer where they can select their ingredients.</p>
     *
     * @param order  the submitted delivery information
     * @param errors validation errors, if any
     * @return either the order page or the taco designer
     */
    @PostMapping("/order")
    public String processOrder(@Valid Order order, Errors errors) {
        // Keep the customer on the address page when validation fails.
        if (errors.hasErrors()) {
            return "order";
        }

        // Address is valid, so continue to the taco builder.
        return "redirect:/design";
    }
}
