<%-- 
    Document   : EstrenoPrincipal
    Created on : sep 11, 2023, 11:17:09 p.m.
    Author     : Windows 10
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : Estreno
    Created on : 21/07/2023, 11:08:49 PM
    Author     : Admin
--%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Estrenos U</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: linear-gradient(to right, salmon, skyblue);
                margin: 20px;
                position: relative;
                overflow: hidden; /* Para ocultar cualquier parte de la imagen que se extienda más allá del marco */
            }

            .frame {
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                z-index: -1;
                pointer-events: none; /* Evita que las imágenes dentro del marco sean interactivas */
            }

            table {
                width: 80%;
                margin: 20px auto;
                border-collapse: collapse;
                background-color: #ccc;
                position: relative; /* Establece el contexto de apilamiento para el marco de imágenes */
                z-index: 1; /* Asegura que el contenido de la tabla esté sobre el marco */
            }

            th, td {
                padding: 10px;
                border: 1px solid #ccc;
                text-align: center;
                background-color: skyblue;
                color: skyblue;
            }

            th span {
                background-color: #015c91; 
                padding: 5px 10px; 
                border-radius: 5px; 
            }

            tr:hover {
                background-color: #cce5ff;
                cursor: pointer;
                border: 1px solid #888;
            }

            th {
                background-color: #333;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="frame">


        </div>

        <table>
            <thead>
                <tr>
                    <th><span class="nombre-columna">Estreno</span></th>
                    <th><span class="nombre-columna">Fecha</span></th>
                    <th><span class="nombre-columna">Descripcion</span></th>
                    <th><span class="nombre-columna">Imagen</span></th>
                </tr>
            </thead>
        </table>
        <c:forEach var="lista" items="${lista}">
            <table>
                <thead>
                    <tr>
                        <th><span class="nombre-columna">${lista.getTitulo()}</span></th>
                        <th><span class="nombre-columna">${lista.getFecha_estreno()}</span></th>
                        <th><span class="nombre-columna">${lista.getDescripcionEstreno()}</span></th>
                        <th><img src="ControllerIMG?id=${lista.getPelicula_id()}" style="width: 20%; height: 500%; object-fit: cover;"></th>
                    </tr>
                </thead>
            </table>
        </c:forEach>

    </body>
</html>