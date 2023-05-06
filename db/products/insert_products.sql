insert into type(name) values ('Cheese');
insert into type(name) values ('Milk');
insert into type(name) values ('Meat');
insert into type(name) values ('Bread');
insert into type(name) values ('Drinks');
insert into type(name) values ('Sweets');
insert into type(name) values ('Sauces');

insert into product(name, type_id, expired_date, price) values ('Dutch cheese', 1, '2023-08-15', 850.0);
insert into product(name, type_id, expired_date, price) values ('Processed cheese', 1, '2023-06-12', 150.0);
insert into product(name, type_id, expired_date, price) values ('Mozzarella cheese', 1, '2023-10-23', 1050.0);

insert into product(name, type_id, expired_date, price) values ('Milk with a fat content of 2.7%', 2, '2023-05-05', 45.00);
insert into product(name, type_id, expired_date, price) values ('Milk with a fat content of 3.2%', 2, '2023-05-06', 50.00);
insert into product(name, type_id, expired_date, price) values ('Milk with a fat content of 5.0%', 2, '2023-05-04', 52.00);
insert into product(name, type_id, expired_date, price) values ('Kefir', 2, '2023-05-15', 62.00);
insert into product(name, type_id, expired_date, price) values ('Yogurt', 2, '2023-05-20', 80.00);

insert into product(name, type_id, expired_date, price) values ('Beef', 3, '2023-05-10', 480.00);
insert into product(name, type_id, expired_date, price) values ('Pork', 3, '2023-05-15', 360.00);
insert into product(name, type_id, expired_date, price) values ('Marbled beef', 3, '2023-05-15', 1050.00);

insert into product(name, type_id, expired_date, price) values ('Loaf', 4, '2023-05-03', 25.00);
insert into product(name, type_id, expired_date, price) values ('Black bread', 4, '2023-05-03', 32.00);

insert into product(name, type_id, expired_date, price) values ('Cola', 5, '2023-08-15', 68.00);
insert into product(name, type_id, expired_date, price) values ('Lemonade', 5, '2023-07-15', 70.00);
insert into product(name, type_id, expired_date, price) values ('Energy drink', 5, '2023-12-15', 110.00);

insert into product(name, type_id, expired_date, price) values ('Candies', 6, '2023-08-02', 458.00);
insert into product(name, type_id, expired_date, price) values ('Ice cream sundae', 6, '2023-06-10', 58.00);
insert into product(name, type_id, expired_date, price) values ('Creme brulee ice cream', 6, '2023-07-15', 46.00);

insert into product(name, type_id, expired_date, price) values ('Hot sauce', 7, '2023-11-15', 115.00);
insert into product(name, type_id, expired_date, price) values ('Chinese sauce', 7, '2024-02-12', 89.00);
insert into product(name, type_id, expired_date, price) values ('Sweet sauce', 7, '2023-10-23', 152.00);
