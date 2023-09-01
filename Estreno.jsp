<%-- 
    Document   : Estreno
    Created on : 21/07/2023, 11:08:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Estreno</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controlador?menu=Clientes" method="POST">

                        <div class="col-sm-8 d-flex">
                            <div class="col-sm-5">
                                <label>Id Pelicula:</label>
                                
                                
                            </div>
                            &nbsp;
                            <input type="text" name="txtCodigoCliente" value="${cliente.getCodigoCliente()}" class="form-control" placeholder="Codigo">
                            <input type="submit" name="accion" value="Id Pelicula" class="btn btn-outline-info">
                            <br>
                        </div>
                            <br>
                        <div class="form-group d-flex">
                            <div class="col-sm-5">
                            <label>Fecha de estreno:</label>
                            </div>
                            
                            
                         
                            <input type="date" id="start" name="trip-start"/>
                        </div>
                        <br>
                        <div class="col-sm-10 d-flex">
                            <div class="col-sm-5">
                            <label>ID Promocion:</label>
                            </div>
                            <input type="text" name="txtCodigoCliente" value="${cliente.getCodigoCliente()}" class="form-control" placeholder="Codigo">
                            <input type="submit" name="accion" value="Id Promocion" class="btn btn-outline-info">
                        </div>
                            <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info" href="Controlador?menu=Clientes&accion=Agregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success" href="">
                    </form>
                </div>
            </div>
            <div class="col-sm-6">
                <table class="table table-hober">
                    <thead>
                        <tr>
                            <td>ID Estreno</td>
                            <td>Pelicula Id</td>
                            <td>echa estreno</td>
                            <td>Promocion</td>
                            <td>Acciones</td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cliente" items="${clientes}">
                        <tr>
                            <td>${cliente.getCodigoCliente()}</td>
                            <td>${cliente.getDPICliente()}</td>
                            <td>${cliente.getNombresCliente()}</td>
                            <td>${cliente.getDireccionCliente()}</td>
                            
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Clientes&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Clientes&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}" onclick="return confirm('¿Esta seguro que quiere eliminar el dato?')">Eliminar</a>
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
