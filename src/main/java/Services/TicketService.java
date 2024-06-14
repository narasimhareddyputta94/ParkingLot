package Services;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import exceptions.GateNotFoundException;
import models.Gate;
import models.Ticket;
import models.Vehicle;
import repositor.GateRepository;
import repositor.VehicleRepository;

import java.util.Date;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    public Ticket issueTicket(IssueTicketRequest ticketRequest) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepository.findGateById(ticketRequest.getGetId());
        ticket.setEntryGate(gate);

        Vehicle vehicle = vehicleRepository.getVehicleByNumber(ticketRequest.getVehicleNumber());

        if (vehicle == null) {

            vehicle = new Vehicle(ticketRequest.getVehicleType(), ticketRequest.getVehicleNumber(), ticketRequest.getOwnerName());
            vehicleRepository.addVehicle(vehicle);


            return null;
        }
    }
}
