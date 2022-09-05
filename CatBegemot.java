package com.vtlions.cats;

public class CatBegemot extends Cat {

	private String name = "Begemot";
	private int head = 1;

	public void shootingFromGun() {
		System.out.println("Я не могу стрелять, когда под руку говорят!");
	}

	public void repairingOfPrimus() {
		System.out.println(
				"Не шалю, никого не трогаю, починяю примус, и еще считаю долгом предупредить, что кот древнее и неприкосновенное животное.");
	}

	public void serveToVoland() {
		System.out.println("Слушаю, мессир, – сказал кот");
	}

	public int beheading() {
		head -= 1;
		return head;
	}

}
