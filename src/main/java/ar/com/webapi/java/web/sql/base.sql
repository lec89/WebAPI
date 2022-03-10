drop database if exists negocioWeb;
create database negocioWeb;
use negocioWeb;

create table articulos(
    id int primary key,
    descripcion varchar(25),
    precio float
);

create table clientes(
    id int auto_increment primary key,
    nombre varchar(20),
    apellido varchar(20),
    tipoCliente enum('MINORISTA','MAYORISTA','EMPRESA')
);

-- show tables;
-- select * from clientes;

-- alter table articulos add zona varchar(25) after descripcion;
-- select * from articulos;