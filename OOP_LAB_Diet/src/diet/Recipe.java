package diet;

import java.util.TreeMap;

/**
 * Represent a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
    
	
	private String recipeName;
	private Food food;
	private TreeMap<String,Double> ingredients = new TreeMap<>();
	private double calories, proteins, carbs, fat, totGrams;
	
	/**
	 * Recipe constructor.
	 * The reference {@code food} of type {@link Food} must be used to
	 * retrieve the information about ingredients. 
	 * 
	 * @param nome unique name of the recipe
	 * @param food object containing the information about ingredients
	 */
	public Recipe(String name, Food food){
		this.recipeName = name;
		this.food = food;
		food.recipes.put(name, this);
	}
	
	/**
	 * Adds a given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material defined with the {@code food}
	 * argument of the constructor.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 */
	public void addIngredient(String material, double quantity) {
		this.ingredients.put(material,quantity);
		NutritionalElement tmp = food.getRawMaterial(material);
		calories += (tmp.getCalories()/100)*quantity;
		proteins += (tmp.getProteins()/100)*quantity;
		carbs    += (tmp.getCarbs()/100)*quantity;
		fat      += (tmp.getFat()/100)*quantity;
		totGrams += quantity;
	}

	@Override
	public String getName() {
		return this.recipeName;
	}

	@Override
	public double getCalories() {
		return (this.calories/totGrams)*100;
	}

	@Override
	public double getProteins() {
		return (this.proteins/totGrams)*100;
	}

	@Override
	public double getCarbs() {
		return (this.carbs/totGrams)*100;
	}

	@Override
	public double getFat() {
		return (this.fat/totGrams)*100;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expressed nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
	    // a recipe expressed nutritional values per 100g
		return true;
	}

}
