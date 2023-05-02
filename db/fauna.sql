create table fauna
(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('Lasiognathus dinema', 10000, '2015-01-17');
insert into fauna (name, avg_age, discovery_date) values ('Megaceras briansaltini', 15000, '2008-07-29');
insert into fauna (name, avg_age, discovery_date) values ('Chondrocladia turbiformis', 8000, '1938-05-18');
insert into fauna (name, avg_age, discovery_date) values ('Histiophryne psychedelica', 25000, '1950-06-12');
insert into fauna (name, avg_age, discovery_date) values ('Hippocampus satomiae fish', 5000, '1925-01-30');
insert into fauna (name, avg_age, discovery_date) values ('Campus satomiae fish', 5000, null);

select * from fauna;
select * from fauna where name like '%fish%';
select * from fauna where avg_age between 10000 and 21000;
select * from fauna where discovery_date is null;
select * from fauna where date_part('year', discovery_date) < 1950;