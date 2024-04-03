package org.spacetravel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spacetravel.db.hibernate.HibernateUtil;
import org.spacetravel.entity.Planet;
import org.spacetravel.entity.validators.EntityValidator;

import java.util.List;

public class PlanetDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlanetDao.class.getCanonicalName());
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(planet)) {
                EntityValidator.getAndLogViolations(planet);
                tx.rollback();
            } else {
                session.persist(planet);
                tx.commit();
            }
        } catch (Exception ex) {
            LOGGER.error("Error during persisting data: {}", ex.getMessage());
        }
    }

    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    public List<Planet> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Planet c WHERE c.name like :name", Planet.class)
                    .setParameter("name", name)
                    .list();
        } catch (Exception ex) {
            LOGGER.error("Error during getting data: {}", ex.getMessage());
        }
        return null;
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            if (EntityValidator.isValidationFailed(planet)) {
                EntityValidator.getAndLogViolations(planet);
                tx.rollback();
            } else {
                session.merge(planet);
                tx.commit();
            }
        } catch (Exception ex) {
            LOGGER.error("Error during merging data: {}", ex.getMessage());
        }
    }

    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(planet);
            tx.commit();
        } catch (Exception ex) {
            LOGGER.error("Error during deleting data: {}", ex.getMessage());
        }
    }
}
