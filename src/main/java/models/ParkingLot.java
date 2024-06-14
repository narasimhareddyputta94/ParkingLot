package models;

import stratagies.BillingStrategy;
import stratagies.ParkingPlaceAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private ParkingLotStatus status;
    private ParkingPlaceAllocationStrategy parkingPlaceAllocationStrategy;
    private BillingStrategy billingStrategy;

    public BillingStrategy getBillingStrategy() {
        return billingStrategy;
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public ParkingPlaceAllocationStrategy getParkingPlaceAllocationStrategy() {
        return parkingPlaceAllocationStrategy;
    }

    public void setParkingPlaceAllocationStrategy(ParkingPlaceAllocationStrategy parkingPlaceAllocationStrategy) {
        this.parkingPlaceAllocationStrategy = parkingPlaceAllocationStrategy;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }
}
