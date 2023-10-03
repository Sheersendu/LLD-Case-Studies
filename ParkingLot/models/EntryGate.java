package ParkingLot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EntryGate extends Gate{
	private DisplayBoard displayBoard;
}
