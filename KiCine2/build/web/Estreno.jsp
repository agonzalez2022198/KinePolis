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
        <br>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=Estreno" method="POST">

                        <div clas="card-body">
                           
                            <div class="form-group">
                                <br>
                                <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Datos del Estreno:</strong></label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="txtId_pelicula" value="${list.getPelicula_id()}" class="form-control" placeholder="id Pelicula">
                                    
                                </div>
                                
                            </div>
                            <!-- FORMULARIO PRODUCTO -->



                            <div class="form-group">
                                <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Agregar Estreno:</strong></label>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input type="text" name="txtDescripcionEstreno" value="${list.getDescripcionEstreno()}" class="form-control" placeholder="Descripción">
                                </div>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input type="date" id="start" name="txtFechaEstreno " value="${list.getFecha_estreno()}" class="form-control" placeholder="Stock">
                                </div>
                            </div>
                            <!-- AGREGAR REGISTRO-->
                            <div class="form-group">
                                <div>
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Estreno</button>
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                                </div>
                            </div>
                            

                            <!-- AGREGAR REGISTRO-->

                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>idEstreno</th>
                                    <th>pelicula_id</th>
                                    <th>descripcionEstreno</th>
                                    <th>fechaEstreno</th>

                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${estreno}">
                                <tr>
                                    <td>${list.getIdEstreno()}</td>
                                    <td>${list.getPelicula_id()}</td>
                                    <td>${list.getDescripcionEstreno()}</td>
                                    <td>${list.getFecha_estreno()}</td>

                                    <td class="d-flex">
                                        <a class="btn btn-warning" href="Controlador?menu=Estreno&accion=Editar&codigoEstreno=${list.getIdEstreno()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=Estreno&accion=Eliminar&codigoEstreno=${list.getIdEstreno()}" onclick="return confirm('¿Esta seguro que quiere eliminar el dato?')" >Eliminar </a>
                                    </td>
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
