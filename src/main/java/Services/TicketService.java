package Services;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotfoundException;
import models.*;
import repositor.GateRepository;
import repositor.ParkingLotRepository;
import repositor.VehicleRepository;
import stratagies.ParkingPlaceAllocationStrategy;
import stratagies.ParkingSlotAllotmentStrategyFactory;

import java.util.Date;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

    public Ticket issueTicket(IssueTicketRequest ticketRequest) throws GateNotFoundException, ParkingLotNotfoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepository.findGateById(ticketRequest.getGetId());
        ticket.setEntryGate(gate);

        Vehicle vehicle = vehicleRepository.getVehicleByNumber(ticketRequest.getVehicleNumber());
        if (vehicle == null) {
            vehicle = new Vehicle(ticketRequest.getVehicleType(), ticketRequest.getVehicleNumber(), ticketRequest.getOwnerName());
            vehicleRepository.addVehicle(vehicle);
        }
        ticket.setVehicle(vehicle);

        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(ticketRequest.getParkingLotId());
        ParkingPlaceAllocationStrategy parkingPlaceAllocationStrategy = parkingLot.getParkingPlaceAllocationStrategy();
        ParkingPlaceAllocationStrategy parkingAllotmentRule = ParkingSlotAllotmentStrategyFactory.getStrategy(parkingPlaceAllocationStrategy);

        ParkingSlot parkingSlot = parkingAllotmentRule.getParkingSlot(ticketRequest.getVehicleType(),ticketRequest.getParkingLotId());
        ticket.setParkingSlot(parkingSlot);

        return ticket;
    }
}
