package dev.godraadam.untold.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.godraadam.untold.model.Concert;
import dev.godraadam.untold.model.Genre;

public interface ConcertRepo extends CrudRepository<Concert, Long> {
    public List<Concert> findByPerformer(String performer);
    public List<Concert> findByGenre(Genre genre);
}
