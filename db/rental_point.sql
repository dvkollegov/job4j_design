create table client
(
    id   serial primary key,
    name text,
    telephone text
);

create table tool
(
    id   serial primary key,
    name text,
    cost_per_day float,
    date_start timestamp,
    client_id int references client(id)
);

insert into client (name, telephone) values ('Dima', '89991234567');
insert into client (name, telephone) values ('Gregory', '89991234999');
insert into client (name, telephone) values ('Liza', '87771234567');

insert into tool (name, cost_per_day, date_start, client_id) values ('screwdriver', 563.00, '2023-04-25', 4);
insert into tool (name, cost_per_day, date_start, client_id) values ('concrete mixer', 1100.5, '2023-04-26', 4);
insert into tool (name, cost_per_day, date_start, client_id) values ('vibrator', 800.7, '2023-04-26', 4);
insert into tool (name, cost_per_day, date_start, client_id) values ('grinding machine', 1200.00, '2023-04-25', 5);

select * from tool join client on tool.client_id = client.id;

select tl.name as "Tool", tl.cost_per_day as "Payment per day", cl.name as "Client's name"
from tool tl join client cl on tl.client_id = cl.id;

select tl.name as "Tool", tl.cost_per_day as "Payment per day", tl.client_id as "Client ID", cl.name as "Client's name"
from tool tl join client cl on tl.client_id = cl.id;

select tl.name as "Tool", tl.cost_per_day as "Payment per day", tl.date_start as "Rental start date",
tl.client_id as "Client ID", cl.name as "Client's name", cl.telephone as "Customer's phone number"
from tool tl join client cl on tl.client_id = cl.id;