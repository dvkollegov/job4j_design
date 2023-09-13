create or replace function tax_20_row()
    returns trigger as
$$
BEGIN
    new.price = new.price + new.price * 0.2;
    return new;
END;
$$
    language 'plpgsql';

create trigger tax_20_trigger_row
    before insert on products
    for each row
execute procedure tax_20_row();