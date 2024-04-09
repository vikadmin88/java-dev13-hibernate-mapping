package org.spacetravel.services;

import org.spacetravel.dao.planet.PlanetDao;
import org.spacetravel.dao.planet.PlanetDaoImpl;
import org.spacetravel.entity.Planet;

import java.util.List;

public class PlanetCrudService {

    private final PlanetDao planet = new PlanetDaoImpl();

    public void savePlanet(Planet planet) {
        this.planet.save(planet);
    }

    public Planet findPlanetById(String id) {
        return planet.findById(id);
    }

    public List<Planet> findPlanetByName(String name) {
        return planet.findByName(name);
    }
    public void updatePlanet(Planet planet) {
        this.planet.update(planet);
    }

    public void deletePlanet(Planet planet) {
        this.planet.delete(planet);
    }
}
