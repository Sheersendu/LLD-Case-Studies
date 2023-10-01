package Pen.models;
import Pen.interfaces.WritingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Pen {
	private String name;
	private String brand;
	private PenType type;
	private double price;
	private WritingStrategy writingStrategy;

    // Strategy Design pattern for removing code duplication and injecting behaviour
	public void write(){
		writingStrategy.write();
	}
}
