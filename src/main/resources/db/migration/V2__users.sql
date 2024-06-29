CREATE TABLE IF NOT EXISTS users
(
    id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

    name         VARCHAR                                              NOT NULL,
    phone_number VARCHAR(16) CHECK (LENGTH(phone_number) = 16) UNIQUE NOT NULL,

    location_id  BIGINT REFERENCES locations (id) ON DELETE SET NULL ON UPDATE CASCADE
);

COMMENT ON TABLE users IS 'Пользователи';

COMMENT ON COLUMN users.id IS 'ID';
COMMENT ON COLUMN users.name IS 'Имя';
COMMENT ON COLUMN users.phone_number IS 'Номер телефона';
COMMENT ON COLUMN users.location_id IS 'ID населенного пункта';

CREATE OR REPLACE FUNCTION get_user_id(user_phone_number VARCHAR)
    RETURNS BIGINT
    LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN (SELECT id FROM users WHERE phone_number = user_phone_number);
END;
$$;

INSERT INTO users (name, phone_number, location_id)
VALUES ('Михаил', '+7-996-380-03-61', get_location_id('Новосибирск'));
