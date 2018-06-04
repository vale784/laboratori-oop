package diet;

public class RawMaterial implements NutritionalElement{
	
	private String name = new String();
	private double calories, proteins, carbs, fat;

	public RawMaterial(String name,
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

	@Override
	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public double getProteins() {
		return proteins;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	@Override
	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	@Override
	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean per100g() {
		return true;
	}



	
	

}
