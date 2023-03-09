package Pen.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class Ink {
	private String color;
	private String brand;
	private InkType type;
}
