
Drop database if exists kicine;

Create database Kicine;

use Kicine;

Create table Pelicula(
  idPelicula int auto_increment,
  titulo varchar(255) not null,
  genero varchar(255) not null,
  director varchar(255) not null,
  duracion int not null,
  sinopsis text not null,
  ano_lanzamiento int not null,
  calificacion varchar(50) not null,
  idioma varchar(50) not null,
  primary key PK_idPelicula(idPelicula)
);


-- carlos juarez
Create table SalaCine(
  idSalacine int auto_increment not null,
  numero_sala int not null,
  capacidad int not null,
  tipo_sala varchar(50) not null,
  ubicacion varchar(255) not null,
  primary key PK_idSalaCine(idSalaCine)
);


-- Palma
Create table HorariosProyeccion(
  idHorariosProyeccion int auto_increment not null,
  hora_inicio time not null,
  hora_fin time not null,
  disponibilidad_asientos int not null,
  sala_id int not null,
  pelicula_id int not null,
  primary key PK_idHorariosProyeccion(idHorariosProyeccion),
  foreign key (sala_id) references SalaCine(idSalacine),
  foreign key (pelicula_id) references Pelicula(idPelicula)
);



-- Quiyuch
Create table Login(
	codigoUsuario int auto_increment not null,
    usuario varchar(50) not null not null,
    contrasena varchar(50) not null not null,
    primary key PK_codUsuario(codigoUsuario)

);


Create table Usuario(
  idUsuario int auto_increment not null,
  nombre varchar(255) not null,
  apellido varchar(255) not null,
  correo_electronico varchar(255) not null,
  contrasena varchar(255) not null,
  tarjeta_credito varchar(255) not null,
  primary key PK_idUsuario(idUsuario)
);




-- Brandon
Create table Reserva(
  idReserva int auto_increment not null,
  pelicula_idPelicula int not null,
  sala_id int not null,
  horario_id int not null,
  usuario_id int not null,
  cantidad_entradas int not null,
  primary key PK_idReserva(idReserva),
  foreign key (pelicula_idPelicula) references Pelicula(idPelicula),
  foreign key (sala_id) references SalaCine(idSalaCine),
  foreign key (horario_id) references HorariosProyeccion(idHorariosProyeccion),
  foreign key (usuario_id) references Usuario(idUsuario)
);


-- Luis michu
Create table Cine(
  idCine int auto_increment not null,
  nombre varchar(255) not null,
  ubicacion varchar(255) not null,
  telefono varchar(50) not null,
  pagina_web varchar(255) not null,
  horarios_apertura varchar(255) not null,
  primary key PK_idCine(idCine)
);

-- Diego
Create table Taquilla (
  idTaquilla int auto_increment not null,
  numero_taquilla int not null,
  ubicacion varchar(255) not null,
  estado varchar(255) not null,
  capacidad int not null,
  tipo_pago_aceptado varchar(255) not null,
  horario_operacion varchar(255) not null,
  id_cine int not null,
  primary key PK_idTaquilla (idTaquilla),
  foreign key (id_cine) references Cine(idCine)
);


-- Herling
Create table Comentario(
  idComentario int auto_increment not null,
  usuario_id int not null,
  pelicula_id int not null,
  texto text not null,
  puntuacion int not null,
  primary key PK_idComentario(idComentario),
  foreign key (usuario_id) references Usuario(idUsuario),
  foreign key (pelicula_id) references Pelicula(idPelicula)
);


-- Sebastian
Create table Promocion(
  idPromocion int auto_increment not null,
  nombre_promocion varchar(255) not null,
  descripcion text not null,
  fechas_validez varchar(255) not null,
  codigo_promocion varchar(255) not null,
  primary key PK_idPromocion(idPromocion)
);


-- Beto
Create table FuncionEspecial(
  idFuncionEspecial int auto_increment not null,
  tipo_funcion varchar(255) not null,
  descripcion text not null,
  pelicula_id int not null,
  horario_id int not null,
  primary key PK_idFuncionEspecial(idFuncionEspecial),
  foreign key (pelicula_id) references Pelicula(idPelicula),
  foreign key (horario_id) references HorariosProyeccion(idHorariosProyeccion)
);




