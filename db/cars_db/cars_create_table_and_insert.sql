create table car_bodies (
    id serial primary key,
    name varchar(255)
);

create table car_engines (
    id serial primary key,
    name varchar(255)
);

create table car_transmissions (
    id serial primary key,
    name varchar(255)
);

create table cars (
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('sedan');
insert into car_bodies(name) values ('hatchback');
insert into car_bodies(name) values ('pickup');
insert into car_bodies(name) values ('liftback');

insert into car_engines(name) values ('gasoline_v_8');
insert into car_engines(name) values ('gasoline_v_6');
insert into car_engines(name) values ('diesel_v_2.5');
insert into car_engines(name) values ('diesel_v_2');

insert into car_transmissions(name) values ('auto');
insert into car_transmissions(name) values ('robot');
insert into car_transmissions(name) values ('manual');

insert into cars(name, body_id, engine_id, transmission_id) values ('BMW', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('BMW_X6', 2, null, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Audi', 2, 2, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Porsche', 1, 3, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('Ford', 3, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota', 2, 3, 2);