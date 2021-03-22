package dev.godraadam.untold.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.untold.exception.ResourceConflictException;
import dev.godraadam.untold.exception.ResourceNotFoundException;
import dev.godraadam.untold.model.Ticket;
import dev.godraadam.untold.repo.ConcertRepo;
import dev.godraadam.untold.repo.TicketRepo;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private ConcertRepo concertRepo;

    public List<Ticket> getTicketsForConcert(Long concertId) throws ResourceNotFoundException {
        if(concertRepo.findById(concertId).isEmpty()) throw new ResourceNotFoundException();
        return ticketRepo.findByConcertId(concertId);
    }

    public Ticket addTicket(Ticket ticket) throws ResourceConflictException {
        List<Ticket> tickets = getTicketsForConcert(ticket.getConcert().getId());
        Long nrOfTicketsSold = tickets.stream().map(t -> t.getSeats()).reduce(0L, Long::sum);
        if (nrOfTicketsSold + ticket.getSeats() > ticket.getConcert().getMaxTicketCount()) {
            throw new ResourceConflictException();
        }
        return ticketRepo.save(ticket);
    }
}
