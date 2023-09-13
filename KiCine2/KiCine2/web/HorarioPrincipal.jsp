<%-- 
    Document   : Promociones
    Created on : sep 11, 2023, 8:57:33 p.m.
    Author     : Windows 10
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Horarios</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
            }

            .header {
                background-color:   black;
                color: white;
                text-align: center;
                padding: 20px;
                width: 100%;
            }

            h1 {
                font-size: 36px;
                margin: 0;
            }

            .promocion {
                width: 300px;
                margin: 20px;
                background-color: white;
                border: 1px solid #ccc;
                box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
                padding: 10px;
                text-align: center;
            }

            .promocion img {
                max-width: 100%;
            }

            .promocion h2 {
                font-size: 24px;
                margin: 10px 0;
            }

            .promocion p {
                font-size: 16px;
            }

            .comprar-button {
                background-color: #333;
                color: white;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                font-size: 18px;
                margin-top: 10px;
            }

            .comprar-button:hover {
                background-color: #555;
            }

            footer {
                background-color: #333;
                color: white;
                text-align: center;
                padding: 10px;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <h1>Horarios</h1>
        </div>
    <c:forEach var="p" items="${lista}">
        <div class="promocion">
            <h2>${p.getHorario()}</h2>
            <p>${p.getFecha()}</p>
            <p>${p.getDisponibilidadAsientos()}</p>
            
            <a href="Controlador?menu=compraBoletos&accion=listarCod&cod=${p.getIdHorariosProyeccion()}"><button class="comprar-button">Adquirir</button></a>
        </div>
    </c:forEach>
    <footer>
        © 2023 KinePolis
    </footer>
</body>
</html>
