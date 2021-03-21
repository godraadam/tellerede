package dev.godraadam.untold.assembler;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import dev.godraadam.untold.dto.ConcertDTO;
import dev.godraadam.untold.model.Concert;
import dev.godraadam.untold.model.Genre;

@Component
public class ConcertAssembler implements GeneralAssembler<ConcertDTO, Concert>{

    private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public Concert createModel(ConcertDTO dto) {
        Concert concert = new Concert();
        concert.setId(dto.getId());
        concert.setTitle(dto.getTitle());
        try {
            concert.setGenre(Genre.valueOf(dto.getGenre()));
        } catch(IllegalArgumentException e) {
            concert.setGenre(Genre.NONE);
        }
        concert.setPerformer(dto.getPerformer());
        concert.setMaxTicketCount(dto.getMaxTicketCount());
        concert.setStartTime(LocalDateTime.parse(dto.getStartingDate(), dtf));
        concert.setEndTime(LocalDateTime.parse(dto.getEndingDate(), dtf));
        return concert;
    }

    @Override
    public ConcertDTO createDTO(Concert model) {
        ConcertDTO dto = new ConcertDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setGenre(model.getGenre().name());
        dto.setPerformer(model.getPerformer());
        dto.setMaxTicketCount(model.getMaxTicketCount());
        dto.setStartingDate(dtf.format(model.getStartTime()));
        dto.setEndingDate(dtf.format(model.getEndTime()));
        return dto;
    }
    
}
