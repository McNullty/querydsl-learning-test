create table test_entity (
       id int4 not null,
        description varchar(255),
        primary key (id)
    );

insert into  test_entity(id, description) values (1, 'Hello');
insert into  test_entity(id, description) values (2, 'World');