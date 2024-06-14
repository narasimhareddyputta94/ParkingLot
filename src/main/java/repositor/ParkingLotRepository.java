package repositor;

import exceptions.ParkingLotNotfoundException;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    Map<Long,ParkingLot> parkingLotMap = new HashMap<>();

    public ParkingLot getParkingLotById(Long parkingLotId) throws ParkingLotNotfoundException {

        if(parkingLotMap.containsKey(parkingLotId)) {
            return parkingLotMap.get(parkingLotId);
        }
        throw new ParkingLotNotfoundException();
    }
}
