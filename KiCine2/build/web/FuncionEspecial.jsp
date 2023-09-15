<%-- 
    Document   : FuncionEspecial
    Created on : 21/07/2023, 11:07:57 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Funcion Especial</title>
    </head>
    <body>
    <center>
        <h1>Funcion Especial</h1>
    <div class="d-flex">
        <div class="col-sm-12">
            <br>
            <table class="table table-hober" style=" text-align: center">
                <thead>         
                    <tr>
                        <td>idFuncionEspecial</td>
                        <td>tipoFuncion</td>
                        <td>descripcion</td>
                        <td>pelicula_id</td>
                        <td>precio</td>
                        <td>Acciones</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="funcionEspecial" items="${funcionesEspeciales}">
                        <tr>
                            <td>${funcionEspecial.getIdFuncionEspecial()}</td>
                            <td>${funcionEspecial.getTipoFuncion()}</td>
                            <td>${funcionEspecial.getDescripcion()}</td>
                            <td>${funcionEspecial.getPelicula_id()}</td>
                            <td>${funcionEspecial.getPrecio()}</td>
                            <td>
                                <a class="btn btn-outline-info" href="Controlador?menu=FuncionEspecial&accion=Editar&idFuncion=${funcionEspecial.getIdFuncionEspecial()}">Editar</a>
                                <a class="btn btn-danger" onclick="return confirm('desea eliminar este registro')" href="Controlador?menu=FuncionEspecial&accion=Eliminar&id=${funcionEspecial.getIdFuncionEspecial()}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <br>
            <br>


           <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=FuncionEspecial" method="POST">
                    <div>
                        <label>Tipo de fucion</label>
                        <input type="text" value="${funcionEspecial.getTipoFuncion()}" name="txtTipoFuncion" class="form-control">
                        
                    </div>
                    <div>
                        <label> Descripcion </label>
                        <input type="text" value="${funcionEspecial.getDescripcion()}" name="txtDescripcion" class="form-control">
                    </div>
                    <div>
                        <label>Id pelicula</label>
                        <input type="text" value="${funcionEspecial.getPelicula_id()}" name="txtPelicula_id" class="form-control">
                    </div>
                    <div>
                        <label>Precio</label>
                        <input type="text" value="${funcionEspecial.getPrecio()}" name="txtPrecio" class="form-control">
                    </div>

                    <br>
                    <input type="submit" name="accion" value="agregar" class="btn btn-warning" >
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success" >
                </form>
            </div>
        </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>