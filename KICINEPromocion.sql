
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
  idPromocion int not null auto_increment,
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





-- ------------------ Procedimientos almacenados -----------------------------


Delimiter $$
	Create procedure sp_AgregarPelicula(in titulo varchar(255), in genero varchar(255), in director varchar(255), in duracion int, in sinopsis text, in ano_lanzamiento int, in calificacion varchar(50), in idioma varchar(50))
    Begin
		Insert into Pelicula(titulo, genero, director, duracion, sinopsis, ano_lanzamiento, calificacion, idioma)
			values(titulo, genero, director, duracion, sinopsis, ano_lanzamiento, calificacion, idioma);
    End$$
Delimiter ;

call sp_AgregarPelicula('¿Qué pasó ayer?', 'Comedia', 'Jhon', 130, 'Es una muy buena película', 2009, '4.6 estrellas', 'Español e inglés');

Select * from Pelicula;

Delimiter $$
	Create procedure sp_AgregarPromocion(in idPromocion int, in nombre_promocion varchar(255), in descripcion text, in fechas_validez varchar(255), codigo_promocion varchar(255))
		Begin 
			Insert into Promocion(idPromocion, nombre_promocion, descripcion, fechas_validez, codigo_promocion)
				values(idPromocion, nombre_promocion, descripcion, fechas_validez, codigo_promocion);
        End$$
Delimiter ;

call sp_AgregarPromocion(1, 'Dos por uno este Domingo', 'Este domingo podras tener la oportunidad de disfrutar cualquier pelicula de nuestro catalogo, y llevarte un boleto totalmente gratis!!!', '11-10-2023', 1);
call sp_AgregarPromocion(2, 'ComboPalomin', 'Combo de palomitas con pepsi agrandado', '06-07-2023',2);
call sp_AgregarPromocion(3, 'ComboAmigos', 'Combo que incluye 2 palomitas, dos gaseosas y un combo de nachos', '08-08-2023',3);
call sp_AgregarPromocion(4, 'Kinavideño', 'En la compra de un combo de palomitas, te regalamos una entrada al cine gratis!!!', '29-12-2023',4);

Delimiter $$
	Create procedure sp_ListarPromocion()
		Begin
			Select 
				Promocion.idPromocion,
                Promocion.nombre_promocion,
                Ppromocion.descripcion,
                Promocion.fechas_validez,
                Promocion.codigo_promocion
                from Promocion;
        End$$
Delimiter ;

Delimiter $$
	Create procedure sp_EditarPromocion(in _idPromocion int, in _nombre_promocion varchar(255), in _descripcion text, in _fechas_validez varchar(255), _codigo_promocion varchar(255))
		Begin
			Update Promocion 
				set Promocion.nombre_promocion = _nombre_promocion,
                    Promocion.descripcion = _descripcion, 
                    Promocion.fechas_validez = _fechas_validez,
                    Promocion.codigo_promocion = _codigo_promocion
                    where Promocion.idPromocion = _idPromocion;
        End$$
Delimiter ;

call sp_EditarPromocion(1, 'Tres por uno', 'Compra 1 y te llevas 3!!!', '11-11-2023', 1);
call sp_EditarPromocion(2, 'Kinallowin', 'En la compra de un bolleto de cine de cualquier pelicula de terror, te regalamos un combo con palomitas', '10-10-2023', 2);
call sp_EditarPromocion(3, 'Kinascua', 'Combo que incluye una caja con forma de huevo de pascua', '06-06-2023',3);
call sp_EditarPromocion(4, 'ComboHotDog', 'Combo con un hotdog', '09-10-2023', 4);

Delimiter $$
	Create procedure sp_EliminarPromocion(in _idPromocion int)
		Begin
			Delete from Promocion
            where Promocion.idPromocion = _idPromocion;
        End$$
Delimiter ;

call sp_EliminarPromocion(2);

Delimiter $$
	Create procedure sp_BuscarPromocion(in _idPromocion int)
		Begin
			Select
				Promocion.idPromocion,
                Promocion.nombre_promocion,
                Promocion.descripcion,
                Promocion.fechas_validez,
                Promocion.codigo_promocion
                from Promocion where idPromocion = _idPromocion;
        End$$
Delimiter ;

call sp_BuscarPromocion(1);

select * from Promocion;
