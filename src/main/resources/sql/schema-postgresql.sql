CREATE DATABASE fcrespect_db;

CREATE TABLE IF NOT EXISTS positions (
  position_id    INTEGER     NOT NULL PRIMARY KEY DEFAULT NEXTVAL('positions_ids'),
  position_value VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS players (
player_id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('players_ids'),
full_name  VARCHAR(60)         NOT NULL,
birthday   DATE                NOT NULL,
image_name  VARCHAR(60),
position_id   INTEGER             NOT NULL,
FOREIGN KEY (position_id) REFERENCES POSITIONS (position_id)
);

