--------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS positions (
  position_id    SERIAL,
  position_value VARCHAR(30) NOT NULL,

  PRIMARY KEY (position_id),
  CONSTRAINT uk_position_value UNIQUE (position_value),
  CONSTRAINT position_value_check CHECK (position_value <> '')
);

ALTER TABLE positions
  OWNER TO fcrespect;

--------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS statistic (
  statistic_id SERIAL,
  in_club      DATE DEFAULT '2014-01-01'        NOT NULL,
  games        INTEGER DEFAULT 0                NOT NULL,
  goals        INTEGER DEFAULT 0                NOT NULL,
  assists      INTEGER DEFAULT 0                NOT NULL,

  PRIMARY KEY (statistic_id),
  CONSTRAINT in_club_check CHECK (in_club >= '2014-01-01'),
  CONSTRAINT games_check CHECK (games >= 0),
  CONSTRAINT goals_check CHECK (goals >= 0),
  CONSTRAINT assists_check CHECK (assists >= 0)
);

ALTER TABLE positions
  OWNER TO fcrespect;

--------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS players (
  player_id    SERIAL,
  full_name    VARCHAR(60) NOT NULL,
  birthday     DATE        NOT NULL,
  image_name   VARCHAR(60),
  position_id  INTEGER     NOT NULL,
  about        TEXT,
  height       INTEGER,
  birth_place  VARCHAR(80),
  statistic_id INTEGER     NOT NULL,

  PRIMARY KEY (player_id),
  FOREIGN KEY (position_id) REFERENCES positions (position_id),
  FOREIGN KEY (statistic_id) REFERENCES statistic (statistic_id),
  CONSTRAINT birthday_check CHECK (birthday >= '1900-01-01'),
  CONSTRAINT uk_statistic_id UNIQUE (statistic_id)
);

ALTER TABLE players
  OWNER TO fcrespect;

--------------------------------------------------------------------------------------

