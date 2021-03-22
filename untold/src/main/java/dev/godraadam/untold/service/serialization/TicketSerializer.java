package dev.godraadam.untold.service.serialization;

import java.util.List;

import dev.godraadam.untold.model.Ticket;

public interface TicketSerializer {
    
    String serializeTicket(Ticket ticket);
    String serializeTicketList(List<Ticket> tickets);

}
