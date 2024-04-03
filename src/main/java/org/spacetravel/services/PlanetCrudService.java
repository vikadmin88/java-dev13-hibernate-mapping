package org.spacetravel.services;

import org.spacetravel.dao.PlanetDao;
import org.spacetravel.entity.Planet;

import java.util.List;

public class PlanetCrudService {

    private final PlanetDao planetDao = new PlanetDao();

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public Planet findPlanetById(String id) {
        return planetDao.findById(id);
    }

    public List<Planet> findPlanetByName(String name) {
        return planetDao.findByName(name);
    }
    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }
}
