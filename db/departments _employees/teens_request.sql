select t1.name as name_1, t2.name as name_2
from teens t1 cross join teens t2
where t1.gender != t2.gender