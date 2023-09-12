create trigger history_trigger
    after insert on products
    for each row
execute procedure history();

create or replace function history()
    returns trigger as
$$
BEGIN
    insert into history_of_price(name, price, date)
    values(new.name, new.price, CURRENT_DATE);
    return new;
END;
$$
    language 'plpgsql';