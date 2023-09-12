-- 7/09/2023 14:55

Drop database if exists kicine;
Create database Kicine;
use Kicine;

-- Se registran los usuarios, esta se usará solo en el login y para agregar usuarios, solo se maneja por usuario normal.
-- Con el ícono de ajustes vamos a hacer que pueda eliminar su usuario y actualizarlo.
-- Quiyuch
Create table Usuario(
  idUsuario int auto_increment not null,
  nombre varchar(255) not null,
  apellido varchar(255) not null,
  correo_electronico varchar(255) not null,
  contrasena varchar(255) not null,
  primary key PK_idUsuario(idUsuario)
);


insert into Usuario(nombre, apellido, correo_electronico, contrasena)
values("Juan Pablo", "Gonzalez Gregorio", "jpgonzalez123@gmail.com", "123");
select * from usuario;

-- Se agregan peliculas por el usuario master, tiene que tener crud completo.
Create table Pelicula(
  idPelicula int auto_increment,
  titulo varchar(255) not null,
  genero varchar(255) not null,
  director varchar(255) not null,
  duracion int not null, -- //////////////////////////// TIME?
  sinopsis text not null, -- dato que almacena 65000 caracteres
  lanzamiento date not null,
  calificacion varchar(50) not null,
  idioma varchar(50) not null,
  primary key PK_idPelicula(idPelicula)
);


insert into Pelicula (titulo, genero, director, duracion, sinopsis, lanzamiento, calificacion, idioma)
	values ("El patito feo", "comedia", "Guillermo del toro", 180, "Un pato  es brutalmente asesinado a manos de un ganzo", "2018-05-20", "4.3/5", "Polaco" ),
			("Supercool", "comedia", "Diego Morales", 180, "El mclovin es un loquillo", "2018-05-20", "10/5", "Q'chi" );

select * from Pelicula;
-- Las ubicaciones y cine que vamos a tener. Podemos registrarlos de una vez. Crud completo igual
-- Luis michu
Create table Cine(
  idCine int auto_increment not null,
  nombre varchar(255) not null,
  ubicacion varchar(255) not null,
  telefono varchar(50) not null,
  primary key PK_idCine(idCine)
);


Insert into Cine (nombre,ubicacion, telefono)
	values ("KinePolisCayala", "Ciudad Cayala", "34567321"),
		   ("KineSantaClara", "Santa Clara VillaNueva", "550110425");
select * from Cine;

-- Se ingresan los datos por el master, crud completo para esta entidad.
-- Acá vamos a saber donde se debe de ubicar el usuario cuando compre su entrada y vaya al cine.
-- También para saber en que cine está.
-- carlos juarez
Create table SalaCine(
  idSalacine int auto_increment not null,
  numeroSala int not null,
  capacidad int not null,
  tipoSala varchar(50) not null,
  cine_id int not null,
  primary key PK_idSalaCine(idSalaCine),
  foreign key (cine_id) references Cine(idCine)
);

insert into SalaCine(numeroSala, capacidad, tipoSala, cine_id)
	values(7,100,"IMAX", 1);
select * from SalaCine;

-- Esto se agrega por el master, acá aparecerán todos los horarios en que se puede ver la película, CRUD completo.
-- Con la disponibilidad de asientos tenemos que actualizar desde java cuantos asientos se compraron y restar en mysql.
-- Palma
Create table HorarioP(
  idHorarioP int auto_increment not null,
  horario time not null, 
  fecha date not null,  
  disponibilidadAsientos int not null,
  sala_id int not null,
  pelicula_id int not null,
  primary key PK_idHorarioP(idHorarioP),
  foreign key (sala_id) references SalaCine(idSalacine),
  foreign key (pelicula_id) references Pelicula(idPelicula)
);

insert into HorarioP(horario, fecha, disponibilidadAsientos, sala_id, pelicula_id)
	values("20:30","2023-12-21", 60, 1,1),
			("21:30","2023-12-21", 60, 1,2),
            ("22:30","2023-12-22", 60, 1,1);
select * from HorarioP;    
    
-- Brandon
-- Cuando el usuario quiera entrar en preventa se muestran las péliculas que se pueden adquirir en linea y comprar sus boletos.
-- Esto lo hace el master, debe de tener el crud completo.
Create table Preventa(
	idPreventa int not null auto_increment,
    descripcion varchar(255) not null,
    precioPreventa decimal(10, 2) not null,
    pelicula_id int not null,
    primary key PK_idPreventa(idPreventa),
    foreign key (pelicula_id) references Pelicula(idPelicula)
);

