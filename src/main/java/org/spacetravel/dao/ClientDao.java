package org.spacetravel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spacetravel.db.hibernate.HibernateUtil;
import org.spacetravel.entity.Client;
import org.spacetravel.entity.validators.EntityValidator;

import java.util.List;

public class ClientDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDao.class.getCanonicalName());
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(client)) {
                EntityValidator.getAndLogViolations(client);
                tx.rollback();
            } else {
                session.persist(client);
                tx.commit();
            }
        } catch (Exception ex) {
            LOGGER.error("Error during persisting data: {}", ex.getMessage());
        }
    }

    public Client findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(client)) {
                EntityValidator.getAndLogViolations(client);
                tx.rollback();
            } else {
                session.merge(client);
                tx.commit();
            }
        } catch (Exception ex) {
            LOGGER.error("Error during merging data: {}", ex.getMessage());
        }
    }

    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
        } catch (Exception ex) {
            LOGGER.error("Error during deleting data: {}", ex.getMessage());
        }
    }

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
