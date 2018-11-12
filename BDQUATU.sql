DROP DATABASE IF EXISTS BDQUATU;
CREATE DATABASE BDQUATU;
USE BDQUATU;

create table DEPARTAMENTO(
	id 			int 					auto_increment 		primary key,
    nombre 	varchar(50)
);

create table PROVEEDOR(
	id 							int  					auto_increment primary key,
    empresa 					varchar(100)  	not null,
    ruc 							varchar(11) 		not null,
    contacto  				varchar(50) 		not null,
    dni							varchar(8) 		not null,
    correo 						varchar(100) 	not null,
    direccion 					varchar(200) 	not null,
    departamento_id 	int,
    contrasena 				varchar(20) 		not null,
    
    foreign key (departamento_id) 		references DEPARTAMENTO (id)
);

create table CATEGORIA(
	codigo int auto_increment primary key,
    descripcion varchar(100) not null
);

create table PRODUCTO(
	codigo int auto_increment primary key,
    nombre varchar(200) not null,
    descripcion varchar(300) not null,
    precio_min double not null,
    precio_max double not null,
    medida varchar(20) not null,
    categoria_codigo int not null,
    region varchar(500) not null,
    resumen varchar(1000) not null,
    proveedor_id int not null,
    
    foreign key (categoria_codigo) references CATEGORIA(codigo),
    foreign key (proveedor_id) references PROVEEDOR(id)
);

insert into DEPARTAMENTO values(null,"Amazonas");
insert into DEPARTAMENTO values(null,"Ancash");
insert into DEPARTAMENTO values(null,"Apurimac");
insert into DEPARTAMENTO values(null,"Arequipa");
insert into DEPARTAMENTO values(null,"Ayacucho");
insert into DEPARTAMENTO values(null,"Cajamarca");
insert into DEPARTAMENTO values(null,"Callao");
insert into DEPARTAMENTO values(null,"Cusco");
insert into DEPARTAMENTO values(null,"Huancavelica");
insert into DEPARTAMENTO values(null,"Huanuco");
insert into DEPARTAMENTO values(null,"Ica");
insert into DEPARTAMENTO values(null,"Junin");
insert into DEPARTAMENTO values(null,"La Libertad");
insert into DEPARTAMENTO values(null,"Lambayeque");
insert into DEPARTAMENTO values(null,"Lima");
insert into DEPARTAMENTO values(null,"Loreto");
insert into DEPARTAMENTO values(null,"Madre De Dios");
insert into DEPARTAMENTO values(null,"Moquegua");
insert into DEPARTAMENTO values(null,"Pasco");
insert into DEPARTAMENTO values(null,"Piura");
insert into DEPARTAMENTO values(null,"Puno");
insert into DEPARTAMENTO values(null,"San Martin");
insert into DEPARTAMENTO values(null,"Tacna");
insert into DEPARTAMENTO values(null,"Tumbes");
insert into DEPARTAMENTO values(null,"Ucayali");

insert into PROVEEDOR values (null,"Supermercados Peruanos","20396678903","Pedro Oyeda","45683634","pedrito@esgay.com","Av. El Golf calle 1 Mz23 Lote 3 Asentamiento Humano los Invasores de la Molina",1,"kawasaki");
insert into PROVEEDOR values (null,"RIMAC Seguros","121323123","Pedro Oyeda","45683634","pedrito@esgay.com","Av. El Golf calle 1 Mz23 Lote 3 Asentamiento Humano los Invasores de la Molina",1,"kawasaki");

insert into CATEGORIA values (null, "Aves y Carnes");

select * from PROVEEDOR;
select * from CATEGORIA;