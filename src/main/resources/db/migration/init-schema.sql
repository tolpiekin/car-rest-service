CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE body (
  id BIGINT NOT NULL,
   color VARCHAR(255),
   CONSTRAINT pk_body PRIMARY KEY (id)
);

CREATE TABLE car_model (
  id BIGINT NOT NULL,
   dtype VARCHAR(31),
   name VARCHAR(255),
   maker_id BIGINT,
   model_id BIGINT,
   "year" INT NOT NULL,
   body_id BIGINT,
   engine_id BIGINT,
   tank_id BIGINT,
   transmission_id BIGINT,
   CONSTRAINT pk_carmodel PRIMARY KEY (id)
);

CREATE TABLE car_model_category (
  car_model_id BIGINT NOT NULL,
   category_id BIGINT NOT NULL
);

CREATE TABLE category (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE combustion_engine (
  id BIGINT NOT NULL,
   fuel VARCHAR(255),
   cylinders INT NOT NULL,
   volume FLOAT NOT NULL,
   power INT NOT NULL,
   CONSTRAINT pk_combustionengine PRIMARY KEY (id)
);

CREATE TABLE electric_motor (
  id BIGINT NOT NULL,
   type VARCHAR(255),
   power INT NOT NULL,
   CONSTRAINT pk_electricmotor PRIMARY KEY (id)
);

CREATE TABLE evcar (
  id BIGINT NOT NULL,
   model_id BIGINT,
   "year" INT NOT NULL,
   body_id BIGINT,
   maker_id BIGINT,
   engine_id BIGINT,
   battery_id BIGINT,
   reducer_id BIGINT,
   charger_id BIGINT,
   CONSTRAINT pk_evcar PRIMARY KEY (id)
);

CREATE TABLE fuel_tank (
  id BIGINT NOT NULL,
   volume INT NOT NULL,
   CONSTRAINT pk_fueltank PRIMARY KEY (id)
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

CREATE TABLE on_board_charger (
  id BIGINT NOT NULL,
   type VARCHAR(255),
   power INT NOT NULL,
   CONSTRAINT pk_onboardcharger PRIMARY KEY (id)
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
   CONSTRAINT pk_tractionbattery PRIMARY KEY (id)
);

CREATE TABLE transmission (
  id BIGINT NOT NULL,
   type VARCHAR(255),
   gears INT NOT NULL,
   CONSTRAINT pk_transmission PRIMARY KEY (id)
);

CREATE TABLE "user" (
  id BIGINT NOT NULL,
   username VARCHAR(255),
   password VARCHAR(255),
   CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE car_model_category ADD CONSTRAINT uc_car_model_category_category UNIQUE (category_id);

ALTER TABLE maker_car_model_list ADD CONSTRAINT uc_maker_car_model_list_carmodellist UNIQUE (car_model_list_id);

ALTER TABLE null_category ADD CONSTRAINT uc_null_category_category UNIQUE (category_id);

ALTER TABLE car_model ADD CONSTRAINT FK_CARMODEL_ON_BODY FOREIGN KEY (body_id) REFERENCES body (id);

ALTER TABLE car_model ADD CONSTRAINT FK_CARMODEL_ON_ENGINE FOREIGN KEY (engine_id) REFERENCES combustion_engine (id);

ALTER TABLE car_model ADD CONSTRAINT FK_CARMODEL_ON_MAKER FOREIGN KEY (maker_id) REFERENCES maker (id);

ALTER TABLE car_model ADD CONSTRAINT FK_CARMODEL_ON_MODEL FOREIGN KEY (model_id) REFERENCES car_model (id);

ALTER TABLE car_model ADD CONSTRAINT FK_CARMODEL_ON_TANK FOREIGN KEY (tank_id) REFERENCES fuel_tank (id);

ALTER TABLE car_model ADD CONSTRAINT FK_CARMODEL_ON_TRANSMISSION FOREIGN KEY (transmission_id) REFERENCES transmission (id);

ALTER TABLE evcar ADD CONSTRAINT FK_EVCAR_ON_BATTERY FOREIGN KEY (battery_id) REFERENCES traction_battery (id);

ALTER TABLE evcar ADD CONSTRAINT FK_EVCAR_ON_BODY FOREIGN KEY (body_id) REFERENCES body (id);

ALTER TABLE evcar ADD CONSTRAINT FK_EVCAR_ON_CHARGER FOREIGN KEY (charger_id) REFERENCES on_board_charger (id);

ALTER TABLE evcar ADD CONSTRAINT FK_EVCAR_ON_ENGINE FOREIGN KEY (engine_id) REFERENCES electric_motor (id);

ALTER TABLE evcar ADD CONSTRAINT FK_EVCAR_ON_MAKER FOREIGN KEY (maker_id) REFERENCES maker (id);

ALTER TABLE evcar ADD CONSTRAINT FK_EVCAR_ON_MODEL FOREIGN KEY (model_id) REFERENCES car_model (id);

ALTER TABLE evcar ADD CONSTRAINT FK_EVCAR_ON_REDUCER FOREIGN KEY (reducer_id) REFERENCES reducer (id);

ALTER TABLE car_model_category ADD CONSTRAINT fk_carmodcat_on_car_model FOREIGN KEY (car_model_id) REFERENCES car_model (id);

ALTER TABLE car_model_category ADD CONSTRAINT fk_carmodcat_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE maker_car_model_list ADD CONSTRAINT fk_makcarmodlis_on_car_model FOREIGN KEY (car_model_list_id) REFERENCES car_model (id);

ALTER TABLE maker_car_model_list ADD CONSTRAINT fk_makcarmodlis_on_maker FOREIGN KEY (maker_id) REFERENCES maker (id);

ALTER TABLE null_category ADD CONSTRAINT fk_nulcat_on_car FOREIGN KEY (car_id) REFERENCES car_model (id);

ALTER TABLE null_category ADD CONSTRAINT fk_nulcat_on_category FOREIGN KEY (category_id) REFERENCES category (id);