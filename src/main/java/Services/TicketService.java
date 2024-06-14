package Services;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotfoundException;
import models.*;
import repositor.GateRepository;
import repositor.ParkingLotRepository;
import repositor.TicketRepository;
import repositor.VehicleRepository;
import stratagies.ParkingPlaceAllocationStrategy;
import stratagies.ParkingSlotAllotmentStrategyFactory;

import java.util.Date;
import java.util.UUID;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public Ticket issueTicket(IssueTicketRequest ticketRequest) throws GateNotFoundException, ParkingLotNotfoundException, ParkingLotFullException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepository.findGateById(ticketRequest.getGetId());
        ticket.setEntryGate(gate);


        ticket.setVehicle(getVehicle(ticketRequest));

        ticket.setParkingSlot(getParkingSlot(ticketRequest));

        ticket.setNumber(ticketRequest.getOwnerName() + UUID.randomUUID().toString());

        return ticketRepository.save(ticket);

    }

    private ParkingSlot getParkingSlot(IssueTicketRequest ticketRequest) throws ParkingLotNotfoundException, ParkingLotFullException {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(ticketRequest.getParkingLotId());
        ParkingPlaceAllocationStrategy parkingPlaceAllocationStrategy = parkingLot.getParkingPlaceAllocationStrategy();
        ParkingPlaceAllocationStrategy parkingAllotmentRule = ParkingSlotAllotmentStrategyFactory.getStrategy(parkingPlaceAllocationStrategy);

        ParkingSlot parkingSlot = parkingAllotmentRule.getParkingSlot(ticketRequest.getVehicleType(), ticketRequest.getParkingLotId());
        return parkingSlot;
    }

    private Vehicle getVehicle(IssueTicketRequest ticketRequest) {
        Vehicle vehicle = vehicleRepository.getVehicleByNumber(ticketRequest.getVehicleNumber());
        if (vehicle == null) {
            vehicle = new Vehicle(ticketRequest.getVehicleType(), ticketRequest.getVehicleNumber(), ticketRequest.getOwnerName());
            vehicleRepository.addVehicle(vehicle);
        }
        return vehicle;
    }
}
