package ParkingLot.Controllers;

import ParkingLot.DTOs.CreateLotRequest;
import ParkingLot.models.ParkingLot;
import ParkingLot.services.ParkingLotService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLotController {

	private ParkingLotService service;

	// 1. Create parking lot
	public ParkingLot createParkingLot(CreateLotRequest request) {
		// Request Level validation
		validate(request);
		// Data Mapping
		return service.createParkingLot(request.toParkingLot());
	}

	private void validate(CreateLotRequest request) {
		if (request.getId() == null) {
			throw new RuntimeException("Id cannot be null!");
		}
	}

	// 2. Update parking lot
	// 3. Read parking lot
	// 4. Delete parking lot
}
