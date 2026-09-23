package webapp;

import java.util.List;

public class Taco {

    private String tacoName;
    private List<String> ingredients;

    // Default constructor for form binding
    public Taco() {
    }

    // Getters and Setters
    public String getTacoName() {
        return tacoName;
    }

    public void setTacoName(String tacoName) {
        this.tacoName = tacoName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
