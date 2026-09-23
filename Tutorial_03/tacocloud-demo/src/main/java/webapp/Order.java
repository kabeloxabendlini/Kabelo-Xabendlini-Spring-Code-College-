Order.java: package webapp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Order {

    @NotBlank(message = "Full name is required.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    private String name;

    @NotBlank(message = "Street address is required.")
    private String street;

    @NotBlank(message = "City is required.")
    private String city;

    @NotBlank(message = "ZIP / Postal code is required.")
    @Size(min = 4, max = 10, message = "Please enter a valid postal code.")
    private String zip;

    // Default constructor required by Spring/Thymeleaf for binding
    public Order() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
