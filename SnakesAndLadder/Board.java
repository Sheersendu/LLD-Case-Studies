package SnakesAndLadder;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Board {
	private int size;
	private List<List<Cell>> cells;
}
