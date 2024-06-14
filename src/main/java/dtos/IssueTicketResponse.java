package dtos;

import models.Ticket;

public class IssueTicketResponse {
    private Ticket ticket;
    private ResponseStatus status;
    private String message;

    public IssueTicketResponse(Ticket ticket) {
        this.ticket = ticket;
        this.status = ResponseStatus.SUCCESS;
        this.message = message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
