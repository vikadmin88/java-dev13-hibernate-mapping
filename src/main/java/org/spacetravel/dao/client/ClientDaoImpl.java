package org.spacetravel.dao.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spacetravel.utils.hibernate.HibernateUtil;
import org.spacetravel.entity.Client;
import org.spacetravel.entity.validators.EntityValidator;

import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoImpl.class.getCanonicalName());
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(client)) {
                EntityValidator.getAndLogViolations(client);
                tx.rollback();
            } else {
                session.persist(client);
                tx.commit();
                LOGGER.info("Created/Persisted Client: {}", client);
            }
        } catch (Exception ex) {
            LOGGER.error("Error during persisting data: {}", ex.getMessage());
        }
    }

    @Override
    public Client findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Client client = session.get(Client.class, id);
            client.getTickets().size();
            return client;
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(client)) {
                EntityValidator.getAndLogViolations(client);
                tx.rollback();
            } else {
                session.merge(client);
                tx.commit();
                LOGGER.info("Updated/Merged Client: {}", client);
            }
        } catch (Exception ex) {
            LOGGER.error("Error during merging data: {}", ex.getMessage());
        }
    }

    @Override
    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
            LOGGER.info("Deleted/Removed Client: {}", client);
        } catch (Exception ex) {
            LOGGER.error("Error during deleting data: {}", ex.getMessage());
        }
    }

    @Override
    public List<Client> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Client c WHERE c.name like :name", Client.class)
                    .setParameter("name", name)
                    .list();
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }
}
