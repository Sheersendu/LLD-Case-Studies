package Pen.models;

import Pen.strategies.SmoothWritingStrategy;

public class GelPen extends Pen implements RefillPen{
	public GelPen(String name, String brand, double price) {
		super(name, brand, PenType.GEL, price, new SmoothWritingStrategy());
	}

	@Override
	public Refill getRefill() {
		return null;
	}

	@Override
	public void changeRefill() {
	}

	@Override
	public boolean canRefill() {
		return true;
	}
}
