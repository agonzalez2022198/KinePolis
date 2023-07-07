Drop database if exists kicine;

Create database Kicine;

use Kicine;

Create table Cartelera(
  idCartelera int auto_increment not null,
  fecha date not null,
  pelicula_id int not null not null,
  horario_id int not null not null,
  primary key PK_idCartelera(idCartelera),
  constraint FK_Cartelera_Pelicula foreign key (pelicula_id) 
	references Pelicula(idPelicula),
  constraint FK_Cartelera_Horario foreign key (horario_id) 
	references HorariosProyeccion(idHorariosProyeccion)
);

-- ----------------------------------------------------------------------------------------

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

Call sp_EditarCartelera (1, now(), 1, 1);

