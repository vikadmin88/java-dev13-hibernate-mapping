package org.spacetravel.services;

import org.spacetravel.dao.client.ClientDao;
import org.spacetravel.dao.client.ClientDaoImpl;
import org.spacetravel.entity.Client;

import java.util.List;

public class ClientCrudService {

    private final ClientDao client = new ClientDaoImpl();

    public void saveClient(Client client) {
        this.client.save(client);
    }

    public Client findClientById(Long id) {
        return client.findById(id);
    }
    public List<Client> findClientByName(String name) {
        return client.findByName(name);
    }

    public void updateClient(Client client) {
        this.client.update(client);
    }

    public void deleteClient(Client client) {
        this.client.delete(client);
    }

}
