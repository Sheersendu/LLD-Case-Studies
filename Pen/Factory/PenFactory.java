package Pen.Factory;

import Pen.models.GelPen;

public class PenFactory {
	public static GelPen.GelPenBuilder createGelPen() {
		return GelPen.builder();
	}
}
