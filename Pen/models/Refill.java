package Pen.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class Refill {
	private Ink ink;
	private Nib nib;
	private RefillType type;
}
