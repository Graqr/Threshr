DROP TABLE IF EXISTS harvestedItem;

CREATE TABLE harvestedItem (
                       id   SERIAL PRIMARY KEY,
                       name  VARCHAR(255) NOT NULL UNIQUE
);