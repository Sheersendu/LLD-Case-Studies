package ParkingLot.services;

import ParkingLot.Respositories.ParkingLotRepository;
import ParkingLot.models.ParkingLot;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLotService {

	private ParkingLotRepository parkingLotRepository;
	private ParkingSpotService parkingSpotService;
	// Accepts model not DTO
	public ParkingLot createParkingLot(ParkingLot parkingLot) {

		// Save entity to DB
		ParkingLot lot = parkingLotRepository.save(parkingLot);
		// Create parking spots
		parkingSpotService.createParkingSpots(parkingLot);
		return lot;
	}
}
