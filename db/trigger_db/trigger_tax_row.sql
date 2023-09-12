create trigger tax_20_trigger_row
    after insert on products
    for each row
execute procedure tax_20_row();

create or replace function tax_20_row()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.2;
    return new;
END;
$$
    language 'plpgsql';