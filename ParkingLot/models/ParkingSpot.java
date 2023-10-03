package ParkingLot.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParkingSpot extends BaseModel {
	private SpotType spotType;
	private SpotStatus spotStatus;

	public static ParkingSpot mediumAvailable() {
		return ParkingSpot.builder()
				.spotType(SpotType.MEDIUM)
				.spotStatus(SpotStatus.AVAILABLE)
				.build();
	}
}
