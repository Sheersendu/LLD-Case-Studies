package TicTacToe.models;

import TicTacToe.Symbol;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class HumanPlayer extends  Player{
	private User user;
	public HumanPlayer(Symbol symbol, User user) {
		super(symbol);
		this.user = user;
	}

	@Override
	public BoardCell play(Board board) {
		System.out.println("Human playing");
		return null;
	}
}
