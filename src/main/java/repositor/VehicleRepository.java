package repositor;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;


public class VehicleRepository {

    Long  previousId = 0l;

    Map<String,Vehicle>vehicleMap = new HashMap<>();
    public Vehicle getVehicleByNumber(String VehicleNumber) {
        if(vehicleMap.containsKey(VehicleNumber)){
            return vehicleMap.get(VehicleNumber);
        }
        return null;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        previousId++;
        vehicle.setId(previousId);
        vehicleMap.putIfAbsent(vehicle.getVehicleNumber(),vehicle);
        return vehicleMap.get(vehicle.getVehicleNumber());
    }
}
