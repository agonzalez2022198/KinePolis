
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

Select * from Login;


Insert into Login(usuario, contrasena)
	values('agonzalez2006', '123');

Create table Usuario(
  idUsuario int auto_increment not null,
  nombre varchar(255) not null,
  apellido varchar(255) not null,
  correo_electronico varchar(255) not null,
  contrasena varchar(255) not null,
  -- tarjeta_credito varchar(255) not null,
  primary key PK_idUsuario(idUsuario)
);



-- Factura
Create table Factura(
  idFactura int auto_increment not null,
  fecha_emision date not null,
  total_pago decimal(10, 2) not null,
  usuario_id int not null,
  primary key PK_idFactura(idFactura),
  foreign key (usuario_id) references Usuario(idUsuario)
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
Create table FuncionEspecial (
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



-- login

Delimiter $$
	Create procedure sp_AgregarUsuario(in sp_nombre varchar(255), in sp_apellido varchar(255), in sp_correo_electronico varchar(255), in sp_contrasena varchar(255))
    Begin
		Insert into Usuario(nombre, apellido, correo_electronico, contrasena)
			values(sp_nombre, sp_apellido, sp_correo_electronico, sp_contrasena);
    End$$
Delimiter ;

call sp_AgregarUsuario("Manuel", "Torres", "mtorres48@gmail.com", "12345");
call sp_AgregarUsuario("Carlos", "Villagran", "ccarlos@gmail.com", "c4895");
call sp_AgregarUsuario("Norman", "Barcarcel", "normanbarcarcel@gmail.com", "54321");
call sp_AgregarUsuario("Pablo", "Monroy", "pabloteee@gmail.com", "pablo123");
call sp_AgregarUsuario("Tadeo", "Perez", "tadeoperez@gmail.com", "0123");

-- --------------------------------------Listar---------------------------------------------
Delimiter $$
	Create procedure sp_ListarUsuarios()
		Begin
			Select
				U.idUsuario, 
                U.nombre, 
                U.apellido, 
                U.correo_electronico, 
                U.contrasena
				from Usuario U;
        End$$
Delimiter ;

call sp_ListarUsuarios;

-- --------------------------------------Buscar---------------------------------------------
Delimiter $$
	Create procedure sp_BuscarUsuario(in sp_idUsuario int)
		Begin
			Select
				U.idUsuario, 
                U.nombre, 
                U.apellido, 
                U.correo_electronico, 
                U.contrasena
				from Usuario U where U.idUsuario = sp_idUsuario;
        End$$
Delimiter ;

call sp_BuscarUsuario(1);

-- --------------------------------------Editar---------------------------------------------
Delimiter $$
	Create procedure sp_EditarUsuario(in sp_idUsuario int, in sp_nombre varchar(255), in sp_apellido varchar(255), in sp_correo_electronico varchar(255), in sp_contrasena varchar(255))
    Begin
		Update Usuario U
			set U.nombre = sp_nombre, U.apellido = sp_apellido, U.correo_electronico = sp_correo_electronico, U.contrasena = sp_contrasena
				where U.idUsuario = sp_idUsuario;
    End$$
Delimiter ;

call sp_EditarUsuario(1, "Daniel", "Lopez", "danilopez@gmail.com", "123456");

-- --------------------------------------Eliminar---------------------------------------------
/*Delimiter $$
	Create procedure sp_EliminarUsuario(in sp_idUsuario int)
		Begin
			Delete from Usuario
				where idUsuario = sp_idUsuario;
        End$$
Delimiter ;*/

-- call sp_EliminarUsuario(5);


-- Pelicula

/*Delimiter $$
	Create procedure sp_AgregarPelicula(in titulo varchar(255), in genero varchar(255), in director varchar(255), in duracion int, in sinopsis text,
		in ano_lanzamiento int, in clasificacion varchar(50), in idiona varchar(50))
	Begin
		Insert into Pelicula(titulo, genero, director, duracion, sinopsis, ano_lanzamiento, calificacion, idioma)
			values(titulo, genero, director, duracion, sinopsis, ano_lanzamiento, calificacion, idioma);
    End$$
Delimiter ;*/

call sp_AgregarPelicula('El Rey León', 'Animación', 'Roger Allers', 88, 'Un joven león debe enfrentar su destino y reclamar su lugar como rey.', 1994, 'G', 'Inglés');

call sp_AgregarPelicula('El Laberinto del Fauno', 'Fantasía', 'Guillermo del Toro', 118, 'Una niña se adentra en un laberinto mágico durante la posguerra española.', 2006, 'R', 'Español');

call sp_AgregarPelicula('Harry Potter y la Piedra Filosofal', 'Fantasía', 'Chris Columbus', 152, 'Un niño descubre que es un mago y comienza su aventura en la escuela de magia y hechicería.', 2001, 'PG', 'Inglés');

call sp_AgregarPelicula('La La Land', 'Musical', 'Damien Chazelle', 128, 'Una historia de amor entre una aspirante a actriz y un pianista de jazz en Los Ángeles.', 2016, 'PG-13', 'Inglés');

call sp_AgregarPelicula('El Gran Gatsby', 'Drama', 'Baz Luhrmann', 143, 'La historia de un enigmático millonario que organiza fiestas extravagantes en la década de 1920.', 2013, 'PG-13', 'Inglés');

call sp_AgregarPelicula('La forma del agua', 'Fantasía', 'Guillermo del Toro', 123, 'Una mujer muda se enamora de una criatura acuática en un laboratorio secreto.', 2017, 'R', 'Inglés');

-- Procedimiento almacenado para listar películas
Delimiter $$
	Create procedure sp_ListarPeliculas()
	Begin
		Select * from Pelicula;
	End$$
Delimiter ;

-- Procedimiento almacenado para eliminar una película por su ID
Delimiter $$
	Create procedure sp_EliminarPelicula(in pelicula_id int)
	Begin
		Delete from Pelicula where id = pelicula_id;
	End$$
Delimiter ;

-- Procedimiento almacenado para buscar una película por su título
Delimiter $$
	Create procedure sp_BuscarPeliculaPorTitulo(in pelicula_titulo varchar(255))
	Begin
		select * from Pelicula where titulo = pelicula_titulo;
	End$$
Delimiter ;

-- Procedimiento almacenado para actualizar una película por su ID
Delimiter $$
	Create procedure sp_ActualizarPelicula(
		in pelicula_id int,
		in nuevo_titulo varchar(255),
		in nuevo_genero varchar(255),
		in nuevo_director varchar(255),
		in nueva_duracion int,
		in nueva_sinopsis text,
		in nuevo_ano_lanzamiento int,
		in nueva_clasificacion varchar(50),
		in nuevo_idioma varchar(50)
	)
	Begin
		Update Pelicula set
			titulo = nuevo_titulo,
			genero = nuevo_genero,
			director = nuevo_director,
			duracion = nueva_duracion,
			sinopsis = nueva_sinopsis,
			ano_lanzamiento = nuevo_ano_lanzamiento,
			calificacion = nueva_clasificacion,
			idioma = nuevo_idioma
		where id = pelicula_id;
	End$$

Delimiter ;


-- ------------------Agregar SalaCine
Delimiter $$
	create procedure sp_AgregarSalaCine(in numSala int,in cap int, in tipSala varchar(50),in ubi varchar(255))
        Begin
			Insert Into SalaCine(numero_sala, capacidad, tipo_sala, ubicacion)
				values (numSala, cap, tipSala, ubi);
        End $$
Delimiter ;

call sp_AgregarSalaCine(1, 50, '3D', 'Pasillo Derecho');
call sp_AgregarSalaCine(2, 75, 'Normal', 'Pasillo Izquierdo');
call sp_AgregarSalaCine(3, 125, '3D', 'Pasillo Derecho');
call sp_AgregarSalaCine(4, 100, 'Normal', 'Pasillo Izquierdo');
call sp_AgregarSalaCine(5, 150, 'VIP', 'Pasillo Derecho');
-- ---------------- Listar SalaCine
Delimiter $$
	Create procedure sp_ListarSalaCines()
		Begin
			Select
            S.idSalacine, 
            S.numero_sala, 
            S.capacidad, 
            S.tipo_sala, 
            S.ubicacion
            From SalaCine S;
        End $$
Delimiter ;

call sp_ListarSalaCines;
-- ------------------ Buscar SalaCine
Delimiter $$
	Create procedure sp_BuscarSalaCine(in idSala int)
		Begin
			Select
            S.idSalacine,
            S.numero_sala,
            S.capacidad,
            S.tipo_sala,
            S.ubicacion
            From SalaCine S Where idSala = S.idSalacine;
        End$$
Delimiter ;

call sp_BuscarSalaCine(1);
call sp_BuscarSalaCine(2);
call sp_BuscarSalaCine(3);
call sp_BuscarSalaCine(4);
call sp_BuscarSalaCine(5);
-- ------------------ Editar SalaCine
Delimiter $$
	Create procedure sp_EditarSalaCine(in idSala int, in numSala int, in cap int, in tipSala varchar(50), in ubi varchar(255))
		Begin
			Update SalaCine S
				set S.numero_sala = numSala,
					S.capacidad = cap,
                    S.tipo_sala = tipSala,
                    S.ubicacion = ubi
				Where S.idSalacine = idSala;
        End$$
Delimiter ;

call sp_EditarSalaCine(1, 1, 250, "VIP", "Pasillo Central");
call sp_ListarSalaCines;
-- ------------------ Eliminar SalaCine
Delimiter $$
	Create procedure sp_EliminarSalaCine(in idSala int)
		Begin
			Delete From SalaCine
				Where idSalaCine = idSala;
        End$$
Delimiter ;

-- call sp_EliminarSalaCine(1);
call sp_ListarSalaCines;


-- --------------------------Procedimiento Almacenado Agregar de Horarios de Proyeccion
Delimiter $$
	Create procedure sp_AgregarHorariosProyeccion(in hora_inicio time, in hora_fin time, in disponibilidad_asientos int, in sala_id int,
    in pelicula_id int)
    Begin
		Insert into HorariosProyeccion(hora_inicio, hora_fin, disponibilidad_asientos, sala_id, pelicula_id)
				values(hora_inicio, hora_fin, disponibilidad_asientos, sala_id, pelicula_id);
    End$$
Delimiter ;

call sp_AgregarHorariosProyeccion("12:00","14:45", 50, 1, 1);
call sp_AgregarHorariosProyeccion("15:00","17:45", 50, 2, 2);
call sp_AgregarHorariosProyeccion("18:00","20:45", 50, 3, 3);
call sp_AgregarHorariosProyeccion("21:00","23:45", 50, 4, 4);



-- --------------------------Procedimiento Almacenado Listar de Horarios de Proyeccion
Delimiter $$
	Create Procedure sp_ListarHorariosProyeccion()
    Begin
		Select 
			HP.idHorariosProyeccion,
            HP.hora_inicio,
            HP.hora_fin,
            HP.disponibilidad_asientos,
            HP.sala_id,
            HP.pelicula_id
            from HorariosProyeccion HP;
    End$$
Delimiter ; 

Call sp_ListarHorariosProyeccion();


-- --------------------------Procedimiento Almacenado Buscar de Horarios de Proyeccion
Delimiter $$
	Create Procedure sp_BuscarHorariosProyeccion(in idHorariosProy int)
    Begin
		Select 
            HP.hora_inicio,
            HP.hora_fin,
            HP.disponibilidad_asientos,
            HP.sala_id,
            HP.pelicula_id
            from HorariosProyeccion HP where HP.idHorariosProyeccion = idHorariosProy;
    End$$
Delimiter ; 

Call sp_BuscarHorariosProyeccion(1);
Call sp_BuscarHorariosProyeccion(2);
Call sp_BuscarHorariosProyeccion(3);
Call sp_BuscarHorariosProyeccion(4);



-- --------------------------Procedimiento Almacenado Editar de Horarios de Proyeccion
Delimiter $$
	create Procedure sp_EditarHorariosProyeccion(in idHorariosProy int, in hora_i time, in hora_f time, in disp_asientos int, in sal_id int,
    in peli_id int)
    Begin
		Update HorariosProyeccion HP
			set HP.hora_inicio = hora_i, HP.hora_fin = hora_f, HP.disponibilidad_asientos = disp_asientos,
				HP.sala_id = sal_id, HP.pelicula_id = peli_id
					where HP.idHorariosProyeccion = idHorariosProy;
		
    End$$
Delimiter ;


Call sp_EditarHorariosProyeccion(1,"24:00", "02:45", 60, 1, 1);
Call sp_EditarHorariosProyeccion(2,"03:00", "05:45", 60, 2, 2);
Call sp_EditarHorariosProyeccion(3,"06:00", "08:45", 60, 3, 3);
Call sp_EditarHorariosProyeccion(4,"09:00", "11:45", 60, 4, 4);


Select * from HorariosProyeccion;
-- --------------------------Procedimiento Almacenado Eliminar de Horarios de Proyeccion
Delimiter $$
	Create Procedure sp_EliminarHorariosProyeccion(in idHorariosProy int )
    Begin
		Delete from HorariosProyeccion
			where HorariosProyeccion.idHorariosProyeccion = idHorariosProy;
    End$$
Delimiter ;

-- Call sp_EliminarHorariosProyeccion(1);
-- Call sp_EliminarHorariosProyeccion(2);
-- Call sp_EliminarHorariosProyeccion(3);
-- Call sp_EliminarHorariosProyeccion(4);


Select * from Pelicula;


-- ---- Reserva

-- Agregar ------------------
Delimiter $$
Create procedure sp_AgregarReserva(in _pelicula_idPelicula int, in _sala_id int, in _horario_id int, in _usuario_id int, in _cantidad_entradas int)
    Begin
        Insert into Reserva (pelicula_idPelicula,sala_id,horario_id,usuario_id,cantidad_entradas)
            Values (_pelicula_idPelicula,_sala_id,_horario_id,_usuario_id,_cantidad_entradas);
    End$$
Delimiter ;
call sp_AgregarReserva(1,2,3,2,54);
call sp_AgregarReserva(2,3,2,4,32);
call sp_AgregarReserva(3,1,1,4,23);
call sp_AgregarReserva(3,2,3,1,32);


-- Editar -------------------
Delimiter $$
    Create procedure sp_EditarReserva(in _idReserva int,in _pelicula_idPelicula int,in _sala_id int,in _horario_id int,
                                        in _usuario_id int,in _cantidad_entradas int)
        Begin
            Start transaction;
                Update Reserva R
                set R.idReserva = _idReserva, R.pelicula_idPelicula = _pelicula_idPelicula, R.sala_id = _sala_id, R.horario_id = _horario_id, R.usuario_id = _usuario_id, R.cantidad_entradas = _cantidad_entradas
                where R.idReserva = _idReserva;
            commit;
        End$$
Delimiter ;
call sp_EditarReserva(2,2,2,2,2,23);


Delimiter $$
    Create procedure sp_ListarReservas()
    Begin 
        Select 
        R.idReserva,
        R.pelicula_idPelicula,
        R.sala_id,
        R.horario_id,
        R.usuario_id,
        R.cantidad_entradas

        from Reserva R;
    End$$
Delimiter ;
call sp_ListarReservas();



-- Buscar
Delimiter $$
    Create procedure sp_BuscarReserva(in _idReserva int)
        Begin
            select
            R.idReserva,
            R.pelicula_idPelicula,
            R.sala_id,
            R.horario_id,
            R.usuario_id,
            R.cantidad_entradas
            From Reserva R where R.idReserva = _idReserva;
        End$$
Delimiter ;
call sp_BuscarReserva(1);


Delimiter $$
    Create procedure sp_EliminarReserva(in idReserva int)
        Begin
            Delete From Reserva
            where idReserva = idReserva;
        End$$
Delimiter ;
call sp_EliminarReserva(1);


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
	Delete from Cine where id = Cine.idCine;
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



-- ---------------------------------------Procedimientos almacenados Taquilla ---------------------------------------------------------
-- ----------------------------------------Agregar Taquilla-----------------------------------------------------------------------

Delimiter $$
	Create procedure sp_AgregarTaquilla(in numero_taquilla int, in ubicacion varchar (255),in estado varchar (255),in capacidad int,
										in tipo_pago_aceptado varchar (255),in horario_operacion varchar(255), in id_cine int)
		Begin
			Insert into Taquilla (numero_taquilla, ubicacion, estado, capacidad, tipo_pago_aceptado, horario_operacion, id_cine)
				values (numero_taquilla, ubicacion, estado, capacidad, tipo_pago_aceptado, horario_operacion, id_cine);
        End$$
Delimiter ;

call sp_AgregarTaquilla (1, 'Taquilla No.1', 'Clientes VIP', 25, 'Tarjeta de credito', 'Jueves 6 de Julio 14:00', 1 );
call sp_AgregarTaquilla (2, 'Taquilla No.2', 'Boletos', 50, 'Efectivo', 'Viernes 7 de julio 18:00',2);
call sp_AgregarTaquilla (3, 'Taquilla No.3', 'Comida', 25, 'Efectivo', 'Martes 11 de julio 20:00',3);
call sp_AgregarTaquilla (4, 'Taquilla No.4', 'Pre-ordenados', 50, 'Tarjeta de credito', 'Domingo 9 de julio 21:30',4);

-- -----------------------------------------Listar Taquillas ---------------------------------------------------------------
Delimiter $$
	Create procedure sp_ListarTaquillas ()
		Begin
			Select 
				T.idTaquilla, 
				T.numero_taquilla, 
				T.ubicacion, 
				T.estado, 
				T.capacidad, 
				T.tipo_pago_aceptado, 
				T.horario_operacion, 
				T.id_cine
				from Taquilla T;
        End$$
Delimiter ;

call sp_ListarTaquillas();

-- ----------------------------------------- buscar taquilla -----------------------------------------------------------------

Delimiter $$
	Create procedure sp_BuscarTaquilla (in idTaqui int)
		Begin
			Select 
				T.idTaquilla, 
				T.numero_taquilla, 
				T.ubicacion, 
				T.estado, 
				T.capacidad, 
				T.tipo_pago_aceptado, 
				T.horario_operacion, 
				T.id_cine
				from Taquilla T where idTaquilla = idTaqui;            
        End$$
Delimiter ;

call sp_BuscarTaquilla(1);

-- -----------------------------------------editar taquilla-----------------------------------------------------------------------

Delimiter $$
	Create procedure sp_EditarTaquilla(in idTaqui int,in num_taquilla int, in ubica varchar (255),in estad varchar (255),in capaci int,
										in tipo_pago_acept varchar (255),in horario_opera varchar(255), in id_cin int)
		Begin
			Update Taquilla T
				set T.numero_taquilla = num_taquilla,
					T.ubicacion = ubica,
					T.estado = estad,
                    T.capacidad = capaci,
                    T.tipo_pago_aceptado = tipo_pago_acept,
                    T.horario_operacion = horario_opera,
					T.id_cine = id_cin
                    where idTaquilla = idTaqui;
        End$$
Delimiter ;

call sp_EditarTaquilla(1, 10, 'Taquilla No.10', 'Comida', 50, 'Efectivo', 'Miercoles 19 de julio 15:00', 4);

-- --------------------------------------Eliminar Taquilla -------------------------------------------------------

Delimiter $$
	Create procedure sp_EliminarTaquilla(in idTaqui int )
		Begin
			Delete from Taquilla
				where idTaquilla = idTaqui;
        End$$
Delimiter ;




-- Comentario

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
call sp_AgregarComentario(4,4,'Es una excelente pelicula en cuanto a trama se refire, aunque su personaje principal deja mucho que desear',8);
call sp_AgregarComentario(4,4,'Es una excelente pelicula en cuanto a trama se refire, aunque su personaje principal deja mucho que desear',8);

 


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

 

-- call sp_EliminarComentario(1);

 
-- drop procedure sp_ActualizarComentario;
Delimiter $$
    Create procedure sp_ActualizarComentario(in codComentario int, in codUsuario int, in codPelicula int, in tex text, in codPuntuacion int)
        Begin
            Update Comentario C
                set C.usuario_id = codUsuario,
                C.pelicula_id = codPelicula,
                C.texto = tex,
                C.puntuacion = codPuntuacion
                    where C.idComentario = codComentario;
        end $$
Delimiter ;

 

call sp_ActualizarComentario(1,2,3,'Apesar de ser considerada una joya actualmente hay que tener en cuenta que se estan aprovechando de la nostalgia, cosa que np dura mucho',3);





-- ------ Promociones

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

-- call sp_EliminarPromocion(2);

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






-- ------------------ Procedimientos almacenados -----------------------------
Delimiter $$
	Create procedure sp_AgregarFuncionEspecial(in tipo_funcion varchar(255), in descripcion text, in pelicula_id int, in horario_id int)
    Begin
		Insert into FuncionEspecial( tipo_funcion, descripcion, pelicula_id, horario_id)
			values( tipo_funcion, descripcion, pelicula_id, horario_id);
    End$$
Delimiter ;

Call sp_AgregarFuncionEspecial('Función 1', 'Pelicula 1', 1, 1);
Call sp_AgregarFuncionEspecial('Función 2', 'Descripción de la función 2', 2, 2);
Call sp_AgregarFuncionEspecial('Función 3', 'Nueva pelicula', 3, 3);
Call sp_AgregarFuncionEspecial('Función 4', 'De lo mejor', 4, 4);
-- Call sp_AgregarFuncionEspecial('Función 5', 'Descripción de la función 5', 5, 5);



Delimiter $$
	Create procedure sp_ListarFunciones()
    Begin 
		Select 
			F.idFuncionEspecial,
            F.tipo_funcion,
            F.descripcion,
            F.pelicula_id,
            F.horario_id
            from FuncionEspecial F;
		End$$
Delimiter ;
call sp_ListarFunciones();



Delimiter $$
Create procedure sp_BuscarFuncionEspecial(in idFuncionEspecial int)
Begin
	Select FE.idFuncionEspecial,
            FE.tipo_funcion,
            FE.descripcion,
            FE.pelicula_id,
            FE.horario_id
            from FuncionEspecial FE
        where idFuncionEspecial = FE.idFuncionEspecial;
End$$
Delimiter ;

call sp_BuscarFuncionEspecial(1);


Delimiter $$
create procedure sp_EditarFuncionEspecial(in idFuncionEspecial int ,in tipo_funcion varchar(255), in descripcion text, in pelicula_id int, in horario_id int)
Begin
    Update FuncionEspecial set Tipo_Funcion = tipo_funcion, descripcion = descripcion , pelicula_id = pelicula_id, horario_id = horario_id
		where idFuncionEspecial = idFuncionEspecial;
End$$
Delimiter ;
call sp_EditarFuncionEspecial (2,'Funcion nueva', 'El Renacer', 2, 2);




Delimiter $$
Create procedure sp_EliminarFuncionEspecial(in idFuncionEspecial int)
Begin
	Delete from  FuncionEspecial where idfuncionEspecial = idFuncionEspecial;
End$$
Delimiter ;

call sp_EliminarFuncionEspecial(1);



-- ------------------ Agregar Estreno
Delimiter $$
	Create procedure sp_AgregarEstreno(in pelicula_id int,in fecha_estreno date,in promocion_id int)
		Begin
			Insert into Estreno(pelicula_id, fecha_estreno, promocion_id)
				Values (pelicula_id, fecha_estreno, promocion_id);
        End$$
Delimiter ;

call sp_AgregarEstreno(1, '2023-02-05', 1);
call sp_AgregarEstreno(2, '2023-02-09', 2);
call sp_AgregarEstreno(3, '2023-05-02', 3);
call sp_AgregarEstreno(4, '2023-06-03', 4);

-- ------------------ Listar Estrenos
Delimiter $$
	Create Procedure sp_ListarEstrenos()
		Begin
			Select
            E.idEstreno,
            E.pelicula_id, 
            E.fecha_estreno, 
            E.promocion_id
            from Estreno E;
		End$$
Delimiter ;

call sp_ListarEstrenos();

-- --------------------------- Buscar Estreno
Delimiter $$
	Create Procedure sp_BuscarEstreno(in idEstren int)
		Begin
			Select 
            E.idEstreno, 
            E.pelicula_id, 
            E.fecha_estreno, 
            E.promocion_id
            From Estreno E
            where idEstreno = idEstren;
        End $$
Delimiter ;

call sp_BuscarEstreno(1);

-- ---------------------- Eliminar Estreno 
Delimiter $$
	Create procedure sp_EliminarEstreno(in idEstren int)
		Begin
			Delete from Estreno
            where idEstreno = idEstren;
        End $$
Delimiter ;

-- call sp_EliminarEstreno();

-- -------------- Editar Estreno
Delimiter $$
	Create Procedure sp_EditarEsteno(in idEstren int, in peli_id int,in fech_estreno date,in promo_id int)
		Begin
			Update Estreno E
            Set
            E.pelicula_id = peli_id, 
            E.fecha_estreno = fech_estreno, 
            E.promocion_id = promo_id
            where idEstreno = idEstren;
        End $$
Delimiter ;

call sp_EditarEsteno (1, 1, '2023-02-05', 1);







-- -------- Cartelera

Delimiter $$
Create procedure sp_AgregarCartelera(in fecha date, in pelicula_id int, in horario_id int)
    Begin
		Insert into Cartelera(fecha, pelicula_id, horario_id)
			values(fecha, pelicula_id, horario_id);
    End$$
Delimiter ;

Call sp_AgregarCartelera (now(), 1, 1);
Call sp_AgregarCartelera (now(), 2, 2);
Call sp_AgregarCartelera (now(), 3, 3);
Call sp_AgregarCartelera (now(), 4, 4);

-- --------------------------------------------------------------------------------------------

Delimiter $$
	Create procedure sp_ListarCartelera ()
		Begin
			Select
			C.idCartelera,
			C.fecha,
			C.pelicula_id,
			C.horario_id
            from Cartelera C;
        End$$
Delimiter ;

Call sp_ListarCartelera ();

-- ---------------------------------------------------------------------------------------------

Delimiter $$
	Create procedure sp_BuscarCartelera (in idCart int)
		Begin
			Select 
			C.idCartelera,
			C.fecha,
			C.pelicula_id,
			C.horario_id
            from Cartelera C
            where idCartelera = idCart;
        End$$
Delimiter ;

Call sp_BuscarCartelera (1);

-- -------------------------------------------------------------------------------------------

Delimiter $$
	Create procedure sp_EliminarCartelera (in idCart int)
    Begin
		Delete from Cartelera
        where idCartelera = idCart;
    End$$
Delimiter ;

-- Call sp_EliminarCartelera(3);

-- ------------------------------------------------------------------------------------------

 Delimiter $$
	Create procedure sp_EditarCartelera (in idCart int,in fec date, in peli_id int,in hor_id int)
        Begin
			Update Cartelera C
            set
            C.fecha = fec,
            C.pelicula_id = peli_id,
            C.horario_id = hor_id
            where idCart = idCartelera;
		End$$
 Delimiter ;

-- Call sp_EditarCartelera (1, now(), 1, 1);


