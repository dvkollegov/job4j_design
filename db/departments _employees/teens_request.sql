select t1.name as name_male, t2.name as name_female
from teens t1 cross join teens t2
where t1.gender != t2.gender and t1.gender != 'female'