package Pen.interfaces;

import Pen.models.Refill;

public interface RefillPen {
	public Refill getRefill();
	public void changeRefill(Refill refill);
	public boolean canRefill();
}
