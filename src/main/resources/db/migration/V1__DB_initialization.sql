CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE body (
  id BIGINT NOT NULL,
  color VARCHAR(255),
  CONSTRAINT pk_body PRIMARY KEY (id)
);

CREATE TABLE combustion_engine (
  id BIGINT NOT NULL,
   fuel VARCHAR(255),
   cylinders INT NOT NULL,
   volume FLOAT NOT NULL,
   power INT NOT NULL,
   CONSTRAINT pk_combustion_engine PRIMARY KEY (id)
);

CREATE TABLE electric_motor (
  id BIGINT NOT NULL,
   type VARCHAR(255),
   power INT NOT NULL,
   CONSTRAINT pk_electric_motor PRIMARY KEY (id)
);

CREATE TABLE fuel_tank (
  id BIGINT NOT NULL,
   volume INT NOT NULL,
   CONSTRAINT pk_fueltank PRIMARY KEY (id)
);

CREATE TABLE on_board_charger (
  id BIGINT NOT NULL,
   type VARCHAR(255),
   power INT NOT NULL,
   CONSTRAINT pk_on_board_charger PRIMARY KEY (id)
);

CREATE TABLE reducer (
  id BIGINT NOT NULL,
   ratio VARCHAR(255),
   CONSTRAINT pk_reducer PRIMARY KEY (id)
);

CREATE TABLE traction_battery (
  id BIGINT NOT NULL,
   type VARCHAR(255),
   capacity INT NOT NULL,
   CONSTRAINT pk_traction_battery PRIMARY KEY (id)
);

CREATE TABLE transmission (
  id BIGINT NOT NULL,
   type VARCHAR(255),
   gears INT NOT NULL,
   CONSTRAINT pk_transmission PRIMARY KEY (id)
);

CREATE TABLE car_model (
  id BIGINT NOT NULL,
  object_id VARCHAR(255),
  name VARCHAR(255),
  maker_id BIGINT,
  "year" INT NOT NULL,
  body_id BIGINT,
  combustion_engine_id BIGINT,
  fuel_tank_id BIGINT,
  transmission_id BIGINT,
  engine_id BIGINT,
  battery_id BIGINT,
  reducer_id BIGINT,
  charger_id BIGINT,
  CONSTRAINT pk_car_model PRIMARY KEY (id)

CREATE TABLE car_model_category (
  car_model_id BIGINT NOT NULL,
  category_id BIGINT NOT NULL
);

CREATE TABLE category (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE maker (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   country VARCHAR(255),
   CONSTRAINT pk_maker PRIMARY KEY (id)
);

CREATE TABLE maker_car_model_list (
  maker_id BIGINT NOT NULL,
   car_model_list_id BIGINT NOT NULL
);

CREATE TABLE null_category (
  car_id BIGINT NOT NULL,
   category_id BIGINT NOT NULL
);

