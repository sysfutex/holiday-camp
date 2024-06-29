CREATE TABLE IF NOT EXISTS locations
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

    name VARCHAR UNIQUE NOT NULL
);

COMMENT ON TABLE locations IS 'Населенные пункты';

COMMENT ON COLUMN locations.id IS 'ID';
COMMENT ON COLUMN locations.name IS 'Название';

CREATE OR REPLACE FUNCTION get_location_id(location_name VARCHAR)
    RETURNS BIGINT
    LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN (SELECT id FROM locations WHERE name = location_name);
END;
$$;

INSERT INTO locations (name)
VALUES ('Москва'),
       ('Новосибирск'),
       ('Красноярск'),
       ('Томск'),
       ('Барнаул'),
       ('Кемерово');
