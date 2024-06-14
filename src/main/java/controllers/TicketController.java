package controllers;

import Services.TicketService;
import dtos.IssueTicketRequest;
import dtos.ResponseStatus;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotfoundException;
import models.Ticket;

public class TicketController {

     public  static String ticketIssueMessage = "Ticket issued successfully";
     public static String ticketIssueFailureMessage = "invalid gate id";
     public static String ParkingLotNotFoundMessage = "Parking lot not found";

     private TicketService ticketService;

     public IssueTicketRequest issueTicket(IssueTicketRequest ticketRequest) {
         Ticket ticket = null;
         try {
             ticket = ticketService.issueTicket(ticketRequest);
         } catch (GateNotFoundException e) {
             return new IssueTicketRequest(null, ResponseStatus.FAILURE, ticketIssueFailureMessage);
         } catch (ParkingLotNotfoundException e) {
                return new IssueTicketRequest(null, ResponseStatus.FAILURE, ParkingLotNotFoundMessage);
         }
         return new IssueTicketRequest(ticket, ResponseStatus.SUCCESS, ticketIssueMessage);

 }

}
