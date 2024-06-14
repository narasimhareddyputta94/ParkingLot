package App;

import Services.TicketService;
import controllers.TicketController;
import dtos.IssueTicketRequest;
import exceptions.ParkingLotFullException;
import repositor.GateRepository;
import repositor.ParkingLotRepository;
import repositor.TicketRepository;
import repositor.VehicleRepository;

public class AppRunner {

    public static void main(String[] args) throws ParkingLotFullException {


        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequest request = new IssueTicketRequest("KA-01-HH-1234", "CAR", "Rahul", 1L, 1L);

        ticketController.issueTicket(request);


    }
}
