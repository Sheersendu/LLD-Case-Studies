package SnakesAndLadder;

public class Dice {
	private int faces;
	public int roll() {
		int randomFaceValue = (int)Math.floor(Math.random()*(faces)+1);
		System.out.println("Dice is rolling! "+ randomFaceValue);
		return randomFaceValue;
	}
}
