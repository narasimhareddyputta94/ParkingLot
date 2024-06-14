package stratagies;

import models.ParkingSlot;
import models.VehicleType;

public interface ParkingPlaceAllocationStrategy {
    ParkingSlot getParkingSlot(VehicleType vehicleType,Long parkingLotId);
}
