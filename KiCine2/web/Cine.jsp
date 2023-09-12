<%-- 
    Document   : Cine
    Created on : 21/07/2023, 06:36:29 PM
    Author     : lmonterroso-2022135
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Cines</title>
    </head>
    <body style="background-image: url('img/fondoAdm.png'); background-size: cover; background-repeat: no-repeat;">
        <br>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                    <form action="Controlador?menu=Cine" method="POST" onsubmit="return validarCampos()">
                             <div class="card-body">
                            <div class="form-group">
                                <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Agregar Cine:</strong></label>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" name="txtNombre" value="${list.getNombre()}" class="form-control" placeholder="Nombre">
                                </div>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" id="start" name="txtUbicacion" value="${list.getUbicacion()}" class="form-control" placeholder="Ubicacion">
                                </div>
                            </div>
                            <div class="form-group d-flex">

                                <div class="col-sm-6">
                                    <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" id="start" name="txtTelefono" value="${list.getTelefono()}" class="form-control" placeholder="Telefono">
                                </div>
                            </div>
                            <!-- AGREGAR REGISTRO-->
                            <div class="form-group">
                                <div>
                                    <button type="submit" name="accion" value="agregar" class="btn btn-info" >Agregar Cine</button>
                                    <button type="submit" name="accion" value="actualizar" class="btn btn-dark"">Actualizar</button>
                                </div>
                            </div>
                            

                            <!-- AGREGAR REGISTRO-->

                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                    <div class="card-body" >

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>CODIGO </th>
                                    <th>CINE</th>
                                    <th>UBICACION</th>
                                    <th>TELEFONO</th>
                                    <th>   ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${cine}">
                                <tr>
                                    <td>${list.getIdCine()}</td>
                                    <td>${list.getNombre()}</td>
                                    <td>${list.getUbicacion()}</td>
                                    <td>${list.getTelefono()}</td>

                                    <td class="d-flex">
                                        <a class="btn btn-warning" href="Controlador?menu=Cine&accion=editar&codigoCine=${list.getIdCine()}" style="margin: 5px;" >Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=Cine&accion=eliminar&codigoCine=${list.getIdCine()}" style="margin: 5px;" onclick="return confirm('¿Esta seguro que quiere eliminar el dato?')" >Eliminar </a>
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
                var nombre = document.getElementsByName("txtNombre")[0].value;
                var ubicacion = document.getElementsByName("txtUbicacion")[0].value;
                var telefono = document.getElementsByName("txtTelefono")[0].value;

                // Verifica si alguno de los campos está vacío
                if (nombre === "" || ubicacion === "" || telefono === "") {
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
