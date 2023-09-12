<%-- 
    Document   : PreventaAdmin
    Created on : 8/09/2023, 02:21:42 AM
    Author     : Compu Fire
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Empleados</title>
        <style>
            
            .header {
                background-color: #333;
                color: #fff;
                padding: 20px 0;
                text-align: center;
            }

            .header h1 {
                font-size: 36px;
            }
        </style>
    </head>
    <body>
        <header class="header">
            <h1>Preventa de Cine</h1>
        </header>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=PreventaAdmin" method="POST">
                        
                        <div class="form-group">
                            <label>DESCRIPCION:</label>
                            <input type="text" value="${preventas.getDescripcion()}" name="txtDescripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>PRECIO PREVENTA</label>
                            <input type="text" value="${preventas.getPrecioPreventa()}" name="txtPrecioPreventa" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>ID PELICULA:</label>
                            <input type="text" value="${preventas.getPelicula_id()}" name="txtPelicula_id" class="form-control">
                        </div>
                        
                        <input type="submit" name="accion" value="Agregar" href="Controlador?menu=PreventaAdmin&accion=Actualizar&cod=${preventas.getIdPreventa()}" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success" >
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hober">
                    <thead>
                        <tr>
                            <td>ID PREVENTA:</td>
                            <td>DESCRIPCION:</td>
                            <td>PRECIO PREVENTA:</td>
                            <td>PELICULA ID:</td>
                            
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="preventa" items="${preventa}">
                            <tr>
                                <td>${preventa.getIdPreventa()}</td>
                                <td>${preventa.getDescripcion()}</td>
                                <td>${preventa.getPrecioPreventa()}</td>
                                <td>${preventa.getPelicula_id()}</td>
                                
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=PreventaAdmin&accion=Editar&codigoPreventa=${preventa.getIdPreventa()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=PreventaAdmin&accion=Eliminar&Codigo=${preventa.getIdPreventa()}" onclick="confirmar(event)">Eliminar</a>
                                    <script>
                                        function confirmar(event) {
                                            const confirmacion = confirm("¿Deseas eliminar estos datos?");



                                            if (confirmacion) {
                                                alert("Eliminado");
                                                return true;
                                            } else {
                                                alert("Cancelado");
                                                event.preventDefault();
                                                return false;
                                            }
                                        }



                                        document.getElementById("eliminarLink").addEventListener("click", function (e) {
                                            if (!confirmar(e)) {
                                                e.preventDefault();
                                            }
                                        });
                                    </script>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>



        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  crossorigin="anonymous"></script>
    </body>
</html>

