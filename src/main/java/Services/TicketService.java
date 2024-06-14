package Services;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import exceptions.GateNotFoundException;
import models.Ticket;
import repositor.GateRepository;

import java.util.Date;

public class TicketService {
private GateRepository gateRepository;
    public Ticket issueTicket(IssueTicketRequest ticketRequest) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        gateRepository.findGateById(ticketRequest.getGetId());
        return null;
}
