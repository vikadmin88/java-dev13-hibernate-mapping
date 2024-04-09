package org.spacetravel;


import org.spacetravel.db.flyway.DatabaseMigrationService;
import org.spacetravel.entity.Client;
import org.spacetravel.entity.Planet;
import org.spacetravel.entity.Ticket;
import org.spacetravel.services.ClientCrudService;
import org.spacetravel.services.PlanetCrudService;
import org.spacetravel.services.TicketCrudService;

import java.sql.Timestamp;

public class SpaceTravel {
        private static final ClientCrudService clientCrudService = new ClientCrudService();
        private static final PlanetCrudService planetCrudService = new PlanetCrudService();
        private static final TicketCrudService ticketCrudService = new TicketCrudService();

    public static void main(String[] args) {
        DatabaseMigrationService.doMigrate();
        ticketManipulation();
    }

    private static void ticketManipulation() {

        // Client
        String newClientName = "Vik-Tor";
        Client client = new Client();
        client.setName(newClientName);

        // Planet
        Planet planetFrom = planetCrudService.findPlanetById("VEN");
        Planet planetTo = planetCrudService.findPlanetById("URN");

        // Ticket
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        ticket.setFromPlanet(planetFrom);
        ticket.setToPlanet(planetTo);
        ticket.setClient(client);
        client.getTickets().add(ticket);

        clientCrudService.saveClient(client);

        // Get ticket
        ticket = ticketCrudService.findTicketByClientId(client.getId());
        System.out.println("ticket.getId() = " + ticket.getId());
        System.out.println("ticket.getClient().getId() = " + ticket.getClient().getId());
        System.out.println("ticket.getClient().getName() = " + ticket.getClient().getName());
        System.out.println("ticket.getCreatedAt() = " + ticket.getCreatedAt());
        System.out.println("ticket.getFromPlanet().getName() = " + ticket.getFromPlanet().getName());
        System.out.println("ticket.getToPlanet().getName() = " + ticket.getToPlanet().getName());

    }
}