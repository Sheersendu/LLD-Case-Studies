package ParkingLot.Respositories;

import ParkingLot.models.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {
	private List<ParkingLot> parkingLots = new ArrayList<>();
	public ParkingLot save(ParkingLot parkingLot) {
		parkingLots.add(parkingLot);
		return parkingLot;
	}
}
