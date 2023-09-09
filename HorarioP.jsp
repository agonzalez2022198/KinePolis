<%-- 
    Document   : Estreno
    Created on : 21/07/2023, 11:08:49 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Estrenos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=HorarioP" method="POST">                                   
                        <div class="form-group">
                            <label>IdHorarioP:</label>
                            <input type="text" value="${horarioP.idHorarioP()}" name="txtIdHorarioP" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>HorarioP:</label>
                            <input type="Time" value="${horarioP.horarioP()}" name="txtHorario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha:</label>
                            <input type="Date" value="${horarioP.getFecha()}" name="txtFecha" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono:</label>
                            <input type="text" value="${horarioP.getDisponibilidadAsientos()}" name="txtDisponibilidadAsientos()" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado:</label>
                            <input type="text" value="${horarioP.getSala_id()}" name="txtSala_id" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" value="${horarioP.getPelicula_id()}" name="txtPelicula_id" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>

            <div class="col-sm-8">   
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>idHorarioP</th>
                                <th>horario</th>
                                <th>fecha</th>
                                <th>disponibilidadAsientos</th>
                                <th>sala_id</th>
                                <th>pelicula_id</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="horarioP" items="${listaHorarioP}">
                                <tr>
                                    <td>${listaHorarioP.getIdHorarioP()}</td>
                                    <td>${listaHorarioP.getHorario()}</td>
                                    <td>${listaHorarioP.getFecha()}</td>
                                    <td>${listaHorarioP.getDisponibilidadAsientos()}</td>
                                    <td>${listaHorarioP.getSala_id()}</td>                               
                                    <td>${listaHorarioP.getPelicula_id()}</td>
                                    <td>                                                    
                                        <a class="btn btn-warning" href="#">Editar</a>
                                        <a class="btn btn-danger" href="#">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
