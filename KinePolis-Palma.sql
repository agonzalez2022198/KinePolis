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


Call sp_EditarHorariosProyeccion("24:00", "02:45", 60, 1, 1);
Call sp_EditarHorariosProyeccion("03:00", "05:45", 60, 2, 2);
Call sp_EditarHorariosProyeccion("06:00", "08:45", 60, 3, 3);
Call sp_EditarHorariosProyeccion("09:00", "11:45", 60, 4, 4);


Select * from HorariosProyeccion;
-- --------------------------Procedimiento Almacenado Eliminar de Horarios de Proyeccion
Delimiter $$
	Create Procedure sp_EliminarHorariosProyeccion(in idHorariosProy int )
    Begin
		Delete from HorariosProyeccion
			where HorariosProyeccion = idHorariosProy;
    End$$
Delimiter ;

Call sp_EliminarHorariosProyeccion(1);
Call sp_EliminarHorariosProyeccion(2);
Call sp_EliminarHorariosProyeccion(3);
Call sp_EliminarHorariosProyeccion(4);