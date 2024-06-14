package models;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private String OwnerName;

    public Vehicle(String vehicleNumber, String vehicleType, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        OwnerName = ownerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }


}
