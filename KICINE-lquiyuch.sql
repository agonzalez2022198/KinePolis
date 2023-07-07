
Drop database if exists kicine;

Create database Kicine;

use Kicine;
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
  primary key PK_idUsuario(idUsuario)
);

-- ------------------ Procedimientos almacenados -------------------------
-- --------------------------------------Usuario---------------------------------------------
-- --------------------------------------Agregar---------------------------------------------
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
Delimiter $$
	Create procedure sp_EliminarUsuario(in sp_idUsuario int)
		Begin
			Delete from Usuario
				where idUsuario = sp_idUsuario;
        End$$
Delimiter ;

call sp_EliminarUsuario(5);