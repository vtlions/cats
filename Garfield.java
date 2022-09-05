package com.vtlions.cats;


public class Garfield extends Cat {
	private String name = "Garfield";
	private boolean isFunny = true;

	@Colour(colour = "red")
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

}
