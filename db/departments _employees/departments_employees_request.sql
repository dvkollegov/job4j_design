select * from departments d left join employees e on d.id = e.departments_id;
select * from departments d right join employees e on d.id = e.departments_id;
select * from departments d full join employees e on d.id = e.departments_id;
select * from departments d cross join employees e;

select * from departments d left join employees e on d.id = e.departments_id where e.id is null;

select * from departments d left join employees e on d.id = e.departments_id;
select d.id, d.name, e.id, e.name, departments_id  from employees e right join departments d on d.id = e.departments_id;