create table cities(
	id serial primary key,
	name varchar(255),
	area varchar(255),
	people bigint,
	flag boolean,
	pollution float
);

insert into cities(name, area, people, flag, pollution) values('Kirov', 'Russia', 495627, true, 2.17);
select * from cities;
update cities set people = 502623;
select * from cities;
delete from cities;
select * from cities;