-- Jimenez
Create table Estreno(
  idEstreno int auto_increment not null,
  pelicula_id int not null,
  fecha_estreno date not null,
  promocion_id int not null,
  primary key PK_idEstreno(idEstreno),
  foreign key (pelicula_id) references Pelicula(idPelicula),
  foreign key (promocion_id) references Promocion(idPromocion)
);


-- Empleados
/*Create table Empleado(
  idEmpleado int auto_increment,
  nombre varchar(255),
  cargo varchar(255),
  horario_trabajo varchar(255),
  primary key PK_idEmpleado(idEmpleado)
);*/


-- Quezada
Create table Cartelera(
  idCartelera int auto_increment not null,
  fecha date not null,
  pelicula_id int not null not null,
  horario_id int not null not null,
  primary key PK_idCartelera(idCartelera),
  foreign key (pelicula_id) references Pelicula(idPelicula),
  foreign key (horario_id) references HorariosProyeccion(idHorariosProyeccion)
);


-- CRUD CINE -------------------------------------------------------------------------
-- Agregar ---------------------------------------------------------------------------
Delimiter $$
create procedure sp_AgregarCine(in nomCine varchar(225), in ubicacion varchar(225), in tel varchar(50), 
								in pagweb varchar(225), in horarios varchar(225))
Begin
	Insert into Cine(nombre, ubicacion, telefono, pagina_web, horarios_apertura)
		values(nomCine, ubicacion, tel, pagweb, horarios); 
End$$
Delimiter ;

call sp_AgregarCine('KinePolis Cayala VIP','JG67+CR5, Ciudad Cayalá, Blvd. Austriaco', '5486 4084','www.kinepolisCayala.com','12:00-23:00');
call sp_AgregarCine('KinePolis Miraflores', ' 21A Avenida 4-32, Cdad. de Guatemala', '5527 1322','www.kinepolisMiraflores.com', '10:00-22:00');
call sp_AgregarCine('KinePolis El Naranjo', 'MF24+9VM, Cdad. de Guatemala', '5007 6376','www.kinepolisElNaranjo.com','10:00-23:00');
call sp_AgregarCine('KinePolis Santa Clara', ' GCJ2+8J2, Villa Nueva', '5011 0425','www.kinepolisSantaClara.com','21:00-22:00');
-- Lsitar ---------------------------------------------------------------------------
Delimiter $$
Create procedure sp_ListarCines()
Begin
	Select C.idCine, C.nombre, C.ubicacion, C.telefono, C.pagina_web, C.horarios_apertura
		from Cine C;
End$$
Delimiter ;

call sp_ListarCines();
-- Buscar ---------------------------------------------------------------------------------
Delimiter $$
Create procedure sp_BuscarCine(in id int)
Begin
	Select C.idCine, C.nombre, C.ubicacion, C.telefono, C.pagina_web, C.horarios_apertura
		from Cine C
        where id=C.idCine;
End$$
Delimiter ;
call sp_BuscarCine(2);
-- Eliminar -------------------------------------------------------------------------------
Delimiter $$
Create procedure sp_EliminarCine(in id int)
Begin
	Delete from Cine C where id = C.idCine;
End$$
Delimiter ;
-- call sp_EliminarCine(2);
-- Editar --------------------------------------------------------------------------------
Delimiter $$
create procedure sp_EditarCine(in id int, in nomCine varchar(225), in ubicacion varchar(225), in tel varchar(50), 
								in pagweb varchar(225), in horarios varchar(225))
Begin
	Update Cine C set
    C.nombre = nomCine, C.ubicacion = ubicacion, C.telefono = tel, C.pagina_web = pagweb, C.horarios_apertura=horarios
		where  id = C.idCine;
End$$
Delimiter ;

-- call sp_EditarCine('3','AAAA','AAAA','AAAA','AAA','AA');
call sp_ListarCines();

