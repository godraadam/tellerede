package dev.godraadam.untold.service.serialization.implementation;

import java.util.List;

import dev.godraadam.untold.model.Ticket;
import dev.godraadam.untold.service.serialization.TicketSerializer;

public class JsonTicketSerializer implements TicketSerializer {

    @Override
    public String serializeTicket(Ticket ticket) {
        return "{\n" +
        "\t\"id\":" + ticket.getId() + ",\n" +
        "\t\"seats\":" + ticket.getSeats() + ",\n" +
        "\t\"concertId\":" + ticket.getConcert().getId() + ",\n" +
        "\t\"price\":" + ticket.getPrice() + "\n" +
    "}";
    }

    @Override
    public String serializeTicketList(List<Ticket> tickets) {
        return "[\n" +
                    tickets.stream().map(t -> serializeTicket(t)).reduce("", (s1, s2) -> s1 + ",\n" + s2) +
                "\n]";
    }
    
}
