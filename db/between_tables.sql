create table people(
    id serial primary key,
    name_people varchar(255),
    age int,
    sex varchar(255),
    car_id int
);

create table car(
    id serial primary key,
    name_car varchar(255),
    color varchar(255),
    number_car_id int unique
);

create table number_car(
    id serial primary key,
    number_car varchar(255)
);

create table driver(
    id serial primary key,
    name_driver varchar(255),
    experience int
);

create table bus(
    id serial primary key,
    name_bus varchar(255),
    number_bus varchar(255)
);

create table drivers_bus(
    id serial primary key,
    driver_id int,
    bus_id int
);