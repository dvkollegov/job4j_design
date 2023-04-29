insert into users(name_user, age, sex) values('Ivan', 35, 'male');
insert into users(name_user, age, sex) values('Vasy', 23, 'male');
insert into users(name_user, age, sex) values('Lena', 28, 'female');

insert into role(name_role) values('User');
insert into role(name_role) values('Admin');

insert into rules(role_rights) values('Read');
insert into rules(role_rights) values('Fix');

insert into item(name_item, description) values('Fix bug', 'fix bug in the bugalteri department');
insert into item(name_item, description) values('Fix bug', 'fix bug in the personnel department');

insert into comments(comment) values('fix bug very important');

insert into attachs(name_fail, path_fail) values('update one', 'c:\update_one');
insert into attachs(name_fail, path_fail) values('update two', 'c:\update_two');
insert into attachs(name_fail, path_fail) values('update three', 'c:\update_three');

insert into category(name_category) values('auto');
insert into category(name_category) values('moto');

insert into state(executed) values(false);
insert into state(executed) values(true);