package com.vtlions.cats;

public class Main {

	public static void main(String[] args) {

		FreshCatFarchFactory<Cat> meatFactory = new FreshCatFarchFactory<>(
				new Cat[] { new BlackCat(), new CatBegemot(), new CheshireCat(), new FatCat(), new Garfield(),
						new KittenGav(), new KotVSapogah(true,1), new TinyCat(), new TomWithoutJerry() });

	}

}
