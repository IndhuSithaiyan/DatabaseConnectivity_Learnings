create table if not exists EMPLOYEES (id identity primary key, name varchar (100) not null);

truncate table EMPLOYEES;

insert into EMPLOYEES (id, name) values (1, 'John');
insert into EMPLOYEES (id, name) values (2, 'Lisa');