CREATE TABLE IF NOT EXISTS positions (
  position_id    INTEGER IDENTITY PRIMARY KEY,
  position_value VARCHAR(30) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS players (
player_id INTEGER IDENTITY PRIMARY KEY,
full_name  VARCHAR(60)         NOT NULL,
birthday   DATE                NOT NULL,
image_name  VARCHAR(60),
position_id   INTEGER             NOT NULL,
FOREIGN KEY (position_id) REFERENCES positions (position_id)
);


