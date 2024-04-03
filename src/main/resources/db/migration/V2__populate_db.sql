INSERT INTO client (name)
VALUES ('King'),
       ('Santa'),
       ('Claus'),
       ('Bruce'),
       ('Willis'),
       ('Alise'),
       ('Vik'),
       ('Tor'),
       ('Ajax'),
       ('Bill');

INSERT INTO planet (id, name)
VALUES ('MOO', 'Moon'),
       ('VEN', 'Venus'),
       ('SAT', 'Saturn'),
       ('MRS', 'Mars'),
       ('URN', 'Uranus');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES (NOW(), 1, 'MOO', 'VEN'),
       (NOW(), 2, 'VEN', 'SAT'),
       (NOW(), 3, 'SAT', 'MRS'),
       (NOW(), 4, 'MRS', 'URN'),
       (NOW(), 5, 'URN', 'MOO'),
       (NOW(), 6, 'MOO', 'URN'),
       (NOW(), 7, 'VEN', 'MRS'),
       (NOW(), 8, 'SAT', 'MOO'),
       (NOW(), 9, 'MRS', 'URN'),
       (NOW(), 10, 'URN', 'MRS');

