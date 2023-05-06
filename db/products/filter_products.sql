select p.name
from product p
join type t on p.type_id = t.id
where t.name = 'Cheese';

select name
from product
where name ilike '%ice cream%';

select name
from product where expired_date < current_date;

select max(price) as max_price
from product;

select t.name as name_type, count(t.name)
from product p join type t on p.type_id = t.id
group by t.name;

select p.name
from product p
join type t on p.type_id = t.id
where t.name in ('Cheese', 'Milk');

select t.name as name_type, count(t.name)
from product p join type t on p.type_id = t.id
group by t.name
having count(t.name) < 3;

select p.name as name_product, t.name as type
from product p
join type t on p.type_id = t.id
