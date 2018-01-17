CREATE DATABASE fcrespect_db;
CREATE SCHEMA IF NOT EXISTS storage;
CREATE TABLE IF NOT EXISTS storage.positions (
  position_id    SERIAL PRIMARY KEY,
  position_value VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS storage.players (
  player_id SERIAL PRIMARY KEY,
  full_name  VARCHAR(60)         NOT NULL,
  birthday   DATE                NOT NULL,
  image_name  VARCHAR(60),
  position_id   INTEGER             NOT NULL,
  FOREIGN KEY (position_id) REFERENCES storage.positions (position_id)
);

