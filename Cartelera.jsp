<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Cartelera</title>
    </head>
    <body>
    <center>
        <h1>Menu Cartelera</h1>
    </center>
    <div class="d-flex">
        <div class="col-sm-5">
            <div class="card">
                <form action="Controlador?menu=RegistrarVentas" method="POST">
                    <div class="card-body">

                        <div class="form-group">
                            <h5>Datos Cartelera</h5>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="txtCodigoCartelera" value="${cartelera.getIdCartelera()}" class="form-control" placeholder="Código Cartelera">
                                <button type="submit" name="accion" value="BuscarCartelera" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-3">

                                <input type="date" id="start" name="trip-start"/>
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="txtPelicula_id" value="${cartelera.getPelicula_id()}" class="form-control" placeholder="Código Pelicula">
                            </div>
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="txtHorario_id" value="${cartelera.getHorario_id()}" class="form-control" placeholder="Código Horario">
                            </div>
                        </div>
                        <!--AGREGAR REGISTRO -->
                        <div class="form-group">
                            <div>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Cartelera</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="card">
                <div class="card-body">
                    <table class="table table-hober">
                        <thead>
                            <tr>
                                <th>Código Cartelera</th>
                                <th>Fecha</th>
                                <th>Código Pelicula</th>
                                <th>Código Horario</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getCodigoCartelera()}</td>
                                    <td>${list.getFecha()}</td>
                                    <td>${list.getPelicula_id()}</td>
                                    <td>${list.getHorario_id()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer d-flex">
                    <div class="col-sm-6">
                        <input type="submit" name="accion" value="Generar Ventana" class="btn btn-success">
                        <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
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
