package org.spacetravel.dao.ticket;

import org.spacetravel.entity.Ticket;

import java.util.List;

public interface TicketDao {
    Ticket findById(Long id);
    List<Ticket> findByPlanetFrom(String name);
    List<Ticket> findByPlanetTo(String name);
    Ticket findByClientId(Long id);
    void save(Ticket ticket);
    void update(Ticket ticket);
    void delete(Ticket ticket);
}
