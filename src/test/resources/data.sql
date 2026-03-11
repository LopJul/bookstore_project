INSERT INTO category (name)
VALUES ('sarjakuva'),
('dekkari'),
('dokumentti');

INSERT INTO book (title, author, publication_year, isbn, price, category_id)
VALUES
('Mökkimaailma', 'Mari Marinen', 1980, '1234-1', 12.90, 3),
('Puutarha', 'Minni Hiiri', 2020, '2131-1', 20.90, 1);

INSERT INTO application_user (username, password, role)
VALUES
('user', '$2a$10$xsSglTlHmiXBxLBh8lmR2uSIxj/B05AcHKcmWyNHkTZYs/.fEMiG6', 'USER'),
('admin', '$2a$10$kgsnf8QVsZmNe0jFm0mwmOc.EkZnq6yELdecrgC8Fw7Tz2gCcVrei', 'ADMIN');

