drop database if exists alumno;
create database alumno charset utf8mb4 collate utf8mb4_spanish_ci;
use alumno;

create table codigopostal (
cp varchar (6) primary key,
localidad varchar (100) not null

)engine = InnoDB;

create table alumno (
dni varchar (9) primary key,
nombre varchar (50) not null,
apellido1 varchar (100) not null,
apellido2 varchar (100) not null,
fecha_nac date comment 'El cliente no esta obligado a poner su fecha de nacimiento',
poblacion varchar (500) not null,
cp varchar (6),
foreign key (cp) references codigopostal (cp) on delete cascade on update cascade
)engine = InnoDB;



INSERT INTO codigopostal (cp, localidad) VALUES
('28001', 'Madrid'),
('08001', 'Barcelona'),
('46001', 'Valencia'),
('41001', 'Sevilla'),
('50001', 'Zaragoza'),
('29001', 'Málaga'),
('48001', 'Bilbao'),
('18001', 'Granada'),
('03001', 'Alicante'),
('47001', 'Valladolid'),
('14001', 'Córdoba'),
('30001', 'Murcia'),
('37001', 'Salamanca'),
('11001', 'Cádiz'),
('03002', 'Alicante'),
('36201', 'Vigo'),
('49001', 'Zamora'),
('29002', 'Málaga');


INSERT INTO alumno (dni, nombre, apellido1, apellido2, fecha_nac, poblacion, cp) VALUES
('123456789', 'Juan', 'Gómez', 'Pérez', '2000-05-10', 'Madrid', '28001'),
('987654321', 'María', 'López', 'García', '1999-08-15', 'Barcelona', '08001'),
('456789123', 'Carlos', 'Fernández', 'Rodríguez', '2001-03-22', 'Valencia', '46001'),
('321654987', 'Laura', 'Martínez', 'Sánchez', '2000-11-05', 'Sevilla', '41001'),
('789123456', 'Pedro', 'Hernández', 'González', '1998-09-12', 'Zaragoza', '50001'),
('654987321', 'Ana', 'Jiménez', 'Torres', '2002-06-30', 'Málaga', '29001'),
('111111111', 'Sergio', 'Gutiérrez', 'López', '2003-02-18', 'Bilbao', '48001'),
('222222222', 'Lucía', 'Sánchez', 'Morales', '2001-07-23', 'Granada', '18001'),
('333333333', 'Javier', 'Ruíz', 'Navarro', '2002-09-05', 'Alicante', '03001'),
('444444444', 'Paula', 'Díaz', 'Fernández', '1999-12-09', 'Valladolid', '47001'),
('555555555', 'Miguel', 'Romero', 'González', '2000-04-14', 'Córdoba', '14001'),
('666666666', 'Laura', 'García', 'Hernández', '2001-11-27', 'Murcia', '30001'),
('777777777', 'Carmen', 'Ortega', 'Vargas', '2000-08-12', 'Salamanca', '37001'),
('888888888', 'Hugo', 'Moreno', 'Soto', '1999-03-17', 'Cádiz', '11001'),
('999999999', 'Isabella', 'Mendoza', 'Guerrero', '2001-12-03', 'Alicante', '03002'),
('121212121', 'Luis', 'Pérez', 'García', '2000-05-21', 'Vigo', '36201'),
('232323232', 'Sofía', 'Torres', 'Silva', '2002-09-11', 'Zamora', '49001'),
('343434343', 'Gabriel', 'Hernández', 'Luna', '1998-11-28', 'Málaga', '29002');
