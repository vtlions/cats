package com.vtlions.cats;

public class KotVSapogah extends Cat {
	private boolean isBoots = true;
	private int quantityOfBoots;

	public KotVSapogah(boolean isBoots, int quantityOfBoots) {

		this.isBoots = isBoots;
		this.quantityOfBoots = quantityOfBoots;
	}

	public boolean isBoots() {
		return isBoots;
	}

	public void setBoots(boolean isBoots) {
		this.isBoots = isBoots;
	}

	public int getQuantityOfBoots() {
		return quantityOfBoots;
	}

	public void setQuantityOfBoots(int quantityOfBoots) {
		this.quantityOfBoots = quantityOfBoots;
	}

}
