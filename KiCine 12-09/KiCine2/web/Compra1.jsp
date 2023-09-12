

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styleCompra.css">
        <title>Compra de Boletos</title>
    </head>
    <body>
        <header class="cabecera">
            <div class="anchocabecera">
                <div class="imagen-principal">
                    <img class="logo" src="img/logoUser.png">
                </div>
                <nav class="menu">
                    <a href="Controlador?menu=InicioSesion">Cerrar Sesión</a>
                </nav>
            </div>
        </header>
        <div class="capa"></div>
        <div class="contenedor">

            <h1 class="tituloPelicula">Five Nights At Seba's</h1>
            <br>
            <div class="card" >
                <h1 class="instrucciones">Seleccione un Cine.</h1>
                <select class="formSelect">
                    <option selected>AQUI</option>
                    <option value="1">ALLA</option>
                    <option value="2">SI</option>
                    <option value="3">CABAL</option>
                </select>
            </div>
            <div class="card" >
                <h1 class="instrucciones">Seleccione una fecha.</h1>
                <select class="formSelect">
                    <option selected>Hoy</option>
                    <option value="1">Mañana</option>
                    <option value="2">20-09</option>
                    <option value="3">15-10</option>
                </select>
            </div>
            
            <div class="card" >
                <h1 class="instrucciones">Seleccione un horario.</h1>
                <div id="botones-container">

                </div>
            </div>
            <div class="boton-aceptar">ASDFSD </a>
            </div>


        </div>

        <script>
            // Supongamos que tienes un arreglo de elementos
            var elementos = ["20:30", "23:10", "27:14", "14:00"];

            // Obtén el contenedor donde deseas colocar los botones
            var contenedor = document.getElementById("botones-container");

            // Función para mostrar la confirmación con el valor seleccionado
            function mostrarConfirmacion(valor) {
                var confirmacion = confirm("¿Desea seleccionar el horario: " + valor );
            }

            // Itera sobre el arreglo y crea botones para cada elemento
            elementos.forEach(function (elemento) {
                var boton = document.createElement("button"); // Crea un elemento de botón
                boton.textContent = elemento; // Establece el texto del botón
                boton.className = "boton-personalizado"; // Aplica la clase de estilo
                boton.onclick = function () {
                    var valorSeleccionado = this.textContent; // Obtiene el texto del botón
                    mostrarConfirmacion(valorSeleccionado);
                };
                contenedor.appendChild(boton); // Agrega el botón al contenedor
            });
        </script>
    </body>
</html>
