package Test.TicTacToe;

import TicTacToe.Level;
import TicTacToe.Symbol;
import TicTacToe.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TicTacToeTest {

	private Game game;
	@Before
	public void Setup(){
		this.game = createGame();
	}

	private Game createGame() {
//		Player human = new HumanPlayer(Symbol.O, user);
		Player human = HumanPlayer.builder()
				.user(User.builder()
						.name("Sheersendu")
						.email("sheersendu@email.com")
						.photo(new Byte[]{})
						.build())
				.symbol(Symbol.O).build();
		Player bot = new BotPlayer(Symbol.X, Level.EASY);
		return Game.createGame(Arrays.asList(human, bot), 3, 3);
	}

	@Test
	public void testBoardCreation() {
		List<List<BoardCell>> cells = game.getBoard().getCells();
		Assert.assertEquals("Board is created successfully with proper number of columns", 3, cells.size());
		List<BoardCell> firstRow = cells.get(0);
		Assert.assertEquals("Board is created successfully with proper number of rows", 3, firstRow.size());
	}
}
