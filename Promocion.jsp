<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Promocion</title>
    </head>
    <body>
        <br>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=Promocion" method="POST">
                        <div clas="card-body">
                            <div class="form-group">
                                <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Agregar Promocion:</strong></label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <label>&nbsp;&nbsp;Nombre Promocion:</label>
                                    <input type="text" name="txtNombrePromocion" value="${list.getNombrePromocion()}" class="form-control" placeholder="Nombre Promocion">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <label>&nbsp;&nbsp;Descripcion:</label>
                                    <input type="text" name="txtDescripcion" value="${list.getDescripcion()}" class="form-control" placeholder="Descripcion">
                                </div>
                            </div>
                                <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <label>&nbsp;&nbsp;fecha de validez:</label>
                                    <input type="text" name="txtFechasValidez" value="${list.getFechasValidez()}" class="form-control" placeholder="Fecha validez">
                                </div>
                                </div>
                                <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <label>&nbsp;&nbsp;Precio:</label>
                                    <input type="text" name="txtPrecio" value="${list.getPrecio()}" class="form-control" placeholder="Precio">
                                </div>
                                </div>
                                <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <label>&nbsp;&nbsp;Pelicula ID:</label>
                                    <input type="text" name="txtPelicula_id" value="${list.getPelicula_id()}" class="form-control" placeholder="pelicula id">
                                </div>     
                            </div>
                            <div class="form-group">
                                <div>
                                    <input type="submit" href="Controlador?menu=Promocion&accion=Agregar" name="accion" value="Agregar" class="btn btn-success">
                                    <input type="submit" name="accion" value="Actualizar" class="btn btn-warning" href="Controlador?menu=Promocion&accion=Actualizar" >
                                </div>
                            </div>
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
                                    <th>ID Promocion</th>
                                    <th>Nombre Promocion</th>
                                    <th>descripcion Promocion</th>
                                    <th>Fecha de Validez</th>
                                    <th>Precio</th>
                                    <th>Pelicula id</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${promocion}">
                                    <tr>
                                            <td>${list.getIdPromocion()}</td>
                                            <td>${list.getNombrePromocion()}</td>
                                            <td>${list.getDescripcion()}</td>
                                            <td>${list.getFechasValidez()}</td>
                                            <td>${list.getPrecio()}</td>
                                            <td>${list.getPelicula_id()}</td>
                                        <td class="d-flex">
                                            <a class="btn btn-warning" href="Controlador?menu=Promocion&accion=Editar&codigoPromocion=${list.getIdPromocion()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Promocion&accion=Eliminar&codigoPromocion=${list.getIdPromocion()}" onclick="return confirm('¿Esta seguro que quiere eliminar el dato?')" >Eliminar </a>
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