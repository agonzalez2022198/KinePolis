<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Horarios</title>
    </head>
    <br>
    <div class="d-flex">
        <div class="col-sm-5">
            <div class="card" style="background-color: #F8F8F8; border: none; border-radius: 3%">
                <form action="Controlador?menu=HorariosProyeccion" method="POST" onsubmit="return validarCampos()">
                    <div class="card-body">
                        <div class="form-group">
                            <label><Strong>&nbsp;&nbsp;&nbsp;&nbsp;Agregar Cine:</strong></label>
                        </div>
                        <div class="form-group d-flex">

                            <div class="col-sm-6">
                                <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" name="txtIdHorarioP" value="${list.getIdHorarioP()}" class="form-control" placeholder="Id">
                            </div>
                        </div>
                        <div class="form-group d-flex">

                            <div class="col-sm-6">
                                <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="time" id="start" name="txtHorario" value="${list.getHorario()}" class="form-control" placeholder="Horario">
                            </div>
                        </div>
                        <div class="form-group d-flex">

                            <div class="col-sm-6">
                                <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="date" id="start" name="txtFecha" value="${list.getFecha()}" class="form-control" placeholder="Fecha">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            
                            <div class="col-sm-6">
                                <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" id="start" name="txtDisponibilidadAsientos" value="${list.getDisponibilidadAsientos()}" class="form-control" placeholder="Asientos">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" id="start" name="txtSala_id" value="${list.getSala_id()}" class="form-control" placeholder="Id_Sala">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input style="border: none; background: transparent; border-bottom: 1px solid gray;" type="text" id="start" name="txtPelicula_id" value="${list.getPelicula_id()}" class="form-control" placeholder="Id_Pelicula">
                            </div>
                        </div>                                       
                        <!-- AGREGAR REGISTRO-->
                        <div class="form-group">
                            <div>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-info" >Agregar Horario</button>
                                <button type="submit" name="accion" value="Actualizar" class="btn btn-dark">Actualizar</button>
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
                                <th>Id </th>
                                <th>Horarios</th>
                                <th>Fechas</th>
                                <th>Asientos</th>
                                <th>Id_sala</th>
                                <th>Id_Pelicula</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${horarios}">
                                <tr>
                                    <td>${list.getIdHorarioP()}</td>
                                    <td>${list.getHorario()}</td>
                                    <td>${list.getFecha()}</td>
                                    <td>${list.getDisponibilidadAsientos()}</td>
                                    <td>${list.getSala_id()}</td>
                                    <td>${list.getPelicula_id()}</td>

                                    <td class="d-flex">
                                        <a class="btn btn-warning" href="Controlador?menu=HorariosProyeccion&accion=Editar&idHorarioP=${list.getIdHorarioP()}" style="margin: 5px;" >Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=HorariosProyeccion&accion=Eliminar&idHorarioP=${list.getIdHorarioP()}" style="margin: 5px;" onclick="return confirm('¿Esta seguro que quiere eliminar el dato?')" >Eliminar </a>
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

    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>