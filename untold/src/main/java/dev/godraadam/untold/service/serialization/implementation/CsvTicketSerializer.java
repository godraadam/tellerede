package dev.godraadam.untold.service.serialization.implementation;

import java.util.List;

import dev.godraadam.untold.model.Ticket;
import dev.godraadam.untold.service.serialization.TicketSerializer;

public class CsvTicketSerializer implements TicketSerializer{

    @Override
    public String serializeTicket(Ticket ticket) {
       return ticket.getId() + "," + ticket.getSeats() + "," + ticket.getConcert().getId() + "," + ticket.getPrice();
    }

    @Override
    public String serializeTicketList(List<Ticket> tickets) {
        return "id,seats,concertId,price" + tickets.stream().map(t->serializeTicket(t)).reduce("", (s1, s2) -> s1 + "\n" + s2);
    }
    
}
