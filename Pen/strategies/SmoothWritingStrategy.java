package Pen.strategies;

import Pen.interfaces.WritingStrategy;

public class SmoothWritingStrategy implements WritingStrategy {

	@Override
	public void write() {
		System.out.println("Smooth writing");
	}
}
