create table ps_employees (
    id        varchar(200),
    name      varchar(200),
    birthday  date,
    hire_date date
);

create table sl_salaries (
    id     varchar(200),
    e_id   varchar(200),
    year   number,
    month  number,
    amount number
)
