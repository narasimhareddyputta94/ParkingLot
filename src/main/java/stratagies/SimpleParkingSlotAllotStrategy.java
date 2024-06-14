package stratagies;
import models.ParkingSlot;
import models.VehicleType;


public class SimpleParkingSlotAllotStrategy implements ParkingPlaceAllocationStrategy{
    @Override
    public ParkingSlot getParkingSlot(VehicleType vehicleType, Long parkingLotId) throws exceptions.ParkingLotFullException{
        // TODO: Implement this method

        return null;
    }

    @Override
    public void allocateParkingPlace(models.ParkingLot parkingLot, models.Vehicle vehicle) {

    }


}
