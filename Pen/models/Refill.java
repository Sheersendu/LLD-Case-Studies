package Pen.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Refill {
	private Ink ink;
	private Nib nib;
	private RefillType type;
	private Boolean refillable;
}
