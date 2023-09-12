<%-- 
    Document   : ComentarioUsuario
    Created on : 10/09/2023, 04:07:39 PM
    Author     : Compu Fire
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comentario</title>
    </head>
    <body style="background-image: url('img/fondoAdm.png'); background-size: cover; background-repeat: no-repeat;">
        <div class="col-sm-30">
            <div class="card" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                    <div class="card-body">
                        <table class="table table-hober">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Usuario</th>
                                    <th>Pelicula</th>
                                    <th>Opinion</th>
                                    <th>Opinion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="pelicula" items="${comentarios}">
                                    <tr>
                                        <td>${pelicula.getIdComentario()}</td>
                                        <td>${pelicula.getUsuario_id()}</td>
                                        <td>${pelicula.getPelicula_id()}</td>
                                        <td>${pelicula.getTexto()}</td>
                                        <td class="d-flex">
                                            <a href="Controlador?menu=Comentario&accion=Editar&codigoComentario=${comentario.getIdComentario()}" class="btn btn-warning">Editar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                </div>
        </div>
    </body>
</html>
