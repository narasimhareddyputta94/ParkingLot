package controllers;

import Services.TicketService;
import dtos.IssueTicketRequest;
import dtos.ResponseStatus;
import exceptions.GateNotFoundException;
import models.Ticket;

public class TicketController {

     public  static String ticketIssueMessage = "Ticket issued successfully";
     public static String ticketIssueFailureMessage = "invalid gate id";

     private TicketService ticketService;

     public IssueTicketRequest issueTicket(IssueTicketRequest ticketRequest) {
         Ticket ticket = null;
         try {
             ticket = ticketService.issueTicket(ticketRequest);
         } catch (GateNotFoundException e) {
             return new IssueTicketRequest(null, ResponseStatus.FAILURE, ticketIssueFailureMessage);
         }
         return new IssueTicketRequest(ticket, ResponseStatus.SUCCESS, ticketIssueMessage);

 }

}
