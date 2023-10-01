package Pen.models;

import Pen.interfaces.RefillPen;
import Pen.strategies.SmoothWritingStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class GelPen extends Pen implements RefillPen {
	private Refill refill;
	public GelPen(String name, String brand, double price, Refill refill) {
		super(name, brand, PenType.GEL, price, new SmoothWritingStrategy());
		this.refill = refill;
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
