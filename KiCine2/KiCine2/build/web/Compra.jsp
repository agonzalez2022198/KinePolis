<%-- 
    Document   : Compra
    Created on : sep 12, 2023, 7:20:41 a.m.
    Author     : Windows 10
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Horario y Boletos</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                background-color: #f5f5f5;
                margin: 0;
                padding: 0;
            }

            .container {
                background-color: #fff;
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            }

            h1 {
                font-size: 28px;
                color: #333;
            }

            #horario {
                font-size: 24px;
                margin-bottom: 20px;
                color: #333;
            }

            #cantidad-boletos {
                font-size: 18px;
                color: #666;
            }

            #botones {
                margin-top: 20px;
            }

            button {
                font-size: 24px;
                padding: 10px 20px;
                margin: 0 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button:disabled {
                background-color: #ccc;
                cursor: not-allowed;
            }
        </style>
    </head>
    <body>
        <hr>
        <c:forEach var="lista" items="${lista}">
            <div class="container">
                <h1>Horario de Evento</h1>
                <div id="horario">Hora ${lista.getHorario()}</div>
                <div id="fecha">Fecha: ${lista.getFecha()}</div>
                <div id="sala">Sala: ${lista.getSala_id()}</div>
                <div id="asiento">${lista.getDisponibilidadAsientos()}</div>
                <div id="restantes-boletos">Boletos restantes: </div>
                <div id="cantidad-boletos">Boletos comprados:  <span id="cantidad">0</span></div>
                <div id="botones">
                    <button id="btn-menos" disabled>-</button>
                    <button id="btn-mas">+</button>
                </div>
                <hr>
                <a href="Controlador?menu=realizarCompra&accion=compra"><button id="">Aceptar</button></a>
            </div>
        </c:forEach>

        <script>
            // Obtener elementos del DOM
            const cantidadElement = document.getElementById('cantidad');
            const btnMas = document.getElementById('btn-mas');
            const btnMenos = document.getElementById('btn-menos');

            let cantidadBoletos = 0;
            let cantidadAsientos = parseInt(document.getElementById('asiento').textContent); // Inicializa la cantidad de asientos
            let otherCant = cantidadAsientos;
            // Función para actualizar la cantidad de boletos
            function actualizarCantidad() {
                cantidadElement.textContent = cantidadBoletos.toString();
                document.getElementById('restantes-boletos').textContent = "Boletos restantes: "+otherCant.toString();
                console.log(cantidadElement, cantidadAsientos);
                // Habilitar o deshabilitar el botón "menos" según la cantidad
                btnMenos.disabled = cantidadBoletos === 0;
                // Deshabilitar el botón "más" cuando se llega al límite deseado
                btnMas.disabled = cantidadBoletos === cantidadAsientos; // Cambia esto al límite deseado
            }

            // Manejadores de eventos para los botones
            btnMas.addEventListener('click', () => {
                if (cantidadBoletos < cantidadAsientos) { // Cambia esto al límite deseado
                    cantidadBoletos++;
                    otherCant--; // Resta uno a la cantidad de asientos
                    actualizarCantidad();
                }
            });

            btnMenos.addEventListener('click', () => {
                if (cantidadBoletos > 0) {
                    cantidadBoletos--;
                    otherCant++; // Suma uno a la cantidad de asientos
                    actualizarCantidad();
                }
            });

            // Inicializar la cantidad al cargar la página
            actualizarCantidad();


        </script>
    </body>
</html>
