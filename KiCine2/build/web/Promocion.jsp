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
    <center>
        <h1>Menu Promocion</h1>
    <div class="d-flex">
        <div class="col-sm-12">
            <br>
            <table class="table table-hober" style=" text-align: center">
                <thead>         
                    <tr>
                        <td>ID PROMOCION</td>
                        <td>NOMBRE PROMOCION</td>
                        <td>DESCRIPCION</td>
                        <td>PRECIO</td>
                        <td>ID PELICULA</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="promocion" items="${promocion}">
                        <tr>
                            <td>${promocion.getIdPromocion}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <br>
            <br>
           <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Promocion" method="POST">
                    <div>
                        <label>Nombre</label>
                        <input type="text" value="${promocion.getNombrePromocion()}" name="txtNombrePromocion" class="form-control">
                    </div>
                    <div>
                        <label>Descripcion</label>
                        <input type="text" value="${promocion.getDescripcion()}" name="txtDescripcion" class="form-control">
                    </div>
                    <div>
                        
                    </div>
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
