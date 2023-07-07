
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
	Create procedure sp_AgregarComentario(in usuario_id int, in pelicula_id int, in texto text, in puntuacion int)
    Begin
		Insert into Comentario(usuario_id, pelicula_id, texto, puntuacion)
			values(usuario_id, pelicula_id, texto, puntuacion);
    End$$
Delimiter ;

call sp_AgregarComentario(1,1,'Es una excelente pelicula en cuanto a trama se refire, aunque su personaje principal deja mucho que desear',8);
call sp_AgregarComentario(2,2,'La premisa es interesante por lo que es bastante interesante al inicio, sin embargo no supieron aprovechar bien este recurso',6);
call sp_AgregarComentario(3,3,'Es bastante entretenida apesar de que el publico no tenia muchas espectativas en ella por lo que es recomendable',7);
call sp_AgregarComentario(4,4,'Como tal la pelicula no es disfrutable, debido a que la trama no queda muy bien establecida en cuanto a sus personajes son bastante fastidiosos',5);
call sp_AgregarComentario(2,4,'Es una pelicula excelente para ver con la familia especialmente los infantes',9);


Delimiter $$
	Create procedure sp_ListarComentario()
		Begin
			Select
				C.idComentario,
                C.usuario_id,
                C.Pelicula_id,
                C.texto,
                C.puntuacion
					From Comentario C;
        end $$
Delimiter ;

call sp_ListarComentario();

Delimiter $$
	Create procedure sp_BuscarComentario(in idCom int)
		Begin
			Select
				C.idComentario,
                C.usuario_id,
                C.Pelicula_id,
                C.texto,
                C.puntuacion
					From Comentario C where idCom;
        end $$
Delimiter ;

call sp_BuscarComentario(1);

Delimiter $$
	Create procedure sp_EliminarComentario(in codComentario int)
		Begin
			start transaction;
				Delete from Comentario where codComentario = idComentario;
            commit;
		end $$
Delimiter ;

call sp_EliminarComentario(5);

Delimiter $$
	Create procedure sp_ActualizarComentario(in codComentario int, in codUsuario int, in codPelicula int, in tex int, in codPuntuacion int)
		Begin
			Update Comentario C
				set C.usuario_id = codUsuario,
                C.pelicula_id = codPelicula,
                C.texto = tex,
                C.puntuacion = codPuntuacion
					where C.idComentario = codComentario;
		end $$
Delimiter ;

call sp_ActualizarComentario(1,2,3,'Apesar de ser considerada una joya actualmente hay que tener en cuenta que se estan aprovechando de la nostalgia, cosa que np dura mucho',7);
