-- Use this for creating user and db
------------------------------------------------------------------------------------------------------------------------
-- Role without password
CREATE ROLE fcrespect WITH LOGIN PASSWORD 'fcrespect';
------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE fcrespect_db
  WITH OWNER = fcrespect
  ENCODING = 'UTF8'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;
------------------------------------------------------------------------------------------------------------------------