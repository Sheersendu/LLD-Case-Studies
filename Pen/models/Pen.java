package Pen.models;
import Pen.interfaces.WritingStrategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
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
