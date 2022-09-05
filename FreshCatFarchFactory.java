package com.vtlions.cats;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FreshCatFarchFactory<T extends Cat> {

	private T[] array;
	private final int QUANTITY_OF_INHERITED_METHODS_FROM_CAT = 9;
	private boolean isRed;
	private String reason;

	public FreshCatFarchFactory(T[] array) {
		this.array = array;
		chosingOfProperCats();
	}

	private void chosingOfProperCats() {

		for (T cat : array) {
			Class<? extends Cat> c = cat.getClass();
			Method[] methods = c.getMethods();
			Field[] fields = c.getDeclaredFields();

			// decline cats which have more than 3 methods
			if (methods.length - QUANTITY_OF_INHERITED_METHODS_FROM_CAT > 2) {
				reason = "there are more than 3 methods";
				print(c, reason);
				continue;
			}

			// decline cats if their class has one of annotations: BloheAble,
			// OdnoglazAble,TosheAble
			if (c.isAnnotationPresent(BloheAble.class) || c.isAnnotationPresent(OdnoglazAble.class)
					|| c.isAnnotationPresent(TosheAble.class)) {

				if (c.isAnnotationPresent(BloheAble.class)) {
					reason = "it has annotation @BloheAble on class";
				}

				if (c.isAnnotationPresent(OdnoglazAble.class)) {
					reason = "it has annotation @OdnoglazAble on class";
				}

				if (c.isAnnotationPresent(TosheAble.class)) {
					reason = "it has annotation @TosheAble on class";
				}

				print(c, reason);
				continue;
			}

			// decline cats which have annotation @Colour (parameter colour must be "red")
			// on the class
			if (c.isAnnotationPresent(Colour.class)) {
				Colour anno = c.getDeclaredAnnotation(Colour.class);
				if (anno.colour().equals("red")) {
					reason = "@Colour has colour='red' on a class";
					print(c, reason);
					continue;
				}
			}

			// decline cats which have annotation @Colour (parameter colour must be "red")
			// on the method
			for (Method method : methods) {

				if (method.isAnnotationPresent(Colour.class)) {
					Colour anno = method.getDeclaredAnnotation(Colour.class);
					if (anno.colour().equals("red")) {
						reason = "@Colour has colour='red' on a method";
						print(c, reason);
						isRed = true;
						break;
					}
				}
			}

			for (Field field : fields) {

				if (field.isAnnotationPresent(Colour.class)) {
					Colour anno = field.getDeclaredAnnotation(Colour.class);
					if (anno.colour().equals("red")) {
						reason = "@Colour has colour='red' on a field";
						print(c, reason);
						isRed = true;
						break;
					}
				}
			}

			if (isRed) {
				isRed = false;
				continue;
			}

			System.out.println(c.getName().substring(17, c.getName().length())
					+ " is good source of meat for the factory".toUpperCase());
		}
	}

	private void print(Class<?> c, String reason) {
		System.out.println(c.getName().substring(17, c.getName().length())
				+ " isn't apropriate for the meat factory because " + reason);
	}
}
