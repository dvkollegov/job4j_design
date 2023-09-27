create table customers(
      id serial primary key,
      first_name text,
      last_name text,
      age int,
      country text
);

insert into customers(first_name, last_name, age, country) values ('Dima', 'Kol', 38, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Igory', 'Pol', 20, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Sergey', 'Dom', 18, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Sveta', 'Rol', 25, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Anna', 'Lol', 18, 'Russia');

create table orders(
       id serial primary key,
       amount int,
       customer_id int references customers(id)
);

insert into orders(amount, customer_id) values (100, 1);
insert into orders(amount, customer_id) values (300, 2);
insert into orders(amount, customer_id) values (500, 3);