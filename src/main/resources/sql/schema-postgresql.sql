-- CREATE DATABASE fcrespect_db;

CREATE TABLE IF NOT EXISTS players (
  players_id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('players_ids'),
  full_name  VARCHAR(60)         NOT NULL,
  birthday   DATE                NOT NULL,
  image_name  VARCHAR(60),
  position   INTEGER             NOT NULL,
  FOREIGN KEY (position) REFERENCES POSITION (position_id)
);

CREATE TABLE IF NOT EXISTS position (
  position_id    INTEGER     NOT NULL PRIMARY KEY DEFAULT NEXTVAL('position_ids'),
  position_title VARCHAR(30) NOT NULL UNIQUE
);
