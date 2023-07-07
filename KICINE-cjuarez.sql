Use Kicine;

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

call sp_EliminarSalaCine(1);
call sp_ListarSalaCines;