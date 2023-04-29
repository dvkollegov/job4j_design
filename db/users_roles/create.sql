create table role(
    id serial primary key,
    name_role varchar(255)
);

create table users(
    id serial primary key,
    name_user varchar(255),
    age int,
    sex varchar(255),
    role_id int references role(id)
);

create table rules(
    id serial primary key,
    role_rights varchar(255)
);

create table role_rules(
    id serial primary key,
    roles_id int references role(id),
    rules_id int references rules(id)
);

create table category(
    id serial primary key,
    name_category varchar(255)
);

create table state(
    id serial primary key,
    executed boolean
);

create table item(
    id serial primary key,
    name_item varchar(255),
    description text,
    users_id int references users(id),
    category_id int references category(id),
    state_id int references state(id)
);

create table comments(
    id serial primary key,
    comment text,
    item_id int references item(id)
);

create table attachs(
    id serial primary key,
    name_fail varchar(255),
    path_fail text,
    item_id int references item(id)
);
