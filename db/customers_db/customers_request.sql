select * from customers c where c.age = (select min(c.age) from customers c);

select * from customers c where c.id not in (select o.id from orders o);