create or replace procedure delete_data(d_id integer)
    language 'plpgsql' as
$$
    BEGIN
        delete from products where id = d_id;
    END;
$$;


create or replace function f_delete_data(d_count integer) returns integer
    language 'plpgsql' as
$$
    declare
        result integer default 0;
    BEGIN
        delete from products where count <= d_count;
        select into result count(*) from products;
        return result;
    END;
$$;