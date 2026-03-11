CREATE TABLE category (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(150) NOT NULL
);

CREATE TABLE book (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  author VARCHAR(150) NOT NULL,
  publication_year INT,
  isbn VARCHAR(20),
  price DOUBLE PRECISION,
  category_id BIGINT REFERENCES category(id)
);

CREATE TABLE application_user (
  id BIGSERIAL PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  role VARCHAR(250) NOT NULL
);