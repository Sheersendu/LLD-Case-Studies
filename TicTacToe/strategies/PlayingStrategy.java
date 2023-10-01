package TicTacToe.strategies;

import TicTacToe.models.Board;
import TicTacToe.models.BoardCell;

public interface PlayingStrategy {
	public BoardCell play(Board board);
}
