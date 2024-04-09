package org.spacetravel.dao.ticket;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spacetravel.utils.hibernate.HibernateUtil;
import org.spacetravel.entity.Ticket;
import org.spacetravel.entity.validators.EntityValidator;

import java.util.List;

public class TicketDaoImpl implements TicketDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDaoImpl.class.getCanonicalName());
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public Ticket findByClientId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket c WHERE c.client.id = :id", Ticket.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Ticket> findByPlanetFrom(String planetId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket c WHERE c.fromPlanet.id = :planetId", Ticket.class)
                    .setParameter("planetId", planetId)
                    .list();
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Ticket> findByPlanetTo(String planetId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket c WHERE c.toPlanet.id = :planetId", Ticket.class)
                    .setParameter("planetId", planetId)
                    .list();
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(ticket)) {
                EntityValidator.getAndLogViolations(ticket);
                tx.rollback();
            } else {
                session.persist(ticket);
                tx.commit();
                LOGGER.info("Created/Persisted Ticket: {}", ticket);
            }
        } catch (Exception ex) {
            LOGGER.error("Error during persisting data: {}", ex.getMessage());
        }
    }

    @Override
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(ticket)) {
                EntityValidator.getAndLogViolations(ticket);
                tx.rollback();
            } else {
                session.merge(ticket);
                tx.commit();
                LOGGER.info("Updated/Merged Ticket: {}", ticket);
            }
        } catch (Exception ex) {
            LOGGER.error("Error during merging data: {}", ex.getMessage());
        }
    }

    @Override
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(ticket);
            tx.commit();
            LOGGER.info("Deleted/Removed Ticket: {}", ticket);
        } catch (Exception ex) {
            LOGGER.error("Error during deleting data: {}", ex.getMessage());
        }
    }
}
