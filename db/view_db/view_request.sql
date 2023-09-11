-- список активных студентов, у которых куплено 3 и более книг
create view show_active_students_taken_3_or_more_books as
select s.name as student, count(s.name) from students s
join orders o on s.id = o.student_id where o.active = true
group by (s.name) having count(s.name) >= 3;

select * from show_active_students_taken_3_or_more_books