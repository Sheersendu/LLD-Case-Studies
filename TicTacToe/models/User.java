package TicTacToe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@SuperBuilder
@Getter
public class User {
	private String name;
	private String email;
	private Byte[] photo;
}
