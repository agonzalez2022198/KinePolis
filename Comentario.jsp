<%-- 
    Document   : Comentario
    Created on : 21/07/2023, 11:06:39 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Comentario</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-7">
                <div class="card"
                    <form action="Controlador?menu=Comentario" method="POST">
                        <div class="card-body">
                            <div>
                                <label>ID de Usuario:</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <input type="text" value="${usuario.getIdUsuario()}" name="txtUsuario_id" class="form-control" placeholder="Codigo">
                                </div>
                                <div>
                                    <buttom type="submit" name="accion" value="BuscarUsuario" href="Controlador?menu=Comentario&accion=BuscarUsuario" class="btn btn-outline-light">Buscar</buttom>
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" value="" name="txtNombre" class="form-control">
                                </div>
                            </div>
                            
                            <div class="form-group d-flex">
                                <label>Pelicula</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <input type="text" value="id" name="txtPeliculaId" class="form-control">
                                </div>
                                <div>
                                    <buttom class="btn btn-outline-light" type="submit" name="accion" value="BuscarPelicula" href="Controlador?menu=Comentario&accion=BuscarPelicula">Buscar</buttom>
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" value="" name="txtNombre" class="form-control">
                                </div>
                            </div>
                            
                            <div class="col-sm-11">
                                <label>Comentario:</label>
                                <input type="text" value="" name="txtComentario" class="form-control"><br>
                            </div>
                            <div class="col-sm-2">
                                <label>Punuación:</label>
                                <input type="text" value="" name="txtPuntuacion" class="form-control"><br><br>
                                <buttom class="btn btn-outline-light" type="submit" name="accion" value="Agregar" href="Controlador?menu=Comentario&accion=Agregar">Agregar</buttom>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Serie No.</label>
                            <input type="text" name="txtNumSerie" class="form-control"><br>
                        </div>
                        <table class="table table-hober">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Usuario</th>
                                    <th>Opinion</th>
                                    <th>Calificacion</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getCodigoProducto()}</td>
                                        <td>${list.getDescripcionProd()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td class="d-flex">
                                            <a href="Controlador?menu=RegistrarVenta&accion=BuscarProducto&txtCodigoProducto=${list.getCodigoProducto()}" class="btn btn-warning">Editar</a>
                                            <a href="Controlador?menu=RegistrarVenta&accion=Eliminar&codigoVenta=${list.getCodigoVenta()}" class="btn btn-danger"onclick="return confirm('Desea eliminar este registro')" style="margin-left: 10px">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-success" href="Controlador?menu=Carrito&accion=Agregar" target="myFrame" value="Agregar carrito">
                                Agregar Compra
                            </a>
                            <a href="Controlador?menu=RegistrarVenta&accion=Clear" id="clear" style="margin-left: 10px; border: none" class="btn btn-outline-danger"onclick="return confirm('Desea eliminar todos los registros?')" type="submit" name="accion" value="Cancelar">
                                Cancelar
                            </a>
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="Q. ${totalPagar}" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
