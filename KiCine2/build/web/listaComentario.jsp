<%-- 
    Document   : ComentarioPrincipal
    Created on : 14/09/2023, 01:48:43 PM
    Author     : informatica
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="col-sm-7">
            <div class="card">
                <div class="card-body">

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>idComentario</th>
                                <th>idUsuario</th>
                                <th>Comentario</th>

                            </tr>
                        </thead>
                        <c:forEach var="list" items="${cm}">
                            <tbody>
                                <tr>
                                    <td>${list.getIdComentario()}</td>
                                    <td>${list.getUsuario_id()}</td>
                                    <td>${list.getTexto()}</td>
                                </tr>



                            </tbody>
                        </c:forEach>
                    </table>
                </div>


            </div>
        </div>
    </body>
</html>
