<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Entradas</title>
    </head>
    <body>
    <center>
        <h1>Entradas</h1>
    <div class="d-flex">
        <div class="col-sm-12">
            <br>
            <table class="table table-hober" style=" text-align: center">
                <thead>         
                    <tr>
                        <td>idEntrada</td>
                        <td>horarioP_id</td>
                        <td>cine_id</td>
                        <td>preventa_id</td>
                        <td>cantidadEntradas</td>
                        <td>pagoTotal</td>
                        <td>Acciones</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entrada" items="${entradas}">
                        <tr>
                            <td>${entrada.getIdEntrada()}</td>
                            <td>${entrada.getHorarioP_id()}</td>
                            <td>${entrada.getCine_id()}</td>
                            <td>${entrada.getPreventa_id()}</td>
                            <td>${entrada.getCantidadEntradas()}</td>
                            <td>${entrada.getPagoTotal()}</td>
                            <td>
                                <a class="btn btn-outline-info" href="Controlador?menu=Entrada&accion=Editar&idEntrada=${entrada.getIdEntrada()}">Editar</a>
                                <a class="btn btn-danger"  onclick="return confirm('desea eliminar este registro')" href="Controlador?menu=Entrada&accion=Eliminar&id=${entrada.getIdEntrada()}">Eliminar</a>
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
                <form action="Controlador?menu=Entrada" method="POST">
                    <div>
                        <label>Horario de proyeccion</label>
                        <input type="text" value="${entrada.getHorarioP_id()}" name="txtHorarioP_id" class="form-control">
                        
                    </div>
                    <div>
                        <label>Cine</label>
                        <input type="text" value="${entrada.getCine_id()}" name="txtCine_id" class="form-control">
                    </div>
                    <div>
                        <label>Preventa</label>
                        <input type="text" value="${entrada.getPreventa_id()}" name="txtPreventa_id" class="form-control">
                    </div>
                    <div>
                        <label>Cantidad de entradas</label>
                        <input type="text" value="${entrada.getCantidadEntradas()}" name="txtCantidadEntradas" class="form-control">
                    </div>
                    <div>
                        <label>Total a pagar</label>
                        <input type="text" value="${entrada.getPagoTotal()}" name="txtPagoTotal" class="form-control">
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
