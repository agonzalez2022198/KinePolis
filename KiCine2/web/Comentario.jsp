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
        <link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
        <title>Comentario</title>
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
    <body style="background-image: url('img/fondoAdm.png'); background-size: cover; background-repeat: no-repeat;">
        <header class="header">
            <h1>Comentario</h1>
        </header>
        <div class="d-flex">
            <div class="col-sm-15">
                <div class="card">
                    <form action="Controlador?menu=Comentario" method="POST">
                        <div class="card-body" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                            <div>
                                <label>ID de Usuario:</label>
                            </div>
                            
                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <input type="text" name="txtUsuario_id" value="${usuario.getIdUsuario()}" class="form-control input-text" placeholder="">
                                </div>
                                <div>
                                    <button type="submit" name="accion" value="BuscarUsuario" href="Controlador?menu=Comentario&accion=BuscarUsuario" class="btn btn-outline-light">Buscar</button>
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" value="${usuario.getNombre()}" name="txtNombre" class="form-control">
                                </div>
                            </div>
                            
                            <div class="form-group d-flex">
                                <label>Pelicula</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <input type="text" name="txtPeliculaId" value="${pelicula.getIdPelicula()}" class="form-control input-text">
                                </div>
                                <div>
                                    <button type="submit" name="accion" value="BuscarPelicula" href="Controlador?menu=Comentario&accion=BuscarPelicula" class="btn btn-outline-light">Buscar</button>
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" value="${pelicula.getTitulo()}" name="txtNombre" class="form-control">
                                </div>
                            </div>
                            
                            <div class="col-sm-11">
                                <label>Comentario:</label>
                                <input type="text" value="${comentario.getTexto()}" name="txtComentario" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <div>
                                    <button type="submit"  name="accion" value="Agregar" class="btn btn-outline-info">Agregar Comentario</button>
                                </div>
                            </div>
<!------------------------------------------------  Editar     -------------------------------------------------------------------------------------------------------------------->
                            <br>
                            
                                <div>
                                    <label>Nuevo ID de Usuario:</label>
                                </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <input type="text" name="txtNewUsuario_id" value="${comentario.getUsuario_id()}" class="form-control" placeholder="Codigo">
                                </div>
                                
                            </div>
                            
                            <div class="form-group d-flex">
                                <label>Pelicula</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-2">
                                    <input type="text" value="${comentario.getPelicula_id()}" name="txtNewPeliculaId" class="form-control">
                                </div>
                                
                            </div>
                            
                            <div class="col-sm-11">
                                <label>Comentario:</label>
                                <input type="text" value="${comentario.getTexto()}" name="txtNewComentario" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <div>
                                    <button type="submit" name="accion" value="Actualizar" class="btn btn-outline-warning" href="Controlador?menu=Comentario&accion=Actualizar">Actualizar</button>
                                </div> <!-- -->
                            </div>
                            
                        
                        </div>
                    </form>
                
                </div>
            </div>
            <div class="col-sm-7">
                
                
                
                <div class="card" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                    <div class="card-body">
                        <table class="table table-hober">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Usuario</th>
                                    <th>Pelicula</th>
                                    <th>Opinion</th>
                                    <th>Opinion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="comentario" items="${comentarios}">
                                    <tr>
                                        <td>${comentario.getIdComentario()}</td>
                                        <td>${comentario.getUsuario_id()}</td>
                                        <td>${comentario.getPelicula_id()}</td>
                                        <td>${comentario.getTexto()}</td>
                                        <td class="d-flex">
                                            <a href="Controlador?menu=Comentario&accion=Editar&codigoComentario=${comentario.getIdComentario()}" class="btn btn-warning">Editar</a>
                                            <a href="Controlador?menu=Comentario&accion=Eliminar&codigoComentario=${comentario.getIdComentario()}" class="btn btn-danger"onclick="return confirm('Desea eliminar este registro')" style="margin-left: 10px">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
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