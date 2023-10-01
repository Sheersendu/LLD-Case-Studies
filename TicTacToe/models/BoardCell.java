package TicTacToe.models;

import TicTacToe.Symbol;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardCell {
	private Integer row;
	private Integer column;
	private Symbol symbol;
}
