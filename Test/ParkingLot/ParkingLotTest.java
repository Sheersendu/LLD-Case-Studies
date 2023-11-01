package Test.ParkingLot;

import ParkingLot.Controllers.ParkingLotController;
import ParkingLot.DTOs.CreateLotRequest;
import ParkingLot.Respositories.ParkingLotRepository;
import ParkingLot.Respositories.ParkingSpotRepository;
import ParkingLot.models.ParkingLot;
import ParkingLot.services.ParkingLotService;
import ParkingLot.services.ParkingSpotService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
	private ParkingLotController parkingLotController;
	private ParkingLotService parkingLotService;
	private ParkingLotRepository parkingLotRepository;
	private ParkingSpotService parkingSpotService;
	private ParkingSpotRepository parkingSpotRepository;

	@Before
	public void Setup() {
		parkingLotRepository = new ParkingLotRepository();
		parkingSpotRepository = new ParkingSpotRepository();
		parkingSpotService = new ParkingSpotService(parkingSpotRepository);
		parkingLotService = new ParkingLotService(parkingLotRepository, parkingSpotService);
		parkingLotController = new ParkingLotController(parkingLotService);
	}

	@Test
	public void testCreateParkingLot() {
		CreateLotRequest request =  CreateLotRequest.builder()
				.id(1L)
				.name("New parking Lot")
				.address("Somewhere in this world")
				.numberOfFloors(10)
				.numberOfSlotsPerFloors(10)
				.numberOfGates(5).build();
		ParkingLot actualParkingLot = parkingLotController.createParkingLot(request);
		Assert.assertNotNull("Ïf parking lot is created, it should not be null", actualParkingLot);
		Assert.assertEquals("No of floors should be equal to 10", 10, actualParkingLot.getFloors().size());
	}
}
