package org.spacetravel.dao.planet;

import org.spacetravel.entity.Planet;
import java.util.List;

public interface PlanetDao {

    void save(Planet planet);
    Planet findById(String id);
    List<Planet> findByName(String name);
    void update(Planet planet);
    void delete(Planet planet);
}
