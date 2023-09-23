package TicTacToe.models;

import TicTacToe.Symbol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@SuperBuilder
public abstract class Player {
	private Symbol symbol;
	public abstract BoardCell play(Board board);
}
