package ParkingLot.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentCounter extends BaseModel {
	private int counterNumber;
}
