package org.spacetravel.services;



import org.spacetravel.dao.ticket.TicketDaoImpl;
import org.spacetravel.entity.Ticket;

import java.util.List;

public class TicketCrudService {
    private final TicketDaoImpl ticket = new TicketDaoImpl();

    public void saveTicket(Ticket ticket) {
        this.ticket.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return ticket.findById(id);
    }

    public Ticket findTicketByClientId(Long id) {
        return ticket.findByClientId(id);
    }

    public List<Ticket> findTicketByPlanetFrom(String name) {
        return ticket.findByPlanetFrom(name);
    }

    public List<Ticket> findTicketByPlanetTo(String name) {
        return ticket.findByPlanetTo(name);
    }

    public void updateTicket(Ticket ticket) {
        this.ticket.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        this.ticket.delete(ticket);
    }
}
