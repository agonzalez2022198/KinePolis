<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Promociones</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <h1 style="text-align: center">Promocion</h1>
        <br>
        <br>
        <br>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    
                    <form action="Controlador?menu=Promocion" method="POST">
                        <div class="form-group">
                            <label>Nombre Promocion</label>
                            <input type="text" value="${promocion.getNombre_Promopcion()}" name="txtNombre_Promopcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Descripcion</label>
                            <input type="text" value="${promocion.getDescripcion()}" name="txtDescripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Fecha de Validez</label>
                            <input type="text" value="${promocion.getFechas_promocion()}" name="txtFechas_promocion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Codigo Promocion</label>
                            <input type="text" value="${promocion.getCodigo_promocion()}" name="txtCodigo_promocion" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info" href="Controlador?menu=Promocion&accion=Agregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success" href="Controlador?menu=Promocion&accion=Actualizar&idPromocion">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hober">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Nombre</td>
                            <td>Descripcion</td>
                            <td>Fecha de Validez</td>
                            <td>Codigo Promocion</td>
                            <td>Accion</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="promocion" items="${promocion}">
                        <tr>
                            <td>${promocion.getIdPromocion()}</td>
                            <td>${promocion.getNombre_promopcion()}</td>
                            <td>${promocion.getDescripcion()}</td>
                            <td>${promocion.getFechas_validez()}</td>
                            <td>${promocion.getCodigo_promocion()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Promocion&accion=Editar&IdPromocion=${cliente.getCodigoCliente()}">Editar</a>
                                <a class="btn btn-danger" onclick="return confirm('¿ESTAS SEGURO QUE DESEAS ELIMINAR ESTE REGISTRO?')" href="Controlador?menu=Clientes&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}">Eliminar</a>
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
