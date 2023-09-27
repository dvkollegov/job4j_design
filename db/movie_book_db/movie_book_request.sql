select m.name from movie m intersect select b.title from book b;

select b.title from book b except select m.name from movie m;

(select m.name from movie m except select b.title from book b)
union all
(select b.title from book b except select m.name from movie m);