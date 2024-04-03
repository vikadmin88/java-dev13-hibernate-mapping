package org.spacetravel.db.hibernate;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spacetravel.entity.Client;
import org.spacetravel.entity.Planet;
import org.spacetravel.entity.Ticket;

@Getter
public class HibernateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class.getCanonicalName());

    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {

        LOGGER.info("Creating sessionFactory...");
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        this.sessionFactory.close();
    }

}
