--create table to_list_entity(
--   id int(32) not null AUTO_INCREMENT PRIMARY KEY ,
--   title varchar(32) ,
--   is_checked tinyint,
--   is_even tinyint
--);

create sequence hibernate_sequence start with 1 increment by 1;
 create table to_list_entity (id integer not null,
  is_checked integer,
   is_even integer,
   title varchar(255) unique,
   primary key (id)
   )