insert into Preventa (descripcion, precioPreventa, pelicula_id)
	values("Estreno: El patito feo", 20.55, 1);
select * from Preventa;


-- Sebastian
Create table Promocion(
  idPromocion int auto_increment not null,
  nombrePromocion varchar(255) not null,
  descripcion text not null,
  fechasValidez varchar(255) not null, -- //////////////////////////// DATE?
  precio decimal(10,2) not null,
  pelicula_id int not null,
  primary key PK_idPromocion(idPromocion),
  foreign key (pelicula_id) references Pelicula(idPelicula)
);
insert Promocion (nombrePromocion, descripcion, fechasValidez, precio, pelicula_id)
	values("2x1 Navidad", "Obten esta promocion en la compra de una entrada para la pelicula: El patito feo", "Miercoles 20 de Dicimebre", 30.00, 1);
select * from Promocion;
-- Beto
Create table FuncionEspecial (
  idFuncionEspecial int auto_increment not null,
  tipoFuncion varchar(255) not null,
  descripcion text not null,
  pelicula_id int not null,
  precio decimal(10,2),
  primary key PK_idFuncionEspecial(idFuncionEspecial),
  foreign key (pelicula_id) references Pelicula(idPelicula)
);
insert FuncionEspecial(tipoFuncion, descripcion, pelicula_id, precio)
	values("Funcion Navideña", "Obten un combo en la compra de una entrada para: El patito feo", 1, 40.50);
select * from FuncionEspecial;
-- La información que se va a poner para que el usuario sepa lo que compró
-- Estos datos los debe de llenar el usuario.
-- Diego
Create table Entrada(
  idEntrada int auto_increment not null,
  horarioP_id int not null,
  cine_id int not null,
  preventa_id int,
  promocion_id int,
  funcionEspecial_id int,
  cantidadEntradas int not null,
  pagoTotal decimal(10,2) not null,
  primary key PK_idEntrada(idEntrada),
  foreign key (horarioP_id) references HorarioP(idHorarioP),
  foreign key (cine_id) references Cine(idCine),
  foreign key (preventa_id) references Preventa(idPreventa),
  foreign key (promocion_id) references Promocion(idPromocion),
  foreign key (funcionEspecial_id) references FuncionEspecial(idFuncionEspecial)
);
insert Entrada(horarioP_id, cine_id, preventa_id, promocion_id, funcionEspecial_id, cantidadEntradas, pagoTotal) 
	values(1, 1, 1,null,null,2,30);
select * from Entrada;
-- Factura
-- La factura que se va a generar cuando reserven alguna película.
-- Quezada
Create table Factura(
  idFactura int auto_increment not null,
  fechaEmision date not null,
  usuario_id int not null,
  cine_id int not null,
  entrada_id int not null,
  subTotal decimal(10,2) not null, -- Falta conectar con los precios de las entradas.
  primary key PK_idFactura(idFactura),
  foreign key (usuario_id) references Usuario(idUsuario),
  foreign key (cine_id) references Cine(idCine),
  foreign key (entrada_id) references Entrada(idEntrada)
);
insert Factura(fechaEmision, usuario_id, cine_id, entrada_id, subTotal)
	values ("2023/12/15", 1,1,1,30);
select * from Factura;
-- Jimenez
-- Los agrega el usuario master, CRUD completo, este tendra un listar para los usuarios normales.
-- Así los usuarios pueden ver los estrenos de nuevas películas.
Create table Estreno(
  idEstreno int auto_increment not null,
  pelicula_id int not null,
  descripcionEstreno varchar(255),
  fechaEstreno date not null,
  primary key PK_idEstreno(idEstreno),
  foreign key (pelicula_id) references Pelicula(idPelicula)
);
insert Estreno(pelicula_id, descripcionEstreno, fechaEstreno)
	values(1, "Gran estreno: El patito feo", "2023/12/19");
select * from Estreno;

-- Herling
-- Los comentarios se hacen en un apartado donde se hace en general, no a cada película.
-- En cinépolis funciona de esa forma.
-- El usuario hace el comentario.
Create table Comentario(
  idComentario int auto_increment not null,
  usuario_id int not null,
  pelicula_id int not null,
  texto text not null,
  primary key PK_idComentario(idComentario),
  foreign key (usuario_id) references Usuario(idUsuario),
  foreign key (pelicula_id) references Pelicula(idPelicula)
);
insert Comentario(usuario_id, pelicula_id, texto)
	values(1,1,"Obra maestra de la animacion");
select * from Comentario;

select * from HorarioP where pelicula_id = 1;

select * from HorarioP where fecha = "2023-12-21";