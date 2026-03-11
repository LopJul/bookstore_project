-- Poistetaan taulut oikeassa järjestyksessä riippuvuuksien takia
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;

DROP TABLE IF EXISTS application_user;

-- luodaan taulu
CREATE TABLE category (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(150) NOT NULL
);

--lisätään pari riviä
INSERT INTO category (name)
VALUES 
('elämänkerta'), 
('fantasia');

-- luodaan taulu
CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(150) NOT NULL,
    publication_year INT,
    isbn VARCHAR(20),
    price DOUBLE PRECISION,
	category_id BIGINT REFERENCES category(id)
);

--lisätään rivejä tauluun
INSERT INTO book (title, author, publication_year, isbn, price, category_id) 
VALUES 
('Harry Potter ja Viisasten kivi', 'J. K. Rowling', '1998', '150574-113', 20.90, 1),
('Musta laatikko', 'Jarno Alastalo', '2025', '250170-231', 25.90, 2);

--application_user-taulu
CREATE TABLE application_user (
id BIGSERIAL PRIMARY KEY,
username VARCHAR(250) NOT NULL,
password VARCHAR(250) NOT NULL,
role VARCHAR(250) NOT NULL
);

INSERT INTO application_user(username, password, role)
VALUES
('user', '$2a$10$1DTvwpXVBArGFixHBuzVJObjTuXhIOkx5pse6KsYs8/C2ckxnGEou', 'USER'),
('admin', '$2a$10$cDZgyF4xaPMmmoRW3OVcmuf.8o2YSx8.M7CeRKqi.1PVw.t3E8uEC', 'ADMIN');

select * from book;