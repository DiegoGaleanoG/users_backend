drop table if exists users;
create table users(
id int auto_increment primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
telefono varchar(50) not null,
comuna varchar(50) not null
);