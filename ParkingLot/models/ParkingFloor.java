package ParkingLot.models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ParkingFloor extends BaseModel{
	private List<ParkingSpot> parkingSpots;
	private PaymentCounter paymentCounter;
}
