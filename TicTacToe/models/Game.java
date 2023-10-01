package TicTacToe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Game {
	private Board board;
	private List<Player> players = new ArrayList<>();

	public static Game createGame(List<Player> players, int rows, int columns) {
		Board board = new Board(rows, columns);
		Game game = new Game(board, players);
		return game;
	}

	public void makeMove(Player incomingPlayer, int row, int column) {
		incomingPlayer.play(board);
	}

}
