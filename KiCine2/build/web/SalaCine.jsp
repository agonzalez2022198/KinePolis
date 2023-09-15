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
    <body  style="background-image: url('img/fondoAdm.png'); background-size: cover; background-repeat: no-repeat;">
        <br>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                    <form action="Controlador?menu=SalaCine" onsubmit="return validarCampos()" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <br>
                                <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Datos de la Sala:</strong></label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" name="txtCine_id" value="${list.getCine_id()}" class="form-control" placeholder="id Cine">
                                </div>
                            </div>

                            <div class="form-group">
                                <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Agregar Sala:</strong></label>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" name="txtNumeroSala" value="${list.getNumeroSala()}" class="form-control" placeholder="Numero de sala">
                                </div>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" name="txtCapacidad" value="${list.getCapacidad()}" class="form-control" placeholder="Capacidad sala">
                                </div>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" name="txtTipoSala" value="${list.getTipoSala()}" class="form-control" placeholder="Tipo de sala">
                                </div>
                            </div>

                            <!-- AGREGAR REGISTRO-->
                            <div class="form-group">
                                <div>
                                    <button type="submit" name="accion" value="agregar" class="btn btn-info" style="margin: 5px;">Agregar Sala</button>
                                    <button type="submit" name="accion" value="Actualizar" class="btn btn-dark" style="margin: 5px;">Actualizar Sala</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                    <div class="card-body">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Código Sala Cine</th>
                                    <th>Numero de Sala</th>
                                    <th>Capacidad</th>
                                    <th>Tipo Sala</th>
                                    <th>Código Cine</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${salaCine}">
                                    <tr>
                                        <td>${list.getIdSalaCine()}</td>
                                        <td>${list.getNumeroSala()}</td>
                                        <td>${list.getCapacidad()}</td>
                                        <td>${list.getTipoSala()}</td>
                                        <td>${list.getCine_id()}</td>
                                        <td class="d-flex">
                                            <a class="btn btn-warning" href="Controlador?menu=SalaCine&accion=Editar&idSalaCine=${list.getIdSalaCine()}" style="margin: 5px;">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=SalaCine&accion=Eliminar&idSalaCine=${list.getIdSalaCine()}" onclick="return confirm('¿Esta seguro que quiere eliminar el dato?')" style="margin: 5px;">Eliminar </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>

        <script>
            function validarCampos() {
                // Obtén los valores de los campos de entrada
                var Cine_id = document.getElementsByName("txtCine_id")[0].value;
                var NumeroSala = document.getElementsByName("txtNumeroSala")[0].value;
                var Capacidad = document.getElementsByName("txtCapacidad")[0].value;
                var TipoSala = document.getElementsByName("txtTipoSala")[0].value;
                // Verifica si alguno de los campos está vacío
                if (Cine_id === "" || NumeroSala === "" || Capacidad === "" || Capacidad === "" || TipoSala === "") {
                    // Muestra una alerta
                    alert("La accion no es valida, llene todos los campos.");
                    // Detén el envío del formulario
                    return false;
                }
                // Si todos los campos están llenos, permite que el formulario se envíe
                return true;
            }
        </script>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
