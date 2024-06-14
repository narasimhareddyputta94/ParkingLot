package controllers;

import Services.TicketService;
import dtos.IssueTicketRequest;
import dtos.ResponseStatus;
import models.Ticket;

public class TicketController {

     public  static String ticketIssueMessage = "Ticket issued successfully";
     private TicketService ticketService;

     public IssueTicketRequest issueTicket(IssueTicketRequest ticketRequest) {
        Ticket ticket = ticketService.issueTicket(ticketRequest);
         return new IssueTicketRequest(ticket, ResponseStatus.SUCCESS, ticketIssueMessage);

 }

}
