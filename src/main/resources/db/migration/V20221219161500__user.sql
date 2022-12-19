CREATE TABLE users (
        id BIGSERIAL PRIMARY KEY,
        login varchar(255) NOT NULL,
        password varchar(255) NOT NULL
);

CREATE INDEX users_login_idx ON users (login);
CREATE INDEX users_password_idx ON users (password);