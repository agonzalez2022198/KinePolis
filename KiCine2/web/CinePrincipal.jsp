<%-- 
    Document   : CinePrincipal
    Created on : sep 13, 2023, 11:08:08 p.m.
    Author     : Windows 10
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styleCompra.css">
        <title>JSP Page</title>
    </head>
    <body style="background-color: gray;">
        <c:forEach var="cine" items="${cine}">
            <div class="contenedor" >

                <h1 class="tituloPelicula" style="text-align: center;">${cine.getNombre()}</h1>
                <hr>

                <div style="margin: 0 auto; text-align: center;">
                        <h3 style="color: white;">${cine.getTitulo()}</h3>
                        <p style="color: white;">${cine.getDuracion()}min</p>
                </div>
                <hr>
                <br>
                <hr>
                <div style="margin: 0 auto; text-align: left;">
                        <p style="color: white;"><b>${cine.getFecha()}</b></p>
                        <p style="color: white;"><strong>Hora: ${cine.getHorario()}</strong></p>
                        
                </div>
                <hr>
                <hr>
                <div style="margin: 0 auto; text-align: left;">

                    <p style="color: white;">Sala: ${cine.getNumeroSala()}</p>
                        
                </div>
                    <a href="Controlador?menu=compraFinalP&accion=listar&idH=${cine.getIdHorario()}&idC=${cine.getIdCine()}&idP=${cine.getIdPreventa()}&cod=${cod}" style="background-color: gray; color: white;" >Seleccionar horario</a>


            </div>
        </c:forEach>
    </body>
</html>
