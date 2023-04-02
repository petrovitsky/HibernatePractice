CREATE TABLE IF NOT EXISTS person(
    id IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS person_address(
    person_id BIGINT,
    address   VARCHAR(100),
    FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE CASCADE
);