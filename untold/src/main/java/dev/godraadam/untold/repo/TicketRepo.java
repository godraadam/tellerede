package dev.godraadam.untold.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.godraadam.untold.model.Ticket;

public interface TicketRepo extends CrudRepository<Ticket, Long> {
    public List<Ticket> findByConcertId(Long id);
}
