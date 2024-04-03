package org.spacetravel.db.flyway;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spacetravel.utils.HibernatePropertyReader;

public class DatabaseMigrationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseMigrationService.class.getCanonicalName());

    public static void doMigrate() {
        LOGGER.info("H2: migrating database scheme...");
        String h2connUrl = HibernatePropertyReader.getConnectionUrlForH2();
        Flyway flyway = Flyway.configure().dataSource(h2connUrl, null, null).load();
        flyway.migrate();
    }
}
