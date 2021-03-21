package dev.godraadam.untold.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.untold.assembler.TicketAssembler;
import dev.godraadam.untold.dto.TicketDTO;
import dev.godraadam.untold.model.Ticket;
import dev.godraadam.untold.service.TicketService;

@RestController
@CrossOrigin
public class TicketResource {
    

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketAssembler ticketAssembler;

    @GetMapping("/api/ticket/{concertId}")
    public List<TicketDTO> getTicketsForConcert(@PathVariable Long concertId) {
        return ticketAssembler.createDTOList(ticketService.getTicketsForConcert(concertId));
    }


    @PostMapping("/api/ticket/sell")
    @ResponseStatus(HttpStatus.CREATED)
    public TicketDTO addTicket(@RequestBody TicketDTO dto) {

        Ticket ticket = ticketService.addTicket(ticketAssembler.createModel(dto));
        return ticketAssembler.createDTO(ticket);

    }
}
