<%-- 
    Document   : SalaCine
    Created on : 21/07/2023, 11:03:18 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Sala Cine</title>
    </head>
    <body>
        <br>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="POST">

                        <div class="card-body">
                            <br>
                            <label><strong>&nbsp;&nbsp;&nbsp;&nbsp;Datos de la Sala</strong></label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="txtidSalaCine" value="${cine.cine_id()}" class="form-control" placeholder="id Cine">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="txtNombre" value="${pelicula.getNombre()}" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label><strong>&nbsp;&nbsp;&nbsp;&nbsp;Agregar Sala</strong></label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="txtNumeroSala" value="${list.getNumeroSala()}" class="form-control" placeholder="Numero de Sala">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="txtCapacidad" value="${list.getCapacidad()}" class="form-control" placeholder="Capacidad">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="txtTipoSala" value="${list.getTipoSala()}" class="form-control" placeholder="Tipo de Sala">
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Sala</button>
                            </div>
                        </div>
                            
                        </div>    
                    </form>
                </div>
  
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>idSalaCine</th>
                                    <th>numeroSala</th>
                                    <th>capacidad</th>
                                    <th>tipoSala</th>
                                    <th>cine_id</th>
                                    
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${salaCine}">
                                    <tr>
                                        <td>${list.getidSalaCine()}</td>
                                        <td>${list.getNumeroSala()}</td>
                                        <td>${list.getCapacidad()}</td>
                                        <td>${list.getTipoSala()}</td>
                                        <td>${list.getCine_id}</td>
                                        
                                        <td class="d-flex">
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
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
