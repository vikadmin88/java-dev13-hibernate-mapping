package org.spacetravel.services;

import org.spacetravel.dao.ClientDao;
import org.spacetravel.entity.Client;

import java.util.List;

public class ClientCrudService {

    private final ClientDao clientDao = new ClientDao();

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public Client findClientById(Long id) {
        return clientDao.findById(id);
    }
    public List<Client> findClientByName(String name) {
        return clientDao.findByName(name);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
