package org.spacetravel;


import org.spacetravel.db.flyway.DatabaseMigrationService;
import org.spacetravel.entity.Client;
import org.spacetravel.entity.Planet;
import org.spacetravel.entity.Ticket;
import org.spacetravel.services.ClientCrudService;
import org.spacetravel.services.PlanetCrudService;
import org.spacetravel.services.TicketCrudService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpaceTravel {
        private static final ClientCrudService clientCrudService = new ClientCrudService();
        private static final PlanetCrudService planetCrudService = new PlanetCrudService();
        private static final TicketCrudService ticketCrudService = new TicketCrudService();

    public static void main(String[] args) {
        DatabaseMigrationService.doMigrate();

//        clientManipulation();
//        planetManipulation();
        ticketManipulation();
    }

    private static void ticketManipulation() {
//        Client client = clientCrudService.findClientById(1L);
//        System.out.println("client = " + client.getName());

//        Ticket ticketTest = ticketCrudService.findTicketById(1L);
//        System.out.println("ticketTest client name = " + ticketTest.getClient().getName());
//        System.out.println("ticketTest created at = " + ticketTest.getCreatedAt());
//        System.out.println("ticketTest = FromPlanet " + ticketTest.getFromPlanet().getName());
//        System.out.println("ticketTest = ToPlanet " + ticketTest.getToPlanet().getName());
//
//        Planet planet = planetCrudService.findPlanetById("MOO");
//        System.out.println("planet name = " + planet.getName());
//
//        System.out.println("ticketsByPlanetFrom: " + planet.getName());
//        List<Ticket> ticketsByPlanetFrom = ticketCrudService.findTicketByPlanetFrom(planet.getId());
//        ticketsByPlanetFrom.forEach(t -> {
//            System.out.println("t.getId() = " + t.getId());
//            System.out.println("t.getCreatedAt() = " + t.getCreatedAt());
//            System.out.println("t.getClient().getName() = " + t.getClient().getName());
//            System.out.println("t.getFromPlanet().getName() = " + t.getFromPlanet().getName());
//            System.out.println("t.getToPlanet().getName() = " + t.getToPlanet().getName());
//        });
//
//        System.out.println("ticketsByPlanetTo: " + planet.getName());
//        List<Ticket> ticketsByPlanetTo = ticketCrudService.findTicketByPlanetTo(planet.getId());
//        ticketsByPlanetTo.forEach(t -> {
//            System.out.println("t.getId() = " + t.getId());
//            System.out.println("t.getCreatedAt() = " + t.getCreatedAt());
//            System.out.println("t.getClient().getName() = " + t.getClient().getName());
//            System.out.println("t.getFromPlanet().getName() = " + t.getFromPlanet().getName());
//            System.out.println("t.getToPlanet().getName() = " + t.getToPlanet().getName());
//        });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");

        // Client
        String newClientName = "Vik-Tor";
        Client client = new Client();
//        client.setId(14L);
        client.setName(newClientName);
//        client = clientCrudService.findClientById(14L);
//        clientCrudService.saveClient(client);
//        Long clientId = client.getId();
//        System.out.println("New client.getId() = " + clientId);
//        System.out.println("client = " + client);
        Ticket ticket = new Ticket();

        // Planet
        Planet planetFrom = new Planet();
        Planet pFrom = planetCrudService.findPlanetById("VEN");
        Planet pTo = planetCrudService.findPlanetById("URN");
//        System.out.println("planetFrom = " + pFrom.getFromPlanet());
//        planetFrom.setId(pFrom.getId());
//        planetFrom.setName(pFrom.getName());
//        planetFrom.setFromPlanet(pFrom);
//        planetFrom.getFromPlanet().add(ticket);
//        planetFrom.getToPlanet().add(ticket);

        planetFrom = pFrom;

//        Planet planetFrom = new Planet();
//        planetFrom.setId("SRCPL");
//        planetFrom.setName("FromPlanet");

        Planet planetTo = new Planet();
        planetTo.setId("DSTPL");
        planetTo.setName("ToPlanet");

        planetTo = pTo;

//        planetCrudService.savePlanet(planetFrom);
//        planetCrudService.savePlanet(planetTo);

        // Ticket
        // TODO check for null
//        System.out.println("ticket = " + ticket);
//        System.out.println("client.getTickets() = " + client.getTickets());
        ticket.setCreatedAt(new Timestamp(System.currentTimeMillis()));
//        System.out.println("ticket before setFrom... = " + ticket);

        ticket.setFromPlanet(planetFrom);
        ticket.setToPlanet(planetTo);
//        System.out.println("ticket before save = " + ticket);
//        ticketCrudService.saveTicket(ticket);
//        System.out.println("ticket after save = " + ticket);

        ticket.setClient(client);
        client.getTickets().add(ticket);

//        ticketCrudService.saveTicket(ticket);
//        ticketCrudService.updateTicket(ticket);

//        client.addTicket(ticket);
        clientCrudService.saveClient(client);
//        clientCrudService.updateClient(client);

        Long clientId = client.getId();
        System.out.println("clientId = " + clientId);

//        System.out.println("client = " + client);

        client = clientCrudService.findClientById(clientId);
        client.getTickets().forEach(it -> System.out.println(it.getId()));
        System.out.println("client.getTickets().size() = " + client.getTickets().size());
        System.out.println("client.getTickets = " );

        // Get ticket
//        ticket = ticketCrudService.findTicketByClientId(client.getId());
//        System.out.println("ticket.getId() = " + ticket.getId());
//        System.out.println("ticket.getCreatedAt() = " + ticket.getCreatedAt());
//        System.out.println("ticket.getClient().getName() = " + ticket.getClient().getName());
//        System.out.println("ticket.getFromPlanet().getName() = " + ticket.getFromPlanet().getName());
//        System.out.println("ticket.getToPlanet().getName() = " + ticket.getToPlanet().getName());

    }


    private static void clientManipulation() {
        // Create new client
        String clientName = "VikTor";
        System.out.println("\nTests:\nClient\nCreated client with name: " + clientName);
        Client client = new Client();
        client.setName(clientName);
        clientCrudService.saveClient(client);

        long lastClientId = 0;

        // Read the client by Name
        System.out.printf("Find Client by name: %s\n", clientName);
        List<Client> clientList = clientCrudService.findClientByName(clientName);
        if (!clientList.isEmpty()) {
            clientList.forEach(it -> System.out.printf("Found Client by name: %s\n", it.getName()));
        }

        // Read client by id
        System.out.printf("Find Client by id: %d\n", lastClientId);
        client = clientCrudService.findClientById(lastClientId);
        System.out.printf("Found client by Id %d: %s\n", lastClientId, client.getName());

        // Update client
        System.out.printf("Update Client by id: %d, set name John Doe\n", lastClientId);
        client.setName("John Doe");
        clientCrudService.updateClient(client);

        // Read client by id
        System.out.printf("Find Client by id: %d\n", lastClientId);
        client = clientCrudService.findClientById(lastClientId);
        System.out.printf("Found client by Id %d: with name: %s\n", lastClientId, client.getName());

        // Delete client
        System.out.printf("Delete client by Id %d\n", lastClientId);
        clientCrudService.deleteClient(client);

        // Read client by id
        System.out.printf("Find client by Id %d:\n", lastClientId);
        client = clientCrudService.findClientById(lastClientId);
        System.out.printf("Client by Id %d, %s\n", lastClientId, client);
    }

    private static void planetManipulation() {
        // Create new planet
        String planetId = "VIK";
        String planetName = "VikTor-Planet";
        System.out.printf("\nTests:\nPlanet\nCreated planet with: Id %s, name %s\n", planetId, planetName);
        Planet planet = new Planet();
        planet.setId(planetId);
        planet.setName(planetName);
        planetCrudService.savePlanet(planet);

        // Read the planet by Name
        System.out.printf("Find Planet by name: %s\n", planetName);
        List<Planet> planetList = planetCrudService.findPlanetByName(planetName);
        if (!planetList.isEmpty()) {
            planetList.forEach(it -> System.out.printf("Found Planet by name: %s with Id: %s\n", it.getName(), it.getId()));
        }

        // Read planet by id
        System.out.printf("Find Planet by id: %s\n", planetId);
        planet = planetCrudService.findPlanetById(planetId);
        System.out.printf("Found planet by Id %s: Name: %s\n", planetId, planet.getName());

        // Update planet
        String newPlanetName = "Mercury";
        System.out.printf("Change Planet name from %s to '%s' by id: %s\n", planet.getName(), newPlanetName, planetId);
        planet.setName(newPlanetName);
        planetCrudService.updatePlanet(planet);
        System.out.printf("Changed planet by Id '%s' to name '%s'\n", planetId, newPlanetName);

        // Read planet by id
        System.out.printf("Find Planet by id: %s\n", planetId);
        planet = planetCrudService.findPlanetById(planetId);
        System.out.printf("Found planet by Id: %s, name: %s\n", planetId, planet.getName());

        // Delete planet
        System.out.printf("Delete Planet  %s\n", planet);
//        System.out.println("planet.getFromPlanet() = " + planet.getFromPlanet());
//        System.out.println("planet.getToPlanet() = " + planet.getToPlanet());
        planetCrudService.deletePlanet(planet);
        System.out.println("Deleted planet: " + planet);

        // Read planet by id
        System.out.printf("Find Planet by id: %s\n", planetId);
        planet = planetCrudService.findPlanetById(planetId);
        System.out.printf("Found planet by Id %s: %s\n", planetId, planet);
    }
}