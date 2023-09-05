-- Вывести список всех машин и все привязанные к ним детали
select c.id as id, c.name as car_name, cb.name as body_name, ce.name as engine_name, ct.name as transmission_name
from cars c
left join car_bodies cb on cb.id = c.body_id
left join car_engines ce on ce.id = c.engine_id
left join car_transmissions ct on ct.id = c.transmission_id;

-- Вывести кузова, которые не используются НИ в одной машине
select cb.id as id, cb.name as body_name
from car_bodies cb left join cars c on cb.id = c.body_id
where body_id is null;

-- Вывести двигатели, которые не используются НИ в одной машине
select ce.id as id, ce.name as engine_name
from car_engines ce left join cars c on ce.id = c.engine_id
where engine_id is null;

-- Вывести коробки передач, которые не используются НИ в одной машине
select ct.id as id, ct.name as transmission_name
from car_transmissions ct left join cars c on ct.id = c.transmission_id
where transmission_id is null