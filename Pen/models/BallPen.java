package Pen.models;

import Pen.interfaces.RefillPen;
import Pen.strategies.SmoothWritingStrategy;
import lombok.Builder;

@Builder
public class BallPen extends Pen implements RefillPen {
	private Refill refill;
	public BallPen(String name, String brand, double price, Refill refill) {
		super(name, brand, PenType.BALL, price, new SmoothWritingStrategy());
		this. refill = refill;
	}

	@Override
	public Refill getRefill() {
		return refill;
	}

	@Override
	public void changeRefill(Refill refill) {
		if (this.canRefill()) {
			this.refill = refill;
		}
	}

	@Override
	public boolean canRefill() {
		return true;
	}
}
