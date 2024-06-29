CREATE TABLE IF NOT EXISTS roles
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

    name        VARCHAR UNIQUE NOT NULL,
    description TEXT UNIQUE    NOT NULL
);

COMMENT ON TABLE roles IS 'Роли пользователей';

COMMENT ON COLUMN roles.id IS 'ID';
COMMENT ON COLUMN roles.name IS 'Название';
COMMENT ON COLUMN roles.description IS 'Описание';

CREATE OR REPLACE FUNCTION get_role_id(role_name VARCHAR)
    RETURNS BIGINT
    LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN (SELECT id FROM roles WHERE name = role_name);
END;
$$;

CREATE OR REPLACE FUNCTION check_role_name_function()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$$
BEGIN
    IF
        NEW.name NOT LIKE 'ROLE_%'
    THEN
        RAISE EXCEPTION 'Название роли должно начинаться с ''ROLE_''';
    END IF;

    RETURN NEW;
END;
$$;

CREATE OR REPLACE TRIGGER check_role_name_trigger
    BEFORE INSERT OR UPDATE
    ON roles
    FOR EACH ROW
EXECUTE FUNCTION check_role_name_function();

INSERT INTO roles (name, description)
VALUES ('ROLE_OWNER', 'Владелец'),
       ('ROLE_ADMIN', 'Админ'),
       ('ROLE_USER', 'Пользователь');
