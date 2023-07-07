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
