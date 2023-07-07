Use Kicine;




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


