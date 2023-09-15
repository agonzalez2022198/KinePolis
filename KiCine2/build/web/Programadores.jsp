<%-- 
    Document   : Programadores
    Created on : 14/09/2023, 09:46:55 PM
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Galería de Imágenes</title>
    <style>
        .galeria {
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            height: 100vh;
        }
        .imagen-galeria {
            max-width: 100%;
            max-height: 300px;
            transition: opacity 0.5s;
        }
        .controles {
            display: flex;
            align-items: center;
            margin-top: 10px;
        }
        .boton {
            cursor: pointer;
            font-size: 24px;
            border: none;
            background: none;
            outline: none;
        }
        .titulo {
            margin-top: 10px;
        }
    </style>
</head>
<body style="background-image: url('img/fondoAdm.png'); background-size: cover; background-repeat: no-repeat;">
    <div class="galeria">
        <button class="boton" onclick="cambiarImagen(-1)">❮</button>
        <div>
            <img class="imagen-galeria" id="imagenActual" src="img/programers.jpg" >
            
            <h2 id="tituloImagen" class="titulo">Programadores</h2>
        </div>
        <button class="boton" onclick="cambiarImagen(1)">❯</button>
    </div>

    <script>
        var imagenes = ['img/luismichu.png', 'img/quezada.png', 'img/Jimenez.png', 'img/adolfo.jpg', 'img/Palma.jpeg', 'img/carlos.jpeg', 'img/Sebastian.jpeg','img/brandon.jpeg', 'img/McLovin.jpg', 'img/quiyuch.png', 'img/herlin.jpeg'];
        var titulos = ['Luis Monterroso', 'Josue Quezada', 'José Jiménez', 'Adolfo Gregorio', 'Angello javier', 'Carlos Juarez', 'Sebastian Ramirez', 'Brandon Gomez', 'Diego Morales', 'Luis Fernando', 'Herlin Gomez'];
        var imagenActual = 0;

        function cambiarImagen(direccion) {
            imagenActual += direccion;
            if (imagenActual < 0) imagenActual = imagenes.length - 1;
            if (imagenActual >= imagenes.length) imagenActual = 0;

            var imagen = document.getElementById('imagenActual');
            imagen.src = imagenes[imagenActual];

            var titulo = document.getElementById('tituloImagen');
            titulo.innerText = titulos[imagenActual];
        }
    </script>
</body>
</html>
