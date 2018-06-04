package diet;

public class Product implements NutritionalElement {

	private String name = new String();
	private double calories, proteins, carbs, fat;
	
	public Product(String name,
					double calories,
					double proteins,
					double carbs,
					double fat) {
		this.setCalories(calories);
		this.setProteins(proteins);
		this.setCarbs(carbs);
		this.setFat(fat);
		this.setName(name);
	}
	
	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public void setProteins(double proteins) {
		this.proteins = proteins;
	}
	
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	
	public void setFat(double fat) {
		this.fat = fat;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getCalories() {
		return this.calories;
	}

	@Override
	public double getProteins() {
		return this.proteins;
	}

	@Override
	public double getCarbs() {
		return this.carbs;
	}

	@Override
	public double getFat() {
		return this.fat;
	}

	@Override
	public boolean per100g() {
		return false;
	}

}
