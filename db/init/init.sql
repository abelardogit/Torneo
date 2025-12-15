-- ==========================================
-- RESET (solo para desarrollo)
-- ==========================================
DROP TABLE IF EXISTS user_tournament;
DROP TABLE IF EXISTS tournaments;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS users;

-- ==========================================
-- USERS
-- ==========================================
CREATE TABLE users (
    user_id       SERIAL PRIMARY KEY,
    first_name    VARCHAR(100),
    last_name     VARCHAR(100),
    email         VARCHAR(250) UNIQUE NOT NULL,
    password_hash VARCHAR(250) NOT NULL,
    username      VARCHAR(50) UNIQUE NOT NULL,

    -- IDs opcionales por juego
    riot_id       VARCHAR(50),
    epic_id       VARCHAR(50),
    fifa_id       VARCHAR(50),

    -- Rol del usuario
    role          VARCHAR(20) DEFAULT 'user'
);

-- ==========================================
-- GAMES
-- ==========================================
CREATE TABLE games (
    game_id        SERIAL PRIMARY KEY,
    game_name      VARCHAR(100) NOT NULL,
    img_banner     TEXT,
    img_card       TEXT,
    description    TEXT,
    associated_id  VARCHAR(50)
);

-- ==========================================
-- TOURNAMENTS
-- ==========================================
CREATE TABLE tournaments (
    tournament_id          SERIAL PRIMARY KEY,
    game_id                INT REFERENCES games(game_id),
    tournament_name        VARCHAR(150) NOT NULL,
    tournament_description TEXT,
    start_datetime         TIMESTAMP,
    end_datetime           TIMESTAMP,
    platform               VARCHAR(100)
);

-- ==========================================
-- USER_TOURNAMENT
-- ==========================================
CREATE TABLE user_tournament (
    user_id       INT REFERENCES users(user_id),
    tournament_id INT REFERENCES tournaments(tournament_id),
    PRIMARY KEY (user_id, tournament_id)
);
