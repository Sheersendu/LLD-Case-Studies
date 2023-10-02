package SnakesAndLadder;

import java.util.List;

public class Game {
	private Board board;
	private List<Player> players;
	private List<Dice> dices;
	private StatusType status;
	private Leaderboard leaderboard;
	public Game createGame(CreateGameRequest createGameRequest) {
		return new Game();
	}
	public int roll() {
		return 1;
	}
	public void makeMove(Player player, Piece piece){}
	public void updateLeaderboard() {}
}
