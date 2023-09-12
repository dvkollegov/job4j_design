create trigger tax_20_percent_trigger
    after insert on products
    referencing new table inserted
    for each statement
execute procedure tax();

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
    language 'plpgsql';

