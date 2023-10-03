package ParkingLot.services;

import ParkingLot.Respositories.ParkingSpotRepository;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSpot;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ParkingSpotService {
	private ParkingSpotRepository parkingSpotRepository;
	public List<ParkingSpot> createParkingSpots(ParkingLot parkingLot) {
		List<ParkingSpot> parkingSpots = parkingLot
				.getFloors()
				.stream()
				.flatMap(floor -> floor.getParkingSpots().stream())
				.collect(Collectors.toList());
		return parkingSpotRepository.saveAll(parkingSpots);
	}
}
