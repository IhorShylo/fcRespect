CREATE DATABASE fcrespect_db;
CREATE USER respect WITH password 'respect';
GRANT ALL ON DATABASE fcrespect_db TO respect;

CREATE TABLE IF NOT EXISTS positions (
  position_id    SERIAL PRIMARY KEY,
  position_value VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS players (
  player_id SERIAL PRIMARY KEY,
  full_name  VARCHAR(60)         NOT NULL,
  birthday   DATE                NOT NULL,
  image_name  VARCHAR(60),
  position_id   INTEGER             NOT NULL,
  FOREIGN KEY (position_id) REFERENCES positions (position_id)
);

