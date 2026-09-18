package webapp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    // GET: show the empty form.
    // @ModelAttribute here means "put a fresh Order object in the model
    // under the name 'order'" so Thymeleaf's th:object can bind to it.
    @GetMapping("/order")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "order";
    }

    // POST: handle the submitted form.
    // @Valid triggers the constraints declared on the Order class (@NotBlank, @Pattern).
    // Errors must come immediately after the @Valid parameter — Spring populates
    // it with any validation failures instead of throwing an exception.
    @PostMapping("/order")
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "order";   // re-show the form with error messages
        }
        return "orderConfirmation";
    }
}
