package Pen.models;

import Pen.strategies.SmoothWritingStrategy;

public class FountainPen extends Pen{
	public FountainPen(String name, String brand, double price) {
		super(name, brand, PenType.FOUNTAIN, price, new SmoothWritingStrategy());
	}
}
