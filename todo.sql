create database todo;

create table todo(
    id bigint not null auto_increment,
    user_name varchar(255),
    created_at date,
    updated_at date,
    todo varchar(2000),
    title varchar(255),
    primary key (id)
);

select* from todo