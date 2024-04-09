package org.spacetravel.dao.client;


import org.spacetravel.entity.Client;

import java.util.List;

public interface ClientDao {
    Client findById(Long id);
    List<Client> findByName(String name);
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}
