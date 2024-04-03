package org.spacetravel;


import org.spacetravel.db.flyway.DatabaseMigrationService;
import org.spacetravel.entity.Client;
import org.spacetravel.entity.Planet;
import org.spacetravel.services.ClientCrudService;
import org.spacetravel.services.PlanetCrudService;

import java.util.List;

public class SpaceTravel {

    public static void main(String[] args) {
        DatabaseMigrationService.doMigrate();
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        clientManipulation(clientCrudService);
        planetManipulation(planetCrudService);
    }

    private static void clientManipulation(ClientCrudService clientCrudService) {
        // Create new client
        String clientName = "VikTor";
        Client client = new Client();
        client.setName(clientName);
        clientCrudService.saveClient(client);
        System.out.println("\nTests:\nClient\nCreated client with name: " + clientName);

        // Read the client by Name
        List<Client> clientList = clientCrudService.findClientByName(clientName);
        if (!clientList.isEmpty()) {
            clientList.forEach(it -> System.out.printf("Found Client by name: %s\n", it.getName()));
        }

        // Read client by id
        client = clientCrudService.findClientById(11L);
        System.out.println("Found client by Id 1: " + client.getName());

        // Update client
        client.setName("John Doe");
        clientCrudService.updateClient(client);
        System.out.println("Update client by Id 1 to name John Doe");

        // Read client by id
        client = clientCrudService.findClientById(11L);
        System.out.println("Found client by Id 1: " + client.getName());

        // Delete client
        clientCrudService.deleteClient(client);
        System.out.println("Delete client by Id 1");

        // Read client by id
        client = clientCrudService.findClientById(11L);
        System.out.println("Find client by Id 1: " + client);
    }

    private static void planetManipulation(PlanetCrudService planetCrudService) {
        // Create new planet
        String planetId = "VIK";
        String planetName = "Vik-Tor";
        Planet planet = new Planet();
        planet.setId(planetId);
        planet.setName(planetName);
        planetCrudService.savePlanet(planet);
        System.out.printf("\nTests:\nPlanet\nCreated planet with: Id %s, name %s\n", planetId, planetName);

        // Read the planet by Name
        List<Planet> planetList = planetCrudService.findPlanetByName(planetName);
        if (!planetList.isEmpty()) {
            planetList.forEach(it -> System.out.printf("Found Planet by name: %s\n", it.getName()));
        }

        // Read planet by id
        planet = planetCrudService.findPlanetById(planetId);
        System.out.println("Found planet by Id VIK: " + planet.getName());

        // Update planet
        planet.setName("Mercury");
        planetCrudService.updatePlanet(planet);
        System.out.println("Update planet by Id VIK to name Mercury");

        // Read planet by id
        planet = planetCrudService.findPlanetById(planetId);
        System.out.println("Found planet by Id VIK: " + planet.getName());

        // Delete planet
        planetCrudService.deletePlanet(planet);
        System.out.println("Delete planet by Id " + planetId);

        // Read planet by id
        planet = planetCrudService.findPlanetById(planetId);
        System.out.println("Find planet by Id VIK: " + planet);
    }
}