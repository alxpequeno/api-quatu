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
    foto varchar(500),
    
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

insert into CATEGORIA values (null, "Aves y Carnes");
insert into CATEGORIA values (null, "Frutas y Verduras");
insert into CATEGORIA values (null, "Pescados y Mariscos");

insert into PROVEEDOR values (null,"Villa Sur SAC","20376657839","Juan Perez","6789999","jperez@villa.com.pe","Av. la molina",1,"123");

insert into PRODUCTO values (null,"Pollo Entero con Menudencia","Peso aprox 2.100 a 2.400 Kg (Foto referencial, los productos se venden frescos en su estado original).",5.9,7.9,"Kg",1,"Lima, Ica, Arequipa","En granja los Villa Sur nos dedicamos a la cría y venta de cerdos y Pollos de campo orgánicos criados a maiz sin agregado de aditivos de ningún tipo.Una carne totalmente natural y sabrosa. Consulte zonas de entrega.Ventas por mayor y menor",1,"https://wongfood.vteximg.com.br/arquivos/ids/219273-1000-1000/227460-01-6627.jpg?v=636602868107600000");


select * from PROVEEDOR;
select * from CATEGORIA;
select * from PRODUCTO;

