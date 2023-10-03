package ParkingLot.Respositories;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {
	private List<ParkingSpot> parkingSpots = new ArrayList<>();
	public ParkingSpot save(ParkingSpot parkingSpot) {
		parkingSpots.add(parkingSpot);
		return parkingSpot;
	}
	public List<ParkingSpot> saveAll(List<ParkingSpot> parkingSpots) {
		parkingSpots.addAll(parkingSpots);
		return parkingSpots;
	}
}
