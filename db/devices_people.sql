create table devices
(
    id serial primary key,
    name varchar(255),
    price float
);

create table people
(
    id serial primary key,
    name varchar(255)
);

create table devices_people
(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values ('HONOR 70 5G', 33999.99);
insert into devices (name, price) values ('Apple iPhone 14 Pro', 110000.50);
insert into devices (name, price) values ('Samsung Galaxy S23 Ultra', 89000.00);
insert into devices (name, price) values ('OnePlus 11', 53500.00);
insert into devices (name, price) values ('Google Pixel 7', 67000.00);

insert into people (name) values ('Dima');
insert into people (name) values ('Igory');
insert into people (name) values ('Sergey');
insert into people (name) values ('Vasy');
insert into people (name) values ('Leonid');

insert into devices_people (device_id, people_id) values (7, 1);
insert into devices_people (device_id, people_id) values (10, 1);
insert into devices_people (device_id, people_id) values (11, 1);
insert into devices_people (device_id, people_id) values (8, 2);
insert into devices_people (device_id, people_id) values (11, 2);
insert into devices_people (device_id, people_id) values (9, 3);
insert into devices_people (device_id, people_id) values (10, 3);
insert into devices_people (device_id, people_id) values (11, 3);
insert into devices_people (device_id, people_id) values (8, 4);
insert into devices_people (device_id, people_id) values (8, 4);
insert into devices_people (device_id, people_id) values (7, 5);
insert into devices_people (device_id, people_id) values (8, 5);
insert into devices_people (device_id, people_id) values (9, 5);
insert into devices_people (device_id, people_id) values (10, 5);
insert into devices_people (device_id, people_id) values (11, 5);

select round(avg(price)::decimal, 2) as avg_price_devices from devices;

select p.name, round(avg(d.price)::decimal, 2) as avg_price_devices
from people p
join devices_people dp on p.id = dp.people_id
join devices d on dp.device_id = d.id
group by p.name;

select p.name, round(avg(d.price)::decimal, 2) as avg_price_devices
from people p
join devices_people dp on p.id = dp.people_id
join devices d on dp.device_id = d.id
group by p.name
having round(avg(d.price)::decimal, 2) > 80000;
