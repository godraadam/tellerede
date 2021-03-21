package dev.godraadam.untold.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.godraadam.untold.dto.TicketDTO;
import dev.godraadam.untold.model.Ticket;
import dev.godraadam.untold.repo.ConcertRepo;

@Component
public class TicketAssembler implements GeneralAssembler<TicketDTO, Ticket> {


    @Autowired
    private ConcertRepo concertRepo;

    @Override
    public Ticket createModel(TicketDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setPrice(dto.getPrice());
        ticket.setSeats(dto.getSeats());
        ticket.setConcert(concertRepo.findById(dto.getConcertId()).orElse(null));
        return ticket;
    }

    @Override
    public TicketDTO createDTO(Ticket model) {
        TicketDTO dto = new TicketDTO();
        dto.setPrice(model.getPrice());
        dto.setSeats(model.getSeats());
        dto.setId(model.getId());
        dto.setConcertId(model.getConcert().getId());
        return dto;
    }
    
}
