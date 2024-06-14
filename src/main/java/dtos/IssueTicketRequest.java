package dtos;

import models.Ticket;

public class IssueTicketRequest {
    private String vehicleNumber;
    private String vehicleType;
    private String ownerName;
    private Long getId;
    private Long parkingLotId;

    public IssueTicketRequest(String vehicleNumber, String vehicleType, String ownerName, Long getId, Long parkingLotId) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        this.getId = getId;
        this.parkingLotId = parkingLotId;
    }

    public IssueTicketRequest(Ticket ticket, ResponseStatus responseStatus, String ticketIssueMessage) {

    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Long getGetId() {
        return getId;
    }

    public void setGetId(Long getId) {
        this.getId = getId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
