package TicTacToe.models;

import TicTacToe.Level;
import TicTacToe.Symbol;
import TicTacToe.strategies.PlayingStrategy;

public class BotPlayer extends Player {
	private Level difficultyLevel;
	private PlayingStrategy playingStrategy;

	public BotPlayer(Symbol symbol, Level difficultyLevel) {
		super(symbol);
		this.difficultyLevel = difficultyLevel;
	}

	@Override
	public BoardCell play(Board board) {
		return null;
	}
}
