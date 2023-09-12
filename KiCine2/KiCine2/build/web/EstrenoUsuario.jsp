<%-- 
    Document   : EstrenoUsuario
    Created on : 9/09/2023, 05:30:23 PM
    Author     : aleja
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Estrenos U</title>
    </head>
    <body>
        <br>
        <div class="d-flex">
            
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-body">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Titulo</th>
                                    <th>Genero</th>
                                    <th>Sinopcis</th>
                                    <th>lanzamiento</th>
                                    <th>Descripcion Estreno</th>
                                    <th>Fecha Estreno</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="lista" items="${estreno}">
                                <tr>
                                    <td>${list.getIdEstreno()}</td>
                                    <td>${list.getPelicula_id()}</td>
                                    <td>${list.getDescripcionEstreno()}</td>
                                    <td>${list.getFecha_estreno()}</td>

                                    
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                    </div>



                </div>
            </div>

        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>