package dev.godraadam.untold.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.untold.exception.BadRequestException;
import dev.godraadam.untold.exception.UnprocessableEntityException;
import dev.godraadam.untold.model.Concert;
import dev.godraadam.untold.model.Genre;
import dev.godraadam.untold.repo.ConcertRepo;

@Service
public class ConcertService {
    
    @Autowired
    private ConcertRepo concertRepo;

    public List<Concert> getConcertsForPerformer(String performer) {
        return concertRepo.findByPerformer(performer);
    }

    public List<Concert> getAllConcerts() {
        Iterable<Concert> iterable = concertRepo.findAll();
        List<Concert> concerts = new ArrayList<>();
        for (Concert it : iterable) {
            concerts.add(it);
        }
        return concerts;
    }

    public List<Concert> getConcertsByGenre(String genreString) throws BadRequestException {
        Genre genre;
        try {
            genre = Genre.valueOf(genreString.toUpperCase());
        } catch(IllegalArgumentException e) {
            throw new BadRequestException();
        }
        return concertRepo.findByGenre(genre);
    }

    public Concert addConcert(Concert concert) throws UnprocessableEntityException {
        if (concert.getTitle().isEmpty()) throw new UnprocessableEntityException();
        if (concert.getPerformer().isEmpty()) throw new UnprocessableEntityException();
        if (concert.getMaxTicketCount() <= 0) throw new UnprocessableEntityException();
        if (concert.getGenre() == Genre.NONE) throw new UnprocessableEntityException();
        return concertRepo.save(concert);
    }
}
