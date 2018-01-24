--------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS positions (
  position_id    SERIAL,
  position_value VARCHAR(30) NOT NULL,

  PRIMARY KEY (position_id),
  CONSTRAINT uk_value_check UNIQUE (position_value),
  CONSTRAINT position_value_check CHECK (position_value <> '')
);

ALTER TABLE positions OWNER TO fcrespect;

--------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS players (
  player_id   SERIAL,
  full_name   VARCHAR(60) NOT NULL,
  birthday    DATE        NOT NULL,
  image_name  VARCHAR(60),
  position_id INTEGER     NOT NULL,
  about       TEXT,

  PRIMARY KEY (player_id),
  FOREIGN KEY (position_id) REFERENCES positions (position_id),
  CONSTRAINT birthday_check CHECK (birthday >= '1900-01-01')
);

ALTER TABLE players OWNER TO fcrespect;

--------------------------------------------------------------------------------------

