package ParkingLot.DTOs;

import ParkingLot.models.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Builder
@Getter
public class CreateLotRequest {
	private Long id;
	private String name;
	private String address;
	private int numberOfFloors;
	private int numberOfSlotsPerFloors;
	private int numberOfGates;

	// Prototype Design Pattern
	public ParkingLot toParkingLot() {
		// Create spots
		List<ParkingSpot> parkingSpotsPerFloor = Collections.nCopies(numberOfSlotsPerFloors, ParkingSpot.mediumAvailable());
		parkingSpotsPerFloor.forEach(spot -> spot.setId(1L));

		// Create floors
		List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,
				ParkingFloor.builder()
						.parkingSpots(parkingSpotsPerFloor)
						.paymentCounter(PaymentCounter.builder().build())
						.build());

		return ParkingLot.builder()
				.name(name)
				.address(address)
				.floors(parkingFloors)
				.entryGates(Collections.nCopies(numberOfGates, EntryGate.builder().build()))
				.exitGates(Collections.nCopies(numberOfGates, ExitGate.builder().build()))
				.build();
	}
}
