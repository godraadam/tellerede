package dev.godraadam.untold.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.untold.assembler.ConcertAssembler;
import dev.godraadam.untold.dto.ConcertDTO;
import dev.godraadam.untold.model.Concert;
import dev.godraadam.untold.service.ConcertService;

@RestController
@CrossOrigin
public class ConcertResource {

    @Autowired
    private ConcertService concertService;

    @Autowired
    private ConcertAssembler concertAssembler;

    @GetMapping("api/concert/all")
    public List<ConcertDTO> getConcerts() {
        
        return concertAssembler.createDTOList(concertService.getAllConcerts());
    }

    @GetMapping("api/concert/genre/{genre}")
    public List<ConcertDTO> getConcertsByGenre(@PathVariable String genre) {
        
        return concertAssembler.createDTOList(concertService.getConcertsByGenre(genre));
    }

    @GetMapping("api/concert/performer/{performer}")
    public List<ConcertDTO> getConcertsByPerformer(@PathVariable String performer) {
        return concertAssembler.createDTOList(concertService.getConcertsForPerformer(performer));
    }

    @PostMapping("api/concert/add")
    public Concert addConcert(@RequestBody ConcertDTO dto) {
        return concertService.addConcert(concertAssembler.createModel(dto));
    }

}
