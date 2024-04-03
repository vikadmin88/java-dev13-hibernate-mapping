--SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS planet;
--SET REFERENTIAL_INTEGRITY TRUE;

CREATE TABLE IF NOT EXISTS client
(
    id   LONG AUTO_INCREMENT NOT NULL,
    name VARCHAR(200)      NOT NULL,
    CONSTRAINT client_pk PRIMARY KEY (id),
    CONSTRAINT client_name_length CHECK (length(name) > 2)
);

CREATE TABLE IF NOT EXISTS planet
(
    id    VARCHAR(10)    NOT NULL,
    name  VARCHAR(500)   NOT NULL,
    CONSTRAINT planet_pk PRIMARY KEY (id),
    CONSTRAINT planet_id_length CHECK (length(id) > 0),
    CONSTRAINT planet_name_length CHECK (length(name) > 0)
);


CREATE TABLE IF NOT EXISTS ticket
(
    id             LONG AUTO_INCREMENT NOT NULL,
    created_at     TIMESTAMP   NOT NULL,
    client_id      LONG        NOT NULL,
    from_planet_id VARCHAR(10) NOT NULL,
    to_planet_id   VARCHAR(10) NOT NULL,
    CONSTRAINT ticket_pk PRIMARY KEY (id),
    CONSTRAINT client_fk FOREIGN KEY (client_id) REFERENCES client (id),
    CONSTRAINT from_planet_id_length CHECK (length(from_planet_id) > 0),
    CONSTRAINT to_planet_id_length   CHECK (length(to_planet_id) > 0)
);


