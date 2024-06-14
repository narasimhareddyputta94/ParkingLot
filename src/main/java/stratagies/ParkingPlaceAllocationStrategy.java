package stratagies;

import exceptions.ParkingLotFullException;
import models.ParkingLot;
import models.ParkingSlot;
import models.Vehicle;
import models.VehicleType;

public interface ParkingPlaceAllocationStrategy {
    ParkingSlot getParkingSlot(VehicleType vehicleType,Long parkingLotId) throws ParkingLotFullException;

    void allocateParkingPlace(ParkingLot parkingLot, Vehicle vehicle);
}
