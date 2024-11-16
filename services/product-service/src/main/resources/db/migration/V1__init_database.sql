create table if not exists category (
    id integer not null primary key,
    description  varchar(256),
    name varchar(256)
);

create table if not exists product (
    id integer not null primary key,
    description  varchar(256),
    name varchar(256),
    available_quantity double precision not null,
    price numeric(38,2),
    category_id integer constraint fk1_related_to_category references category
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;