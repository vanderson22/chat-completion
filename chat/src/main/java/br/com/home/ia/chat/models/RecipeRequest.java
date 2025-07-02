package br.com.home.ia.chat.models;

import java.util.Map;

public class RecipeRequest {

    private String ingredients;
    private String instructions;
    private String dietaryRestrictions;

    public String getIngredients() {
        return ingredients;
    }
    
    public String getInstructions() {
        return instructions;
    }

    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public Map<String, Object> toMap() {
        return Map.of(
            "ingredients", ingredients,
            "instructions", instructions,
            "dietaryRestrictions", dietaryRestrictions
        );
    }

    @Override
    public String toString() {
        return "RecipeRequest [ingredients=" + ingredients + ", instructions=" + instructions + ", dietaryRestrictions="
                + dietaryRestrictions + "]";
    }
}
